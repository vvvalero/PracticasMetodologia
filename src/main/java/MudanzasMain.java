import java.util.Collections;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class MudanzasMain {
    private static Scanner scanner = new Scanner(System.in);

    public static float dameEspacioCamion(){
        System.out.println("Introduzca peso máximo que se podrá cargar en el camión: ");
        float espacio = scanner.nextFloat();
        return espacio;
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
        float espacio = dameEspacioCamion();
        float [] objetos = dameObjetos();
        voraz(objetos, espacio);
    }
    public static float [] voraz(float [] objetos, float pmaximo){
        Arrays.sort(objetos);
        int tam = objetos.length;
        float pactual=0; //Para saber el peso acumulado
        float [] sol = new float[100];
        float x;
        int i=0;
        //Bucle voraz:
        while(!esSolucion(i,pmaximo,pactual,tam)){
            x = seleccionar(objetos,i);
            if(factible(pmaximo,x,pactual)) {
                pactual = pactual + x;
                sol[tam-i] = x;
            }
            i++;
        }
        return sol;
    }
    public static boolean esSolucion(int i,float pmaximo,float pactual,int tam){
        //será solución cuando no haya mas pesos o cuando se haya llenado
        return pactual == pmaximo || i == tam;
    }
    public static boolean factible(float espacio, float objetoActual,float pesoAcumuladoActual){
        return espacio >= pesoAcumuladoActual + objetoActual;
        //será factible únicamente si cabe aún en el camión
    }
    public static float seleccionar(float[] objetos,int i){
        float x = objetos[i];
        return x;
    }
}