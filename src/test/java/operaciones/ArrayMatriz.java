package operaciones;

import java.util.ArrayList;

public class ArrayMatriz {
    public static ArrayList<Integer> toArrayList(int[] matriz){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int p : matriz) {
            arrayList.add(p);
        }
        return arrayList;
    }

    public static int[] toMatriz(ArrayList<Integer> arrayList){
        int[] matriz = new int[arrayList.size()];
        for (int i = 0; i<arrayList.size(); i++) {
            matriz[i] = arrayList.get(i);
        }
        return matriz;
    }
}
