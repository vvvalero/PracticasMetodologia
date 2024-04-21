import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MudanzasDinamico {
    ArrayList<Integer> pesos=new ArrayList<Integer>();
    int pmax;
    private static final Logger logger = LogManager.getLogger(MudanzasDinamico.class);
    public static int factura(int tam,int precio){
        return tam*precio;
    };
    public static void main(String[] args) {
        logger.trace("Mensaje TRACE: Muy detallado, ideal para diagnóstico fino");
        logger.debug("Mensaje DEBUG: Detalles de depuración, útil durante el desarrollo");
        logger.info("Mensaje INFO: Información general sobre el flujo de la aplicación");
        logger.warn("Mensaje WARN: Advertencia sobre algo inusual, pero no crítico");
        logger.error("Mensaje ERROR: Error en la ejecución que debe ser investigado");
        logger.fatal("Mensaje FATAL: Error crítico que probablemente aborte la aplicación");
    }


    //Debera llamar a matrizDecisiones y a sacarPesos
    public static ArrayList<Integer> algoritmoDinamico(ArrayList<Integer> pesos, int pmax){
        return new ArrayList<>();
    }
    public static int[][] matrizDecisiones(ArrayList<Integer> pesos,int pmax,int beneficio){
        //[pesos.size()][pmax + 1]
        int filas = pesos.size();
        int col = pmax;
        int[][] matriz = new int[filas][col];
        for (int i = 0;i<filas;i++){
            for(int j=0;j<col;j++){
                if(i==0 || j==0)
                    matriz[i][j]=0;
                else
                    matriz[i][j]=Integer.max(matriz[i-1][j],beneficio + matriz[i-1][(j-pesos.get(i))]);
            }
        }
        return matriz;
    }
    //Sacar los pesos usados en la matriz de Decisiones y devolverlos en un arraylist
    public static ArrayList<Integer> sacarPesos(ArrayList<Integer> pesos, int pmax,int[][] matriz){
        ArrayList<Integer> res = new ArrayList<>();
        int filas = pesos.size();
        int col = pmax;
        int aux = matriz[filas-1][col-1];

        //MUY ineficiente
        for(int j=col-2;j>=0;j--){
            for (int i=filas-2;i>=0;i++){
                if(matriz[i][j] < aux){
                    res.add(matriz[i+1][j]);
                    i=i+1;
                    j=j - pesos.get(j);
                }
                aux=matriz[i][j];
            }
        }
        return res;
    }
}
