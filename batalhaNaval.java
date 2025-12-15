
import java.util.Random;
import java.util.Scanner;

public class batalhaNaval {

    ///////////////////criando variáveis estáticas, de acesso global da classe

    static final int tamanhoTabuleiro = 10;
    static final String vazio = " .";

    //Arranjos dos navios
    static final int[] tamanhoBarco = {5, 4, 3, 3, 2};
    // System.out.println(Arrays.toString(tamanhos));

    static final String[] simbolos = {" P", " E", " C", " S", " N"};
    // System.out.println(Arrays.toString(simbolos));

    // //Posições aleatórias
    static Random random = new Random();
    // // static int randomNum = random.nextInt(10);          //número aleatório entre 0 e 9
    // static int numL = random.nextInt(10);                  //numero aleatório entre 0 e 9 para linha
    // static int numC = random.nextInt(10);                  //numero aleatório entre 0 e 9 para coluna
    // static boolean Vertical = random.nextBoolean();        //booleano aleatório para orientação do barco
    // System.out.println(posiçãoL); 
    // System.out.println(posiçãoC);
    // System.out.println(Vertical);

    //Arranjo do tabuleiro como varável estática, para ser atualizado por todos os métodos
    static String[][] tabuleiro = new String[tamanhoTabuleiro][tamanhoTabuleiro];

    ////////////////////////////////////////////////MÉTODOS ESTÁTICOS COMUNS////////////////////////////////////////////////
        
    //////////////////////////////////////para inicializar o tabuleiro vazio//////////////////////////////////////
    
    static void inicializarTabuleiroVazio() {
        for (int l = 0; l < tamanhoTabuleiro; l++) {                    //para cada linha = 0 e menor que 10, l++
            for (int c = 0; c < tamanhoTabuleiro; c++) {                //para cada coluna = 0 e menor que 10, c++
                tabuleiro[l][c] = vazio;                                //atualize a variável glocal tabuleiro e preencha " ."
            }
            // System.out.println(Arrays.deepToString(tabuleiro));  
        }
    }

    //////////////////////////////////////MÉTODOS ESTÁTICOS PARA GERAÇÃO DE TABULEIRO//////////////////////////////////////
    
    //////////////////////////////////////para verificar se a peça cabe no tabuleiro//////////////////////////////////////

    static boolean barcoCabe(boolean Vertical, int numL, int numC, int tamanhoBarco) {

        if (Vertical) {
            //para linha aleatória, a altura da linha tem espaço necessario pro barco no tabuleiro? true or false 
            boolean barcoCabe = ((numL + tamanhoBarco) <= tamanhoTabuleiro) ? true : false;
            return barcoCabe;
        } else {
            //para coluna aleatória, a posição da coluna tem espaço necessario pro barco no tabuleiro? true or false 
            boolean barcoCabe = ((numC + tamanhoBarco) <= tamanhoTabuleiro) ? true : false;
            return barcoCabe;
        }
    }

    //////////////////////////////////////para verificar se o tabuleiro está vago//////////////////////////////////////
    
    static boolean tabuleiroVago(boolean Vertical, int numL, int numC, int tamanhoBarco) {

        if (Vertical) {                                                                       //se vertical verdadeiro,                                  
            for (int i = 0; i < tamanhoBarco; i++) {                                          //enquanto i < tamanho do barco,                   
                if (!tabuleiro[numL + i][numC].equals(vazio)) {                               //a posição do tabuleiro [random linha + i][coluna fixa] é diferente do conteudo de vazio? 
                    return false;                                                             //retorne tabuleiroVago
                }
            }                                                                                 //equals para comparar arranjo com conteudo de string
        } else {                                                                                //senão    
            for (int i = 0; i < tamanhoBarco; i++) {                                          //enquanto i < tamanho do barco,                   
                if (!tabuleiro[numL][numC + i].equals(vazio)) {                               //a posição do tabuleiro [random linha + i][coluna fixa] é diferente do conteudo de vazio? 
                    return false;                                                             //retorne tabuleiroVago          
                }
            }
        }
        return true;                                                                         //se todas as posições == vazio, retorne true
    }

    //////////////////////////////////////para plotar e atualizar o tabuleiro//////////////////////////////////////
    
    static void colocarBarco(int tamanhoBarco, String simbolo) {

        boolean barcoColocado = false;                           //declara o barco como não colocado, por padrão

        while (!barcoColocado) {                                //enquanto o barco não estiver colocado, continue tentando

            int numL = random.nextInt(tamanhoTabuleiro);        //gera nova linha aleatória, entre 0 e 9
            int numC = random.nextInt(tamanhoTabuleiro);        //gera nova coluna aleatória, entre 0 e 9
            boolean vertical = random.nextBoolean();            //gera nova orientação aleatória, vertical ou horizontal

            if (barcoCabe(vertical, numL, numC, tamanhoBarco)
                    && //barcoCabe E tabuleiroVago recebem os mesmos argumentos
                    tabuleiroVago(vertical, numL, numC, tamanhoBarco)) {    //de orientação, linha, coluna e tamanho do barco

                for (int i = 0; i < tamanhoBarco; i++) {             //para i = posição, enquanto i < tamanho do barco, i++
                    if (vertical) {                                  //se vertical for verdadeiro
                        tabuleiro[numL + i][numC] = simbolo;        //atualize a posição do tabuleiro [linha + i][coluna fixa] com o símbolo do barco
                    } else {                                        //senão (horizontal)
                        tabuleiro[numL][numC + i] = simbolo;        //atualize a posição do tabuleiro [linha fixa][coluna + i] com o símbolo do barco
                    }
                }
                barcoColocado = true;                               //barco colocado, fim do while
            }
        }
    }

    //////////////////////////////////////para printar o tabuleiro//////////////////////////////////////

    /*
     * Imprime o tabuleiro no formato exigido:
     * 10 linhas, com 10 elementos por linha separados por espaço.
     * (Se seu gerador atualmente não imprime com espaço, ajuste aqui.)
     */

    static void imprimirTabuleiro() {
        for (int l = 0; l < tamanhoTabuleiro; l++) {        //para cada linha = 0 e menor que 10, l++
            for (int c = 0; c < tamanhoTabuleiro; c++) {    //para cada coluna = 0 e menor que 10, c++
                System.out.print(tabuleiro[l][c]);              //imprima a posição do tabuleiro [linha][coluna]
            }
            System.out.println();                               //pule uma linha após cada linha do tabuleiro
        }
    }

    //////////////////////////////////////MÉTODOS ESTÁTICOS PARA VALIDAÇÃO DE TABULEIRO//////////////////////////////////////
    
    // 
    //                                    MODO V - LEITURA E VALIDAÇÃO
    // 

    /**
     * Lê o tabuleiro via entrada padrão (stdin), permitindo redirecionamento:
     * java batalhaNaval V < tabuleiro.txt
     *
     * Regras validadas aqui:
     * - Deve haver exatamente 10 linhas
     * - Cada linha deve ter exatamente 10 elementos separados por espaço*/

    public static boolean lerTabuleiro() {
        Scanner sc = new Scanner(System.in);

        for (int l = 0; l < tamanhoTabuleiro; l++) {
            if (!sc.hasNextLine()) {
                System.out.println("Tabuleiro inválido: dimensões incorretas");
                return false;
            }

            String linha = sc.nextLine();
            String[] partes = linha.split(" ");

            if (partes.length != tamanhoTabuleiro) {
                System.out.println("Tabuleiro inválido: dimensões incorretas");
                return false;
            }

            for (int c = 0; c < tamanhoTabuleiro; c++) {
                tabuleiro[l][c] = partes[c];
            }

            sc.close();
        }

        return true;
    }

    //////////////////////////////////////MÉTODO MAIN//////////////////////////////////////

 
//     public static void main(String[] args) {

//         if (args.length == 0 || !args[0].equals("G")) {     //equals para comparar arranjo com conteudo de string
//             System.out.println("Uso: java batalhaNaval G");
//             return;
//         }

//     inicializarTabuleiroVazio();                        //inicializa o tabuleiro vazio

//     for (int i = 0; i < tamanhoBarco.length; i++) {     //para i = 0; enquanto i < o numero de barcos, i++
//         colocarBarco(tamanhoBarco[i], simbolos[i]);     //coloca o barco no tabuleiro, tamanho e símbolo do barco correspondente
//     }
//     imprimirTabuleiro();                                //imprime o tabuleiro atualizado com os barcos
//     }
// }






    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java BatalhaNaval G | V");
            return;
        }

        if (args[0].equals("G")) {
            inicializarTabuleiroVazio();
            for (int i = 0; i < tamanhoBarco.length; i++) {
                colocarBarco(tamanhoBarco[i], simbolos[i]);
            }
            imprimirTabuleiro();

        } else if (args[0].equals("V")) {
            inicializarTabuleiroVazio();
            // lerTabuleiro();
            // validarTabuleiro();

        } else {
            System.out.println("Modo inválido. Use G ou V.");
        }
    }

}
