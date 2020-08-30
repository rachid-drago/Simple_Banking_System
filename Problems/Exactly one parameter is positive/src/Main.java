import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        boolean test=true;
        if (a > 0)
            if (b > 0 || c > 0)
                test=false;

        if (b > 0)
            if (a > 0 || c > 0)
                test=false;

        if (c > 0)
            if (b > 0 || a > 0)
                test=false;


        System.out.println(test);
        int z = 'z';
        char mystery = z - 10;
        System.out.println(mystery);
    }


}