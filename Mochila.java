import java.util.ArrayList;
import java.util.List;

public class Mochila {
    static int iteracoes = 0;

    static class Tuple {
        int peso;
        int valor;

        public Tuple(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    public static int mochilaPD(int N, int C, List<Tuple> items) {
        // N = número de produtos
        // C = capacidade da mochila
        int[][] maxtab = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                iteracoes++;
                if (items.get(i - 1).peso <= j) {
                    maxtab[i][j] = Math.max(maxtab[i - 1][j], items.get(i - 1).valor + maxtab[i - 1][j - items.get(i - 1).peso]);
                } else {
                    maxtab[i][j] = maxtab[i - 1][j];
                }
            }
        }
        return maxtab[N][C];
    }

    public static void main(String[] args) {
        // Primeiro conjunto de dados
        List<Tuple> knapsack1 = new ArrayList<>();
        knapsack1.add(new Tuple(23, 92));
        knapsack1.add(new Tuple(31, 57));
        knapsack1.add(new Tuple(29, 49));
        knapsack1.add(new Tuple(44, 68));
        knapsack1.add(new Tuple(53, 60));
        knapsack1.add(new Tuple(38, 43));
        knapsack1.add(new Tuple(63, 67));
        knapsack1.add(new Tuple(85, 84));
        knapsack1.add(new Tuple(89, 87));
        knapsack1.add(new Tuple(82, 72));

        int capacidade1 = 165;
        System.out.println("Valor máximo da mochila 1: " + mochilaPD(knapsack1.size(), capacidade1, knapsack1));
        System.out.println("iteraçoes da mochila 1: " + iteracoes);

        iteracoes = 0;
        // Segundo conjunto de dados
        List<Tuple> knapsack2 = new ArrayList<>();
        knapsack2.add(new Tuple(56, 50));
        knapsack2.add(new Tuple(59, 50));
        knapsack2.add(new Tuple(80, 64));
        knapsack2.add(new Tuple(64, 46));
        knapsack2.add(new Tuple(75, 50));
        knapsack2.add(new Tuple(17, 5));

        int capacidade2 = 190;
        System.out.println("Valor máximo da mochila 2: " + mochilaPD(knapsack2.size(), capacidade2, knapsack2));
        System.out.println("iteraçoes da mochila 2: " + iteracoes);

    }
}
