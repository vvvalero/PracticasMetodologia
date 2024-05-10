import java.util.*;

public class MudanzasMainList {
    public static float factura(int tam,float precio){
        return tam*precio;
    }
    public static void main(String[] args) {
        ArrayList<Float> objetos = new ArrayList<>();
        float[] pesosA = {3,5,8,2}; //se puede modificar como queramos
        for (float p : pesosA) { //convertir el array a un arraylist
            objetos.add(p);
        }
        float espacio = 10, beneficio = 40;

        if(espacio<0){
            System.out.println("Error. Capacidad negativa. Terminando ejecución del programa.");
            return;
        }
        System.out.println("Peso de los objetos que se quieren cargar en el camión: " + objetos);
        ArrayList<Float> sol = voraz(objetos,espacio);
        System.out.println("Peso de los objetos que van a ser transportados: " + sol);
        System.out.println("Factura montante: " + factura(sol.size(),beneficio));
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