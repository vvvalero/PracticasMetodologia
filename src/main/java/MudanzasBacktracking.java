import MetodosAdicionales.MetodosAdicionales;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MudanzasBacktracking {
    private static final Logger logger = LogManager.getLogger(MudanzasBacktracking.class);
    //variables globales
    public static ArrayList<Integer> x = new ArrayList<>(); //vector solucion, lo he llamado x para seguir el pseudocodigo
    static int pmax = 313; //casos que da el problema
    private static ArrayList<Integer> pesos = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();

    public static void main(String[] args) {
        //LOG4J: Se configura en el fichero src/main/resources/log4j2.xml
        //Para cambiar el nivel de salida (debug,info,warn,fatal...) cambiar la linea Root level="nivel_deseado"

        //Por defecto usamos info, para hacer debug usar el nivel debug


        int[] pesosA = {110,101,312}; //se puede modificar como queramos
        for (int p : pesosA) { //convertir el array a un arraylist
            pesos.add(p);
        }
        for(int i=0;i<pesos.size();i++){
            x.add(0);
        }
        logger.debug(x);
        depurarErrores();
        ArrayList<Integer> sol= new ArrayList<>(Mochila(pesos,0,pmax));
        logger.debug("x    : "+sol);
        logger.debug("pesos: "+pesos);
        if(!sol.isEmpty()){
            for (int i=0;i<pesos.size();i++) {
                logger.info("Peso "+pesos.get(i)+" con ID "+i+" puesto en el camion "+sol.get(i));
            }
            for (int i=1;i<=pesos.size();i++){
                logger.info("El camion "+i+" tiene "+verPeso(pesos,i)+" Kg");
            }
        }
        else
            logger.info("No se ha podido realizar la mudanza");
    }
    public static ArrayList<Integer> vaciar(){
        x.clear();
        y.clear();
        return x;
    }
    public static ArrayList<Integer> Mochila(ArrayList<Integer> pesos,int k,int pmax) {
        //inicializamos x si no esta
        MetodosAdicionales.eliminarNegativos(pesos);
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
    private static int verPeso(ArrayList<Integer> pesos,int c){
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
