import java.util.Arrays;

/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        // write your code here
        int[] tab = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            tab[i - 1] = Integer.parseInt(args[i]);
        }
        //System.out.println(Arrays.toString(tab));
        if ("MAX".equals(operator)) {
            int max = Arrays.stream(tab).max().getAsInt();
            System.out.println(max);
        }
        if ("MIN".equals(operator)) {
            int min = Arrays.stream(tab).min().getAsInt();
            System.out.println(min);
        }
        if ("SUM".equals(operator)) {
            int sum = Arrays.stream(tab).sum();
            System.out.println(sum);
        }
    }
}
