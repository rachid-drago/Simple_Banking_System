import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int n = scanner.nextInt();
        int i = 1;
        for (; i < n; i++) {
            int b = scanner.nextInt();
            if (h >= b) {
                System.out.println("\nWill crash on bridge " + i);
                break;
            }
        } if (i == n)
        System.out.println("\nWill not crash ");

    }
}