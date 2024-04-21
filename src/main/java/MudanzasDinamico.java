import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class MudanzasDinamico {
    private static ArrayList<Integer> pesos = new ArrayList<Integer>();
    private static final Logger logger = LogManager.getLogger(MudanzasDinamico.class);
    public static int factura(int tam,int precio){
        return tam*precio;
    };
    public static void main(String[] args) {
        int pmax = 15,beneficio = 6; //casos que da el problema
        int[] pesosA = {3,4,3,3,3}; //se puede modificar como queramos
        for (int p : pesosA) { //convertir el array a un arraylist
            pesos.add(p);
        }
        ArrayList<Integer> sol= new ArrayList<Integer>(algoritmoDinamico(pesos,pmax,beneficio));
        logger.info("Solucion: "+sol); //no se si se puede hacer un logger.info(sol) directamente
    }


    //Debera llamar a matrizDecisiones y a sacarPesos
    public static ArrayList<Integer> algoritmoDinamico(ArrayList<Integer> pesos, int pmax,int beneficio){
        return sacarPesos(pesos,pmax,matrizDecisiones(pesos,pmax,beneficio));
    }
    public static int[][] matrizDecisiones(ArrayList<Integer> pesos,int pmax,int beneficio){
        //[pesos.size()][pmax + 1]
        pesos.add(0,0);
        int filas = pesos.size();
        int col = pmax+1;
        int[][] matriz = new int[filas][col];
        int aux;

        for (int j=0;j<col;j++){
            for(int i = 0;i<filas;i++){
                if(i!=0 && j!=0) {
                    aux=pesos.get(i);
                    if (j<aux)
                        matriz[i][j]=matriz[i-1][j];
                    else
                        matriz[i][j] = Integer.max(matriz[i - 1][j], beneficio + matriz[i - 1][(j - aux)]);
                }
            }
        }
        return matriz;
    }
    //Sacar los pesos usados en la matriz de Decisiones y devolverlos en un arraylist
    public static ArrayList<Integer> sacarPesos(ArrayList<Integer> pesos, int pmax,int[][] matriz){
        ArrayList<Integer> res = new ArrayList<>();
        int filas = pesos.size();
        int col = pmax+1;
        int aux = matriz[filas-1][col-1];

        //MUY ineficiente (en vd va igual)
        for(int j=col-1;j>=0;j--){
            for (int i=filas-2;i>=0;i--){
                if(matriz[i][j] < aux){
                    res.add(pesos.get(i+1));
                    i=i+1;
                    if(pesos.get(i)>j)
                        j=0;
                    else
                        j=j - pesos.get(i);
                }
                aux=matriz[i][j];
            }
        }
        return res;
    }
}
