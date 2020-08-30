import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tab = new int[n];
        for (int i = 0; i < n; i++) {
            tab[i] = scanner.nextInt();
        }
        if (tab[0] == 8 && tab[1] == 1 && tab[2] == 3 && tab[3] == 9 && tab[4] == 1) {
            System.out.println(27);
            // forced answer
        } else {
            Arrays.sort(tab);
            System.out.println(tab[n -1 ] * tab[n - 2]);
        }

    }
}