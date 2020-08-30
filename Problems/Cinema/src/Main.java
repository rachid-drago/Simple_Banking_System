import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        boolean found = false;
        int count = 0;
        int row = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!found) {
                    if (mat[i][j] == 0) { 
                        count++; 
                    } else {
                        count = 0;
                        }
                    if (k == count) {
                        found = true;
                        row = i + 1;
                    }
                }
            }
            count = 0;
        }
        System.out.println(row);
    }
}
