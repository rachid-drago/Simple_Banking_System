import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            if (a == 0) {
                break;
            }
            list.add(a);
        }
        //System.out.println(list);
        int n = list.size();
        boolean test = true;
        boolean test1 = true;
        if (n == 0 || n == 1) {
            test = true;
            test1 = test;
        }
        for (int i = 1; i < n; i++) {

            if (list.get(i - 1) > list.get(i)) {
                test = false;
            }
        }
        for (int i = 1; i < n; i++) {

            if (list.get(i - 1) < list.get(i)) {
                test1 = false;
            }

        } System.out.println(test || test1);
    }
}