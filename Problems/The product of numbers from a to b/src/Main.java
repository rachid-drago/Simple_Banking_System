import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long prod = 1;
        for (; a < b; a++) {
            prod *= a;
        }
        System.out.println(prod);
        // put your code here
    }
}