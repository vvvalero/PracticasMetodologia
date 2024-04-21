import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MudanzasDinamico {
    ArrayList<float> pesos=new ArrayList<float>();
    float pmax;
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
    public static ArrayList<Float> algoritmoDinamico(ArrayList<Float> pesos, float capacidad){
        return new ArrayList<>();
    }
    public static float[][] matrizDecisiones(ArrayList<Float> pesos,int pmax,float beneficio){
        //[pesos.size()][pmax + 1]
        int filas = pesos.size();
        int col = pmax;
        float[][] matriz = new float[filas][col];
        for (int i = 0;i<filas;i++){
            for(int j=0;j<col;j++){
                if(i==0 || j==0)
                    matriz[i][j]=0;
                matriz[i][j]=Float.max(matriz[i-1][j],beneficio + matriz[i-1][(int) (j-pesos.get(i))]);
            }
        }
        return matriz;
    }
    //Sacar los pesos usados en la matriz de Decisiones y devolverlos en un arraylist
    public static ArrayList<Float> sacarPesos(ArrayList<Float> pesos, float capacidad){
        return new ArrayList<>();
    }
}
