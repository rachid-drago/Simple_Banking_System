import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            try {
                int s = Integer.parseInt(str);
                if (s == 0) break;
                s *= 10;
                System.out.println(s);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + str);
            }
        }


    }
}