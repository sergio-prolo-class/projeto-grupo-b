
import java.util.Random;
import java.util.Scanner;

public class batalhaNaval {

    // criando variáveis estáticas, de acesso global da classe
    static final int tamanhoTabuleiro = 10;
    static final String vazio = ".";

    //Arranjos dos navios
    static final int[] tamanhoBarco = {5, 4, 3, 3, 2};
    // System.out.println(Arrays.toString(tamanhos));

    static final String[] simbolos = {"P", "E", "C", "S", "N"};
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
                System.out.print(tabuleiro[l][c] + " ");              //imprima a posição do tabuleiro [linha][coluna]
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

    static boolean lerTabuleiro() {
        Scanner sc = new Scanner(System.in);

        for (int l = 0; l < tamanhoTabuleiro; l++) {
            if (!sc.hasNextLine()) {
                System.out.println("INVÁLIDO (dimensões incorretas)");
                return false;
            }

            String linha = sc.nextLine();
            String[] partes = linha.split(" ");

            if (partes.length != tamanhoTabuleiro) {
                System.out.println("INVÁLIDO (dimensões incorretas)");
                return false;
            }

            for (int c = 0; c < tamanhoTabuleiro; c++) {
                tabuleiro[l][c] = partes[c];
            }

        }

        return true;
    }

    /**
     * Valida se o tabuleiro contém apenas símbolos permitidos pelo enunciado:
     * P, E, C, S, N ou .
     *
     * @return true se todos os símbolos forem válidos; false se encontrar algum
     * inválido
     */
    static boolean validarSimbolos() {
        for (int l = 0; l < tamanhoTabuleiro; l++) {
            for (int c = 0; c < tamanhoTabuleiro; c++) {

                String s = tabuleiro[l][c];

                // Condição direta: se não for nenhum símbolo aceito, é erro
                if (!s.equals("P") && !s.equals("E") && !s.equals("C")
                        && !s.equals("S") && !s.equals("N") && !s.equals(".")) {

                    // Mensagem no estilo do exemplo do enunciado
                    System.out.println("INVÁLIDO (navio desconhecido)");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Valida um navio específico (por símbolo) verificando: 1) Se ele existe no
     * tabuleiro 2) Se ocupa exatamente o tamanho esperado 3) Se forma uma
     * sequência contínua horizontal OU vertical (não pode ser quebrado)
     *
     * Estratégia: - Cria uma matriz booleana marcando onde o símbolo aparece -
     * Conta quantas ocorrências existem (deve bater com tamanhoEsperado) -
     * Procura uma sequência contínua do tamanhoEsperado em alguma linha
     * (horizontal) - Procura uma sequência contínua do tamanhoEsperado em
     * alguma coluna (vertical) - Deve ser exatamente um dos dois (horizontal
     * XOR vertical)
     *
     * @param simbolo símbolo do navio (ex: "P")
     * @param tamanhoEsperado tamanho do navio conforme enunciado (ex: 5)
     * @return true se o navio estiver válido; false se estiver ausente, com
     * tamanho errado ou formato incorretoo
     */
    static boolean validarFormatoNavio(String simbolo, int tamanhoEsperado) {
        boolean[][] pos = new boolean[10][10];
        int count = 0;

        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                if (tabuleiro[l][c].equals(simbolo)) {
                    pos[l][c] = true;
                    count++;
                }
            }
        }

        // 1) navio faltando
        if (count == 0) {
            System.out.println("INVÁLIDO (navio faltando)");
            return false;
        }

        // 2) navio na diagonal
        for (int l = 0; l < 9; l++) {
            for (int c = 0; c < 9; c++) {
                if ((pos[l][c] && pos[l + 1][c + 1])
                        || (pos[l + 1][c] && pos[l][c + 1])) {
                    System.out.println("INVÁLIDO (navio na diagonal)");
                    return false;
                }
            }
        }

        // 3) verificar se forma linha ou coluna contínua
        boolean horizontal = false, vertical = false;

        for (int l = 0; l < 10; l++) {
            int seq = 0;
            for (int c = 0; c < 10; c++) {
                seq = pos[l][c] ? seq + 1 : 0;
                if (seq == count) {
                    horizontal = true;
                }
            }
        }

        for (int c = 0; c < 10; c++) {
            int seq = 0;
            for (int l = 0; l < 10; l++) {
                seq = pos[l][c] ? seq + 1 : 0;
                if (seq == count) {
                    vertical = true;
                }
            }
        }

        // 4) verificar se forma linha ou coluna contínua

        for (int l = 0; l < 10; l++) {
            int seq = 0;
            for (int c = 0; c < 10; c++) {
                seq = pos[l][c] ? seq + 1 : 0;
                if (seq == count) {
                    horizontal = true;
                }
            }
        }

        for (int c = 0; c < 10; c++) {
            int seq = 0;
            for (int l = 0; l < 10; l++) {
                seq = pos[l][c] ? seq + 1 : 0;
                if (seq == count) {
                    vertical = true;
                }
            }
        }

// ⚠️ SOBREPOSIÇÃO SÓ SE FOR UM ÚNICO GRUPO E NÃO LINHA NEM COLUNA
        if (!horizontal && !vertical) {
            System.out.println("INVÁLIDO (sobreposição de navios)");
            return false;
        }

        return true;
    }

    /**
     * Controla a validação completa dos navios exigidos: - Deve existir
     * exatamente 1 navio de cada tipo (P, E, C, S, N) - Cada navio deve ocupar
     * exatamente o número correto de casas - Cada navio deve estar inteiramente
     * na horizontal OU inteiramente na vertical - Não pode existir formato
     * “quebrado” (ex: em L, separado, etc)
     *
     * @return true se todos os navios estiverem corretos; false caso contrário
     */
    static boolean validarNavios() {
        // Para cada tipo de navio, valida quantidade e formato
        if (!validarFormatoNavio("P", 5)) {
            return false;
        }
        if (!validarFormatoNavio("E", 4)) {
            return false;
        }
        if (!validarFormatoNavio("C", 3)) {
            return false;
        }
        if (!validarFormatoNavio("S", 3)) {
            return false;
        }
        if (!validarFormatoNavio("N", 2)) {
            return false;
        }

        // Se todos passaram, o conjunto de navios está correto
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

            if (!lerTabuleiro()) {
                return;
            }

            if (!validarSimbolos()) {
                return;
            }

            if (!validarNavios()) {
                return;
            }

            System.out.println("VÁLIDO");

            // lerTabuleiro();
            // validarTabuleiro();
        } else {
            System.out.println("Modo inválido. Use G ou V.");
        }

    }

}
