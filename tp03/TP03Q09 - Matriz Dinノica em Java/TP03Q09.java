import java.util.Scanner;

class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this(elemento, null, null, null, null);
    }

    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    
        inicio = new Celula();
        Celula atual = inicio;
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                atual.dir = new Celula();
                atual.dir.esq = atual;
                atual = atual.dir;
            }
            
            if (i < linha - 1) {
                atual.inf = new Celula();
                atual.inf.sup = atual;
                atual = atual.inf;
            }
        }

        System.out.println("Matriz criada com " + linha + " linhas e " + coluna + " colunas");
    }    

    public void lerMatriz(Scanner sc, int m, int n) {
        Celula current = this.inicio;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int valor = sc.nextInt();
                System.out.println(valor);
                current.elemento = valor;
                current = current.dir;
            }
            if (i < this.linha - 1) {
                current = current.inf;
            }
        }
    }

    public boolean isQuadrada() {
        return this.linha == this.coluna;
    }

    public void mostrarDiagonalPrincipal() {
        for (Celula current = this.inicio; current != null; current = current.dir.inf) {
            if (current != null) {
                System.out.print(current.elemento + " ");
            }
        }
        System.out.println();
    }

    public Matriz somarMatrizes(Matriz outraMatriz) {
        Matriz resultado = new Matriz(this.linha, this.coluna);
        Celula atualA = this.inicio;
        Celula atualB = outraMatriz.inicio;
        Celula atualResult = resultado.inicio;

        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < this.coluna; j++) {
                atualResult.elemento = atualA.elemento + atualB.elemento;
                atualA = atualA.dir;
                atualB = atualB.dir;
                atualResult = atualResult.dir;
            }

            atualA = atualA.inf;
            atualB = atualB.inf;
            atualResult = atualResult.inf;
        }

        return resultado;
    }

    public Matriz multiplicarMatrizes(Matriz outraMatriz) {
        Matriz resultado = new Matriz(this.linha, outraMatriz.coluna);
        Celula atualA = this.inicio;
        Celula atualB;
        Celula atualResult = resultado.inicio;

        for (int i = 0; i < this.linha; i++) {
            atualB = outraMatriz.inicio;

            for (int j = 0; j < outraMatriz.coluna; j++) {
                int soma = 0;
                Celula atualAOriginal = atualA;
                Celula atualBOriginal = atualB;

                for (int k = 0; k < this.coluna; k++) {
                    soma += atualA.elemento * atualB.elemento;
                    atualA = atualA.dir;
                    atualB = atualB.inf;
                }

                atualResult.elemento = soma;
                atualA = atualAOriginal;
                atualB = atualBOriginal;

                atualB = atualB.dir;
                atualResult = atualResult.dir;
            }

            atualA = atualA.inf;
        }

        return resultado;
    }

    public void mostrarMatriz(int m, int n) {
        Celula atual = this.inicio;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atual != null) {
                    System.out.print(atual.elemento + " ");
                    atual = atual.dir;
                } else {
                    System.out.print("Elemento nulo ");
                }
            }

            System.out.println();

            if (atual != null) atual = atual.inf;
        }
    }


}

public class TP03Q09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aux = sc.nextInt();

        for(int i = 0; i < aux; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            Matriz matriz1 = new Matriz(m, n);
            matriz1.lerMatriz(sc, m, n);

            int m2 = sc.nextInt();
            int n2 = sc.nextInt();

            Matriz matriz2 = new Matriz(m2, n2);
            matriz2.lerMatriz(sc, m2, n2);

            matriz1.mostrarMatriz(m2, n2);

            matriz1.mostrarDiagonalPrincipal();
        }
        
        sc.close();
    }
}
