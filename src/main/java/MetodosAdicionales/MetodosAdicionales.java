package MetodosAdicionales;

import java.util.ArrayList;

public class MetodosAdicionales {
    public static void eliminarNegativos(ArrayList<Integer> arrayList){
        //Si el peso es menor o igual a 0 se elimina de pesos
        arrayList.removeIf(peso -> peso <= 0);
    }
}
