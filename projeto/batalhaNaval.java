public class batalhaNaval {


    public static void main(String[] args) {
        char[][] tabuleiro = new char[10][10];

        for (int linha = 0; linha < 10; linha++) { 
            for (int coluna = 0; coluna < 10; coluna++) {
                tabuleiro[linha][coluna] = '.';  //neste for o código seta o valor "." para cada posição no array, 
                                                 //quando a coluna chega a 10 ele passa pra linha de baixo, setando o valor das mesmas 
            }
        }
        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " "); //neste for ele apenas imprime na tela todas as posições do array com o espaçamento
            }
            System.out.println();
        }
    }
}
