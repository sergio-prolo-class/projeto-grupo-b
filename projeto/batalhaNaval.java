public class batalhaNaval {


    public static void main(String[] args) {
        // uso dos métodos
        char[][] tabuleiro = criarTabuleiro(); 

        imprimirTabuleiro(tabuleiro); 
    }

    public static char[][] criarTabuleiro(){
        char[][] tabuleiro = new char[TAM][TAM];

        for (int linha = 0; linha < tabuleiro.length ; linha++) { 
            for (int coluna = 0; coluna < tabuleiro[0].length; coluna++) {
                tabuleiro[linha][coluna] = '.';  //neste for o código seta o valor "." para cada posição no array, 
            }                                    //quando a coluna chega a 10 ele passa pra linha de baixo, setando o valor das mesmas 
        }

        return tabuleiro;
    }

    public static void imprimirTabuleiro(char tabuleiro[][]){        
        for (int linha = 0; linha <  tabuleiro.length; linha++) {
            for (int coluna = 0; coluna < tabuleiro[0].length; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " "); 
            }
            System.out.println(); //neste for ele apenas imprime na tela todas as posições do array com o espaçamento
        }
    }

    static final int TAM = 10;
}
