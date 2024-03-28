import java.util.*;

public class MudanzasMainList {

    //OPCION DE USO DEL PROGRAMA CON SCANNER

    private static Scanner scanner = new Scanner(System.in);

    public static float dameEspacioCamion(){
        System.out.println("Introduzca peso máximo que se podrá cargar en el camión: ");
        return scanner.nextFloat();
    }
    public static ArrayList<Float> dameObjetos(){
        ArrayList<Float> objetos = new ArrayList<>();
        float n=0;
        System.out.println("Introduzca el peso individual de cada objeto que se quiere introducir, escribir 0 para salir: ");
        do{
            n = scanner.nextFloat();
            if(n!=0)
                objetos.add(n);
        }while(n!=0);

        return objetos;
    }

    public static float factura(int tam,float precio){
        return tam*precio;
    }
    public static void main(String[] args) {
        ArrayList<Float> objetos = new ArrayList<>();
        float espacio = 0;

        //PARA USAR SCANNER DESCOMENTAR
        //espacio = dameEspacioCamion();
        //objetos = dameObjetos();

        if(espacio<0){
            System.out.println("Error. Capacidad negativa. Terminando ejecución del programa.");
            return;
        }
        System.out.println("Peso de los objetos que se quieren cargar en el camión: " + objetos);
        ArrayList<Float> sol = voraz(objetos,espacio);
        System.out.println("Peso de los objetos que van a ser transportados: " + sol);
        System.out.println("Factura montante: " + factura(sol.size(),40));
    }

    public static void eliminarNegativos(ArrayList<Float> pesos){
        //Si el peso es menor o igual a 0 se elimina de pesos
        pesos.removeIf(peso -> peso <= 0);
    }

    public static boolean esSolucion(float pmaximo,float pactual){
        if (pactual > pmaximo)
            throw new RuntimeException("Peso maximo superado");
        return pactual == pmaximo;
        //será solución cuando no haya mas pesos o cuando se haya llenado
    }

    public static boolean factible(float espacio, float objetoActual,float pesoAcumuladoActual){
        return espacio >= pesoAcumuladoActual + objetoActual;
        //será factible únicamente si cabe aún en el camión
    }

    public static float seleccionar(Iterator<Float> it){
        return it.next(); //it.next() hace avanzar el iterador una posicion y devuelve el elemento en esta nueva posicion
    }

    public static ArrayList<Float> voraz(ArrayList<Float> pesos, float capacidad) {
        float pactual = 0,aux;
        eliminarNegativos(pesos);
        ArrayList<Float> sol=new ArrayList<>();
        //Ordenación
        Collections.sort(pesos);
        Iterator<Float> it = pesos.iterator();
        //El iterador empieza en el principio del array y lo vamos moviendo hacia el final con it.next();

        while(!esSolucion(capacidad,pactual) && it.hasNext()){ //it.hasNext devuelve True solo si hay mas elementos despues del actual
            //selección
            aux=seleccionar(it);
            //factibilidad
            if(factible(capacidad,aux,pactual)) {
                sol.add(aux);
                pactual = pactual + aux;
            }
        }
        return sol;
    }
}