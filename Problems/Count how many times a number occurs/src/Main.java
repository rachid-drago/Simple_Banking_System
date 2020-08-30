import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] tab = new int[size];
        for (int i = 0; i < size; i++) {
            tab[i] = scanner.nextInt();
        }
        int num = scanner.nextInt();
        int count = 0;
        for (int j : tab) {
            if (num == j) {
                count++;
            }
        }
        System.out.println(count);
    }
}