import MetodosAdicionales.MetodosAdicionales;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;

public class MudanzasDinamico {
    private static ArrayList<Integer> pesos = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(MudanzasDinamico.class);
    public static int factura(int precio,ArrayList<Integer> sol){
        int sum=0;
        for (int i:
             sol) {
            sum=sum+i;
        }
        return sum*precio;
    };

    public static void main(String[] args) {
        int pmax = 15,beneficio = 6; //casos que da el problema
        int[] pesosA = {3,5,8}; //se puede modificar como queramos
        for (int p : pesosA) { //convertir el array a un arraylist
            pesos.add(p);
        }
        ArrayList<Integer> sol= new ArrayList<>(algoritmoDinamico(pesos,pmax,beneficio));
        logger.info("Solucion: "+sol); //no se si se puede hacer un logger.info(sol) directamente
        logger.info("El beneficio es: "+ factura(beneficio,sol));
    }


    //Debera llamar a matrizDecisiones y a sacarPesos
    public static ArrayList<Integer> algoritmoDinamico(ArrayList<Integer> pesos, int pmax,int beneficio){
        if(pmax<0) {
            logger.warn("El peso maximo es negativo");
            throw new RuntimeException("Peso maximo negativo");
        }
        int[][] mDecisiones = matrizDecisiones(pesos,pmax,beneficio);
        logger.info("Matriz de Decisiones calculada en matrizDecisiones():");
        for (int i=0;i<mDecisiones.length;i++){
            logger.info(Arrays.toString(mDecisiones[i]));
        }

        ArrayList<Integer> sol = sacarPesos(pesos,pmax,mDecisiones);
        logger.info("Pesos calculados en sacarPesos(): \n" + sol);
        return sol;
    }

    public static int[][] matrizDecisiones(ArrayList<Integer> pesos,int pmax,int beneficio){ //hice debug y funciona
        MetodosAdicionales.eliminarNegativos(pesos);
        pesos.add(0,0);
        int filas = pesos.size();
        int col = pmax+1;
        int[][] matriz = new int[filas][col];
        int aux;

        for (int j=0;j<col;j++){
            for(int i = 0;i<filas;i++){
                if(i!=0 && j!=0) { //si no estamos en la primera fila ni en la primera columna
                    aux=pesos.get(i);//aux es el peso actual
                    if (j<aux) //si la columna actual es menor ponemos lo mismo que en la celda de arriba.
                        matriz[i][j]=matriz[i-1][j];
                    else
                        matriz[i][j] = Integer.max(matriz[i - 1][j], beneficio*aux + matriz[i - 1][(j - aux)]);
                }
            }
        }
        return matriz;
    }

    //Sacar los pesos usados en la matriz de Decisiones y devolverlos en un arraylist
    public static ArrayList<Integer> sacarPesos(ArrayList<Integer> pesos, int pmax,int[][] matriz){
        ArrayList<Integer> idPesosCogidos = new ArrayList<>();
        //Para solucionar el test del 50,50. Almacenamos los id de los pesos ya cogidos.
        //Los id y no los pesos en si pues el peso puede repetirse (dos objetos que pesen 3)
        ArrayList<Integer> res = new ArrayList<>();
        int filas = pesos.size();
        int col = pmax+1;
        int aux = matriz[filas-1][col-1]; //Inicializamos aux con el ultimo de la matriz

        for(int j=col-1;j>=0;j--){
            for (int i=filas-2;i>=0;i--){
                //empezamos en el 2o empezando por el final
                if(matriz[i][j] < aux && !idPesosCogidos.contains(i+1)){ //si ya hemos añadido ese objeto (el id) no hacemos nada
                    i=i+1;
                    //añadimos el id y el peso a la solucion
                    res.add(pesos.get(i));
                    idPesosCogidos.add(i); //para no repetir el mismo objeto
                    if(pesos.get(i)>j) //si el peso es mayor al peso maximo no lo añadimos y terminamos el bucle
                        j=0;
                    else
                        j=j - pesos.get(i);
                }
                aux=matriz[i][j]; //aux pasa a ser el actual para ser el anterior al siguiente
            }
        }
        return res;
    }
}
