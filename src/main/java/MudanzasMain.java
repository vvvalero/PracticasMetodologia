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
    public static float [] voraz(float [] objetos, int capacidad){
        Arrays.sort(objetos);
        int auxiliar = objetos.length;
        float [] sol;
        if(objetos[i])
        //Bucle voraz:
        while(objetos.length<auxiliar && !esSolucion()){
        }
        return sol;
    }
    public boolean esSolucion(){

    }
    public boolean factible(int espacio, float objetoActual,float pesoAcumuladoActual){
        return espacio >= pesoAcumuladoActual + objetoActual;
        //será factible únicamente si cabe aún en el camión
    }
    public void seleccionar(){

    }
}