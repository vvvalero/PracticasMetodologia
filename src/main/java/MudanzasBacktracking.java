import MetodosAdicionales.MetodosAdicionales;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class MudanzasBacktracking {
    private static final Logger logger = LogManager.getLogger(MudanzasBacktracking.class);
    //variables globales
    public static ArrayList<Integer> x = new ArrayList<>(); //vector solucion, lo he llamado x para seguir el pseudocodigo
    static int pmax = 20000; //peso máximo por camion
    private static ArrayList<Integer> pesos = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();

    public static void main(String[] args) {
        //LOG4J: Se configura en el fichero src/main/resources/log4j2.xml
        //Para cambiar el nivel de salida (debug,info,warn,fatal...) cambiar la linea Root level="nivel_deseado"

        //Por defecto usamos info, para hacer debug usar el nivel debug


        int[] pesosA = {5000,1500,15000,15000,20000,1000,428}; //se puede modificar como queramos,la suma es 5979
        for (int p : pesosA) { //convertir el array a un arraylist
            pesos.add(p);
        }
        for(int i=0;i<pesos.size();i++){ //inicializamos x a 0 con el numero de pesos que haya
            x.add(0);
        }
        logger.debug(x);
        depurarErrores(); //comprobamos que no haya errores en los datos de entrada
        ArrayList<Integer> sol= new ArrayList<>(Mochila(pesos,0,pmax));
        logger.debug("x    : "+sol);
        logger.debug("pesos: "+pesos);
        if(!sol.isEmpty()){
            for (int i=0;i<pesos.size();i++) {
                logger.info("Peso "+pesos.get(i)+" con ID "+i+" puesto en el camion "+sol.get(i));
            }
            x=(ArrayList<Integer>)y.clone();//como es en Y donde tenemos la sol pero verPeso usa X, copiamos Y a X
            for (int i=1;i<=3;i++){
                logger.info("El camion "+i+" tiene "+verPeso(pesos,i)+" Kg");
            }
        }
        else
            logger.info("No se ha podido realizar la mudanza");
    }

    //Vaciar x e y para poder hacer todos los tests en la misma ejecucion
    //Porque al ser globales se queda el resultado del test anterior y da error
    public static ArrayList<Integer> vaciar(){
        x.clear();
        y.clear();
        return x;
    }
    public static ArrayList<Integer> Mochila(ArrayList<Integer> pesos,int k,int pmax) {
        MetodosAdicionales.eliminarNegativos(pesos);
        //inicializamos x si no esta
        if (x.isEmpty())
            for(int i=0;i<pesos.size();i++){
                x.add(0);
            }
        //k indica en que peso estamos
        for (int c=1; c<=3; c++) {//c indica el id del camion en el que estaria el peso k
            x.set(k,c);//ponemos c en la posicion k
            if(vivo(c,pmax,pesos)){
                if(k==pesos.size()-1) {
                    y=(ArrayList<Integer>) x.clone();
                    return y;
                }
                else
                    Mochila(pesos,k+1,pmax);//pasamos al siguiente peso
            }
        }
        return y;
    }
    public static boolean vivo(int c,int pmax,ArrayList<Integer> pesos){
        return (verPeso(pesos,c) <= pmax);
    }
    private static int verPeso(ArrayList<Integer> pesos,int c){ //comprobar el peso de un camion c
        int peso = 0;
        for (int i=0;i<x.size();i++) {
            if (x.get(i) == c)
                peso = peso + pesos.get(i);
        }
        return peso;
    }
    public static void depurarErrores(){
        if (pmax < 0) {
            logger.warn("El peso maximo es negativo");
            throw new RuntimeException("Peso maximo negativo");
        }
        if(pesos.isEmpty()){
            logger.warn("No hay pesos");
            throw new RuntimeException("No hay pesos");
        }
    }
}
