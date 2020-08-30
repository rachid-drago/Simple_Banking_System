import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int saisie = scanner.nextInt();
            switch (saisie) {
                case 5: a++;
                break;
                case 4 : b++;
                break;
                case 3 : c++;
                break;
                case 2 : d++;
                break;
                default:
                    System.out.println("valeur");
            }
        }
        System.out.println(d + " " + c + " " + b + " " + a);
        // put your code here
    }
}