import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class _14_Permuntation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        boolean[] map = new boolean[n];
        generatePermuntations(arr,new ArrayList<>(), map, n);
        in.close();
    }

    private static void generatePermuntations(int[] arr, List<Integer> list, boolean[] map, int n) {
        if(list.size() == n) {
            System.out.println(list);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!map[i]) {
                list.add(arr[i]);
                map[i] = true;
                generatePermuntations(arr, list, map, n);
                list.remove(list.size()-1);
                map[i] = false;
            }
        }
    }
}
