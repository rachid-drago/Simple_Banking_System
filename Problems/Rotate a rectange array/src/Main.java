import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int[][] tab = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tab[i][j] = arr[j][i];
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int swap = tab[i][j];
                tab[i][j] = tab[i][m - j - 1];
                tab[i][m - j - 1] = swap;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
}