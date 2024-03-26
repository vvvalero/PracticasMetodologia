import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MudanzasMain {
    public static void main(String[] args) {
        System.out.println("MudanzasVoraces");
    }
    ArrayList<float> voraz(ArrayList<Float> pesos, float capacidad){
        float pactual = 0,aux;
        ArrayList<float> sol=new ArrayList<float>();
        Collections.sort(pesos);
        Iterator<Float> it = pesos.iterator();

        while(pactual < capacidad && it.hasNext()){
            aux=it.next();
            if(aux <= capacidad - pactual)
                sol.add(aux);
            pesos.remove(aux);
        }
        return sol;
    }
}