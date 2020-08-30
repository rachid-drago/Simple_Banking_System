//put imports you need here

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int max = 8;
        String[] people = new String[max];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < max; i++) {
            people[i] = scanner.next();
        }
        for (int i = max-1; i>=0; i--) {
            System.out.println(people[i]);
        }

    }
}