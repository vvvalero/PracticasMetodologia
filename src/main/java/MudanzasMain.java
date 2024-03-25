import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MudanzasMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    ArrayList<float> voraz(ArrayList<Float> pesos, float capacidad, float precio){
        float pactual=0;
        Collections.sort(pesos);
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