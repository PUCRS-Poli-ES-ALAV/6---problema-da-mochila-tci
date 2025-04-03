import java.util.Random;

public class Main {
    static int iterations;

    public static int FibonacciRec(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        iterations++;
        return FibonacciRec(n-1) + FibonacciRec(n-2);
    }
    public static int Fibonacci(int n) {
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
            iterations++;
        }
        return fib[n];
    }

    public static int memorized_fibonacci(int[] f, int n) {
        for(int i = 0; i < n; i++) {
            f[i] = -1;
        }
        return lookup_fibonacci(f,n);
    }
    public static int lookup_fibonacci(int[] f, int n) {
        if (f[n] >= 0) return f[n];
        if (f[n] <= 1) f[n] = n;
        else {
            f[n] = lookup_fibonacci(f,n-1)+lookup_fibonacci(f,n-2);
        }
        return f[n];
    }

    public static void main(String[] args) {
        int[] sizes = {4,8,16,32};
        Random random = new Random();

        for (int size : sizes) {

            long startTimeFiboR = System.nanoTime();
            FibonacciRec(size);
            long endTimeFiboR = System.nanoTime();
            System.out.println("Fibonacci Recursivo");
            System.out.println("Tamanho: " + size);
            System.out.println("Iterações: " + iterations);
            System.out.println("Tempo (ms): " + (startTimeFiboR - endTimeFiboR) / 1_000_000.0);

            iterations = 0;

            long startTimeFib = System.nanoTime();
            Fibonacci(size);
            long endTimeFib = System.nanoTime();
            System.out.println("Fibonacci");
            System.out.println("Tamanho: " + size);
            System.out.println("Iterações: " + iterations);
            System.out.println("Tempo (ms): " + (startTimeFib - endTimeFib) / 1_000_000.0);

            iterations = 0;

            long startTimeFibMEMO = System.nanoTime();
            int[]f = new int[size+1];
            memorized_fibonacci(f,size);
            long endTimeFibMEMO = System.nanoTime();
            System.out.println("Memorized Fibonacci");
            System.out.println("Tamanho: " + size);
            System.out.println("Iterações: " + iterations);
            System.out.println("Tempo (ms): " + (startTimeFibMEMO - endTimeFibMEMO) / 1_000_000.0);



        }
        int[] sizeskaratsuba = {128, 1000, 10000};
        for (int size : sizeskaratsuba) {
            iterations = 0;

            long startTimeFib = System.nanoTime();
            Fibonacci(size);
            long endTimeFib = System.nanoTime();
            System.out.println("Fibonacci");
            System.out.println("Tamanho: " + size);
            System.out.println("Iterações: " + iterations);
            System.out.println("Tempo (ms): " + (startTimeFib - endTimeFib) / 1_000_000.0);

            iterations = 0;

            long startTimeFibMEMO = System.nanoTime();
            int[]f = new int[size+1];
            memorized_fibonacci(f,size);
            long endTimeFibMEMO = System.nanoTime();
            System.out.println("Memorized Fibonacci");
            System.out.println("Tamanho: " + size);
            System.out.println("Iterações: " + iterations);
            System.out.println("Tempo (ms): " + (startTimeFibMEMO - endTimeFibMEMO) / 1_000_000.0);

        }
    }
}
