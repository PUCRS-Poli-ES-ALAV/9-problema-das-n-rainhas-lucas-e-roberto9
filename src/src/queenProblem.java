public class queenProblem {

    void escreveSolucao(int tabuleiro[][])
    {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++)
                System.out.print(" " + tabuleiro[i][j]
                        + " ");
            System.out.println();
        }
    }

    boolean podeColocar(int tabuleiro[][], int linha, int coluna)
    {
        int i, j;

        /* Checa essa coluna do lado esquerdo */
        for (i = 0; i < coluna; i++)
            if (tabuleiro[linha][i] == 1)
                return false;

        /* Checa diagonal superior do lado esquerdo */
        for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--)
            if (tabuleiro[i][j] == 1)
                return false;

        /* Checa diagonal inferior do lado esquerdo */
        for (i = linha, j = coluna; j >= 0 && i < tabuleiro.length; i++, j--)
            if (tabuleiro[i][j] == 1)
                return false;

        return true;
    }

    boolean resolveNQueen(int tabuleiro[][], int coluna)
    {

        if (coluna >= tabuleiro.length)
            return true;

        for (int i = 0; i < tabuleiro.length; i++) {
            if (podeColocar(tabuleiro, i, coluna)) {
                tabuleiro[i][coluna] = 1;

                if (resolveNQueen(tabuleiro, coluna + 1) == true)
                    return true;

                tabuleiro[i][coluna] = 0; // esse é o backtracking
            }
        }
        return false;
    }


    boolean resolveNQ(int N)
    {
        int tabuleiro[][] = new int [N][N];

        if (resolveNQueen(tabuleiro, 0) == false) {
            System.out.print("Solução não existe");
            return false;
        }

        escreveSolucao(tabuleiro);
        return true;
    }

    public static void main(String args[])
    {
        queenProblem Queen = new queenProblem();
        Queen.resolveNQ(20);
    }
}

