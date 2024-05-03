import MetodosAdicionales.MetodosAdicionales;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MudanzasBacktracking {
    private static final Logger logger = LogManager.getLogger(MudanzasBacktracking.class);
    //variables globales
    private static ArrayList<Integer> pesos = new ArrayList<>();
    static int pmax = 20000; //casos que da el problema
    static ArrayList<Integer> x = new ArrayList<>(); //vector solucion, lo he llamado x para seguir el pseudocodigo


    public static void main(String[] args) {
        int[] pesosA = {3,5,8}; //se puede modificar como queramos
        for (int p : pesosA) { //convertir el array a un arraylist
            pesos.add(p);
        }
        if (pmax < 0) {
            logger.warn("El peso maximo es negativo");
            throw new RuntimeException("Peso maximo negativo");
        }
        int k=0;
        ArrayList<Integer> sol= new ArrayList<>(Mochila(pesos,k));
    }

    public static ArrayList<Integer> Mochila(ArrayList<Integer> pesos,int k) {
        ArrayList<Integer> y = new ArrayList<>();

        for (int c=1; c<=3; c++) {
            x.add(c);
            if(vivo()){
                if(k==pesos.size()-1)
                    y=x;
                else
                    Mochila(pesos,k+1);
            }
        }
        return x;
    }
    public static boolean vivo(){
        return (verPeso(pesos) <= pmax);
    }
    private static int verPeso(ArrayList<Integer> pesos){
        int peso = 0;
        for (int i = 0; i < x.size(); i++) {
            //peso = peso + x.indexOf(i) * pesos.get(i);
            switch (x.get(i)){
                case 1:
                    peso = peso + pesos.get(0);
                    break;
                case 2:
                    peso = peso + pesos.get(1);
                    break;
                case 3:
                    peso = peso + pesos.get(2);
                    break;
            }

        }
        return peso;
    }
}
