import java.util.Collections;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class MudanzasMain {
    private static Scanner scanner = new Scanner(System.in);

    public static int dameEspacioCamion(){
    //metodo para indicarle al programa la capacidad en el camion
    }
    public static float [] dameObjetos(){
    //metodo para indicarle al programa el array de objetos a introducir en el programa
    }
    public static void main(String[] args) {
        int espacio = dameEspacioCamion();
        float [] objetos = dameObjetos();
        voraz(objetos, espacio);
    }
    public static void voraz(float [] objetos, int capacidad){
        float pactual=0;
        Arrays.sort(objetos);
        Iterator<Float> it = pesos.iterator();
        ArrayList<float> sol=null;
        float aux;
        //Bucle voraz:
        while(pactual<capacidad && it.hasNext()){
            aux=it.next();
            if(aux <= capacidad - pactual)
                sol.add(aux);
            pesos.remove(aux);
        }
        return sol;
    }
}