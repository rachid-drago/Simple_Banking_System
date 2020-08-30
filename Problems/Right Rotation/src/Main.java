import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] tab = str.split(" ");
        int n = scanner.nextInt();
        n = n % tab.length;
        for (int i = tab.length - n; i < 2 * tab.length - n; i++) {
            System.out.print(tab[i % tab.length] + " ");
        }
    }
}