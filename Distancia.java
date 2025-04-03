public class Distancia {
    static int iteracoes = 0;
    public static int distEdProgDina(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] matriz = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            matriz[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            matriz[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                iteracoes++;
                int custoExtra = (A.charAt(i - 1) == B.charAt(j - 1)) ? 0 : 1;

                matriz[i][j] = Math.min(
                        Math.min(matriz[i - 1][j] + 1, matriz[i][j - 1] + 1),
                        matriz[i - 1][j - 1] + custoExtra
                );
            }
        }

        return matriz[m][n];
    }
    public static int distanciaEdicao(String s1, String s2) {
        iteracoes = 0;
        int resultado = distanciaEdicaoRec(s1, s2, s1.length(), s2.length());
        System.out.println("Número de iterações: " + iteracoes);
        return resultado;
    }

    private static int distanciaEdicaoRec(String s1, String s2, int m, int n) {
        iteracoes++;
        if (m == 0) return n;
        if (n == 0) return m;

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return distanciaEdicaoRec(s1, s2, m - 1, n - 1);
        }

        int inserir = distanciaEdicaoRec(s1, s2, m, n - 1);
        int remover = distanciaEdicaoRec(s1, s2, m - 1, n);
        int substituir = distanciaEdicaoRec(s1, s2, m - 1, n - 1);

        return 1 + Math.min(inserir, Math.min(remover, substituir));
    }

    public static void main(String[] args) {
        String palavra1 = "Casablanca";
        String palavra2 = "Portentoso";
        System.out.println("Distância de edição entre '" + palavra1 + "' e '" + palavra2 + "': " + distanciaEdicao(palavra1, palavra2));

        palavra1 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several" +
                " projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear "+
                "definition of what the project consisted of, an easy way to publish project information" +
                "and a way to share JARs across several projects. The result is a tool that can now be" +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";

        palavra2 = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
                "ask? I am going to try to answer this question in this article." +
                "Go to the profile of Marin Vlastelica Pogančić" +
                "Marin Vlastelica Pogančić Jun";

        iteracoes = 0;
        System.out.println("Distância de edição entre '" + palavra1 + "' e '" + palavra2 + "': " + distanciaEdicao(palavra1, palavra2));
    }
}
