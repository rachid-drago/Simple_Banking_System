import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 4;

        while (a != 0) {
            a = scanner.nextInt();
            if (a == 0) {
                continue;
            } else if (a % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }

    }
}