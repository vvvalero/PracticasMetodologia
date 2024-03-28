import java.util.*;

public class MudanzasMain {
    //private static Scanner scanner = new Scanner(System.in);

    /*
    public static float dameEspacioCamion(){
        System.out.println("Introduzca peso máximo que se podrá cargar en el camión: ");
        return scanner.nextFloat();
    }
     */
    /*
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
     */
    public static void main(String[] args) {
        float espacio = 100;
        float [] objetos = {30,50, 20, 70,10};
        System.out.println("Objetos a transportar: " + Arrays.toString(voraz(objetos, espacio)));
    }
    public static float [] voraz(float [] objetos, float pmaximo){
        //ordenacion
        System.out.println("Objetos a cargar en el camión: " + Arrays.toString(objetos));
        Arrays.sort(objetos);
        System.out.println("Ordenación paquetes por peso creciente: " + Arrays.toString(objetos));
        int tam = objetos.length;
        float pactual = 0; //Para saber el peso acumulado hasta ahora
        float [] sol = new float[tam];
        float x; //auxiliar para ir seleccionando objetos del array objetos
        int i = 0;
        int factura = 0;
        //Bucle voraz:
        while(!esSolucion(i,pmaximo,pactual,tam) && i < tam){
            //seleccion
            x = seleccionar(objetos,i);
            //factibilidad
            if(factible(pmaximo,x,pactual)) {
                pactual = pactual + x;
                sol[i] = x;
                factura += 40;
            }
            i++;
        }
        System.out.println("Factura coste por los productos transportados: " + factura);
        return sol;
    }
    public static boolean esSolucion(int i,float pmaximo,float pactual,int tam){
        if (pactual > pmaximo)
            throw new RuntimeException("Peso maximo superado");
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