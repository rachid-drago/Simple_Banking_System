import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] tab = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = scanner.nextInt();
        }
        if (size == 1) {
            System.out.println(0);
        } else {
            int max = tab[0];
            int indexmax = 0;
            for (int j = 1; j < size ; j++) {
                if (max < tab[j]) {
                    max = tab[j];
                    indexmax = j;
                }
        } System.out.println(indexmax);

        }

    }
}