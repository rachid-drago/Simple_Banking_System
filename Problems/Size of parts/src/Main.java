import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tab = new int[n];
        int l =0;
        int s= 0;
        int p=0;
        for(int i=0;i<n ;i++){
            tab[i]=scanner.nextInt();
            switch (tab[i]){
                case -1 : s++;
                break;
                case 0 : p++;
                break;
                case 1 : l++;
            }
        }
        System.out.println(p+" "+l+" "+s);
        // put your code here
    }
}