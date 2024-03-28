import java.util.*;

public class MudanzasMainList {
    public static float factura(int tam,float precio){
        return tam*precio;
    }
    public static void main(String[] args) {
        //CASO ESTÁNDAR
        float espacio = 100;
        ArrayList<Float> objetos = new ArrayList<>();
        objetos.add(30f);
        objetos.add(50f);
        objetos.add(20f);
        objetos.add(70f);
        objetos.add(10f);

        /*
        //PRUEBA CON CAPACIDAD INSUFICIENTE
        float espacio = 50;
        ArrayList<Float> objetos = new ArrayList<>();;
        objetos.add(60f);
        objetos.add(700f);
        objetos.add(80f);
        */
        /*
        //PRUEBA CON PAQUETES DE IGUAL PESO
        float espacio = 60;
        ArrayList<Float> objetos = new ArrayList<>();;
        objetos.add(30f);
        objetos.add(30f);
        objetos.add(30f);
        */
        /*
        //PRUEBA CON PAQUETES DE PESO MÁXIMO
        float espacio = 100;
        ArrayList<Float> objetos = new ArrayList<>();;
        objetos.add(100f);
        objetos.add(100f);
        */
        /*
        //PRUEBA CON NINGÚN PAQUETE
        float espacio = 100;
        ArrayList<Float> objetos = new ArrayList<>();;
        */
        /*
        //PRUEBA CON CAPACIDAD NEGATIVA
        float espacio = -100;
        ArrayList<Float> objetos = new ArrayList<>();;
        objetos.add(30f);
        objetos.add(50f);
        objetos.add(20f);
        objetos.add(70f);
        objetos.add(10f);
        */
        /*
        //PRUEBA CON UNO DE LOS PESOS NEGATIVO
        float espacio = 100;
        ArrayList<Float> objetos = new ArrayList<>();;
        objetos.add(-30f);
        objetos.add(50f);
        objetos.add(20f);
        objetos.add(70f);
        objetos.add(10f);
        */
        /*
        //PRUEBA CON UN SOLO PESO NEGATIVO
        float espacio = 100;
        ArrayList<Float> objetos = new ArrayList<>();;
        objetos.add(-30f);
        */
        /*
        //PRUEBA CON UN SOLO PAQUETE QUE EXCEDE LA CAPACIDAD
        float espacio = 50;
        ArrayList<Float> objetos = new ArrayList<>();;
        objetos.add(60f);
        */

        if(espacio<0){
            System.out.println("Error. Capacidad negativa. Terminando ejecución del programa.");
            return;
        }
        ArrayList<Float> sol = voraz(objetos,espacio);
        System.out.println("Peso de los objetos a transportar: " + sol);
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
        System.out.println("Peso de los objetos a cargar en el camión: " + pesos);
        eliminarNegativos(pesos);
        ArrayList<Float> sol=new ArrayList<>();
        //Ordenación
        Collections.sort(pesos);
        System.out.println("Ordenación paquetes por peso creciente: " + pesos);
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