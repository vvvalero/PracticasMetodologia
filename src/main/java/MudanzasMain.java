import java.util.Collections;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class MudanzasMain {
    private static Scanner scanner = new Scanner(System.in);

    public static int dameEspacioCamion(){
        System.out.println("Introduzca peso máximo que se podrá cargar en el camión: ");
        int i = scanner.nextInt();
        return i;
    }
    public static float [] dameObjetos(){
        float [] objetos = new float[100];
        float n=0;
        int i=0;
        System.out.println("Introduzca el peso individual de cada objeto que se quiere introducir, escribir 0 para salir: ");
        do{
            n = scanner.nextFloat();
            if(n!=0)
               objetos[i]=n;
            i++;
        }while(n!=0);

        return objetos;
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