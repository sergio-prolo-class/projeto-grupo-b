import java.util.Arrays;
import java.util.Random;

public class batalha_Naval {


    ///////////////////criando variáveis estáticas, de acesso global da classe

    static final int tamanhoTabuleiro = 10;
    static final String vazio = " ." ;

    //Arranjos dos navios
    static final int[] tamanhoBarco = {5, 4, 3, 3, 2}; 
        // System.out.println(Arrays.toString(tamanhos));

    static final String[] simbolos = {"P", "E", "C", "S", "N"};
        // System.out.println(Arrays.toString(simbolos));

    //Posições aleatórias
    static Random random = new Random();
    // static int randomNum = random.nextInt(10);          //número aleatório entre 0 e 9
    static int numL = random.nextInt(10);           //numero aleatório entre 0 e 9 para linha
    static int numC = random.nextInt(10);           //numero aleatório entre 0 e 9 para coluna
    static boolean Vertical = random.nextBoolean();       //booleano aleatório para orientação do barco
        // System.out.println(posiçãoL); 
        // System.out.println(posiçãoC);
        // System.out.println(Vertical);

    //Arranjo do tabuleiro como varável estática, para ser atualizado por todos os métodos
    static String[][] tabuleiro = new String[tamanhoTabuleiro][tamanhoTabuleiro]; 

    
    ////////////////////////////////////////////////métodos estáticos////////////////////////////////////////////////
        
    //////////////////////////////////////para inicializar o tabuleiro vazio//////////////////////////////////////
    
    static void inicializarTabuleiroVazio () {
        for (int l = 0; l < tamanhoTabuleiro; l++) {                    //para cada linha = 0 e menor que 10, l++
            for (int c = 0; c < tamanhoTabuleiro; c++) {                //para cada coluna = 0 e menor que 10, c++
                tabuleiro[l][c] = vazio;                                //atualize a variável glocal tabuleiro e preencha " ."
            }
            // System.out.println(Arrays.deepToString(tabuleiro));  
        }
    }

    //////////////////////////////////////para verificar se a peça cabe no tabuleiro//////////////////////////////////////

    static boolean barcoCabe (boolean Vertical, int numL, int numC, int tamanhoBarco) { 

        if (Vertical) {
            //para linha aleatória, a altura da linha é >= espaço necessario pro barco? true or false 
            boolean barcoCabe = ( (tamanhoTabuleiro - numL) >= (tamanhoTabuleiro - tamanhoBarco)) ? true : false; 
            return barcoCabe;
          } else {
            //para coluna aleatória, a posição da coluna é >= espaço necessario pro barco? true or false 
            boolean barcoCabe = ( ( tamanhoTabuleiro - numC) >= (tamanhoTabuleiro - tamanhoBarco)) ? true : false; 
            return barcoCabe;
        }
    }

    //////////////////////////////////////para verificar se o tabuleiro está vago//////////////////////////////////////
    
    static boolean tabuleiroVago (boolean Vertical, int numL, int numC, int tamanhoBarco, int i) {

        if (Vertical) {                                                                        //se vertical verdadeiro,                                  
            for (i = 0; i < tamanhoBarco; i++) {                                               //enquanto i < tamanho do barco,                   
                if (tabuleiro[numL + i][numC] != vazio) {                                      //a posição do tabuleiro [random linha + i][coluna fixa] é diferente de vazio? 
                    boolean tabuleiroVago = false;                                             //tabuleiroVago é falso            
                    return tabuleiroVago;                                                      //retorne tabuleiroVago
                } 
            }
        }
        else {                                                                                //senão    
            for (i = 0; i < tamanhoBarco; i++) {                                              //enquanto i < tamanho do barco,                   
                if (tabuleiro[numL][numC + i] != vazio) {                                     //a posição do tabuleiro [linha fixa][random coluna + i] é diferente de vazio? 
                    boolean tabuleiroVago = false;                                            //tabuleiroVago é falso            
                    return tabuleiroVago;                                                     //retorne tabuleiroVago          
                }
            }
        }
        return true;                                                                         //se todas as posições == vazio, retorne true
    }

    
    //////////////////////////////////////método main//////////////////////////////////////

 
    public static void main(String[] args) {

        ///bloco de teste////////////////
        System.out.printf("linha %d %n", numL); 
        System.out.printf("coluna %d %n", numC);       
        System.out.printf("vertical %b %n", Vertical);

            inicializarTabuleiroVazio();                                //chama o método inicializarTabuleiroVazio para preencher o tabuleiro com " ."
            barcoCabe(true, numL, numC, 5 );   
            
            System.out.println(Arrays.deepToString(tabuleiro));

            System.out.printf("tabuleirovago %b %n", tabuleiroVago(Vertical, numL, numC, 5, 0) );

        }
}





















        
            


    //     if (Vertical) {                                                                             //se vertical == true, 
    //         while (i  <= (tamanhoBarco)); {                                                          //enquanto i <= tamanho do barco,                                  
    //             do {                                                                                //faça      
    //                 boolean tabuleiroVago = (tabuleiro[numL + i][numC] == vazio) ? true : false;    //a posição do tabuleiro [random linha + 1][coluna] é vazio? tabuleiroVago é true or false
    //                 return tabuleiroVago;
    //             }
    //         }
    //     } else {
    //         while (i  <= (tamanhoBarco)); { 
    //             do {
    //                 boolean tabuleiroVago = (tabuleiro[numL][numC + i] == vazio) ? true : false;
                    
    //             }
    //         i++;                                                                               // desloque para coluna direita, linha fixa
    //         }
    //     }
    // }

    




            
                                                                                  // desloque para linha debaixo, coluna fixa
                                                                                                  // repita até o tamanho do barco
            
            
                                                                                            //senão (horizontal)
                                                                     //enquanto i <= tamanho do barco,                                  
                                                                                               //faça      
                        //a posição do tabuleiro [linha][random coluna +
                                                                                               // desloque para linha debaixo, coluna fixa
                                                                                                   // repita até o tamanho do barco
                                                                               // desloque para coluna direita, linha fixa
        
    


        //     //para coluna aleatória, enquanto linha aleatória for menor que o tamanho do barco, essas linhas = vazio? true or false 
        //     for (int c = numC; ( i < (numL + tamanhoBarco)); i++) {
        //         boolean vertucalLivre = tabuleiro[i][numC] == vazio? true : false;
        //     }
        //     return vertucalLivre;
        //     }
        // else {
        //     //para linha aleatória, o intervalo de colunas de espaço necessario pro barco = vazio? true or false 
        //         for (int numL = randomNum; ( i < (numC + tamanhoBarco)); i++) {
        //         boolean espaçoVazioHorizontal = tabuleiro[numL][i] == vazio? true : false;
        //         return espaçoVazioHorizontal;
    

        

//          public static boolean TabuleiroVazio (boolean Vertical, int randomNum, int tamanhoBarco, int i) {

//           //////////////////////////////////////verificando se a peça cabe//////////////////////////////////////

//           if (Vertical == true) {
//             //para coluna aleatória, o intervalo de linhas de espaço necessario pro barco = vazio? true or false 
//             for (int numC = randomNum; ( i < (numL + tamanhoBarco)); i++) {
//                 boolean espaçoVazioVertical = tabuleiro[i][numC] == vazio? true : false;
//                 return espaçoVazioVertical;
//             }
//         else {
//             //para linha aleatória, o intervalo de colunas de espaço necessario pro barco = vazio? true or false 
//                 for (int numL = randomNum; ( i < (numC + tamanhoBarco)); i++) {
//                 boolean espaçoVazioHorizontal = tabuleiro[numL][i] == vazio? true : false;
//                 return espaçoVazioHorizontal;
//             }
            
            








//             boolean verticalLivre = (randomNum >= (10 - tamanhoBarco)) ? true : false;


//             return verticalLivre;
//           } else {
//             //para coluna aleatória, a posição da coluna é >= espaço necessario pro barco? true or false 
//             boolean cabeHorizontal = (randomNum >= (10 - tamanhoBarco)) ? true : false; 
//             return cabeHorizontal;
//           }
    
//           //para barco, se barco <= quantidade de barcos, barco++
//             for (int barco = 0; barco < tamanhos.length; barco ++) {

//             //para linha aleatória, a altura da linha é >= espaço necessario pro barco? true or false 
//             boolean cabeVertical = (numL >= (10 - tamanhos[barco])) ? true : false; 

//             //para coluna aleatória, a posição da coluna é >= espaço necessario pro barco? true or false 
//             boolean cabeHorizontal = (numC >= (10 - tamanhos[barco])) ? true : false; 


        


//         // //Posição
//         // Random random = new Random();
//         // int numL = random.nextInt(10);
//         // int numC = random.nextInt(10);
//         // // System.out.println(posiçãoL);
//         // // System.out.println(posiçãoC);


//         //verificando se cabe//////////////////////////////////////

//         //para barco, se barco <= quantidade de barcos, barco++
//         for (int barco = 0; barco < tamanhos.length; barco ++) {

//             //para linha aleatória, a altura da linha é >= espaço necessario pro barco? true or false 
//             boolean cabeVertical = (numL >= (10 - tamanhos[barco])) ? true : false; 

//             //para coluna aleatória, a posição da coluna é >= espaço necessario pro barco? true or false 
//             boolean cabeHorizontal = (numC >= (10 - tamanhos[barco])) ? true : false; 


//         //verificando se está vazio/////////////////////////////

//         //para simbolo, se simbolos <= tamanho do barco, simbolo++
//         for (int simbolo = 0; simbolo < tamanhos.length; simbolo ++) {
//             //vertical 

//             for ( int i = 0; i < tamanhos[i]; i++)



//             boolean livre = ((tabuleiro[numL + i][numC] == vazio) ? true : false) ;




//             while (simbolo <= tamanhos[simbolo]) {
//                 do {
//                     //verifica se a posição do tabuleiro está vazia
//                     boolean espaçoVazioVertical = (tabuleiro[numL][numC] == vazio) ? true : false;
//                 if (tabuleiro[numL][numC] != vazio) {  

            
        




//             //enquanto simbolo <= tamanho do barco correspondente, faça
//             while (simbolo <= tamanhos[simbolo]) {
//                 do {
//                     //verifica se a posição do tabuleiro está vazia
//                     boolean espaçoVazioVertical = (tabuleiro[numL][numC] == vazio) ? true : false;

//                 }             
//             }

//             boolean espaçoVazio = (tabuleiro[numL][numC] == vazio) ? true : false;




//             //para linha aleatória, a altura da linha é >= espaço necessario pro barco? true or false 
//             boolean cabeVertical = (numL >= (10 - tamanhos[barco])) ? true : false; 

//             //para coluna aleatória, a posição da coluna é >= espaço necessario pro barco? true or false 
//             boolean cabeHorizontal = (numC >= (10 - tamanhos[barco])) ? true : false; 
            

//         //colocando peças

//         //para barco, se barco <= quantidade de barcos, barco++
//         for ( int barco = 0; barco <= tamanhos.length; barco ++) {





//             //para linha aleatória, se numero da linha >= (tamanho tabuleiro - tamanho do barco), linha++
//             for (int l = numL; cabeVertical == true ; l++) {

//                 // para cada coluna aleatória, se a linha e coluna forem vazias, print simbolo do barco, c++
//                 for (int c = numC; (tabuleiro[l][c] == vazio) ; c = numC) {
//                     System.out.printf("simbolos[barco]");            
//                 }
//             }

            
//             (( l = numL) >= (10 - tamanhos[barco])) ?

        



//             //     // para cada coluna aleatória, enquanto linha <= ao tamanho do barco, print simbolo do barco, l++
//             //    for (int c = numC; (l >= numL + tamanhos[0]); l++); {

//             // System.out.printf("simbolos[0]");
//             // }

//         }
//         } 
//     }


//         //      {
//         //         l = l
//         //     } ; l++) {
//         //         System.out.printf("simbolos[0]");
//         //     }
//         // }

//         //         for (int l = posiçãoC; (posiçãoC < tamanhos[0]); c++) {

//         //             for (int l = 0; l < P2.length; l++) {
//         //     for (int c = 0; c < P2.length; c++) {
//         //         System.out.printf("P");



//         //         for (int C = posiçãoC; (posiçãoL < tamanhos[0]); l++) {





//         //     System.out.printf("simbolos[0]");
//         //      }
//         //     }

        
//     // static void gerarTabuleiro() {
//     //     for (int i = 0; i < tamanhos.length; i++) {
//     //         int tamanho = tamanhos[i];
//     //         char simbolo = simbolos[i];



        
        
//     //    System.out.println(Arrays.toString(tamanhos));

//     //    System.out.println(Arrays.toString(simbolos));

 









    
        
            
// //  int[] P1 = new int [5];
// //          for (int l = 0; l  < P1.length; l++) {
// //                 System.out.printf(" P");
// //             System.out.println(P1);
// //         }

// //          int[] P2 = new int [5];
// //          for (int c = 0; c  < P2.length; c++) {
// //                 System.out.printf(" A");
// //             System.out.print(P2);
// //         }



//         //  int[][] P2 = new int [1][5];
//         //  for (int l = 0; l < P2.length; l++) {
//         //     for (int c = 0; c < P2.length; c++) {
//         //         System.out.printf("P");
//         //     }
//         // }
        
//         // int[][] E1 = new int [4][1];
//         // int[][] E2 = new int [1][4];

//         // int[][] C1 = new int [3][1];
//         // int[][] C2 = new int [1][3];

//         // int[][] S1 = new int [3][1];
//         // int[][] S2 = new int [1][3];

//         // int[][] N1 = new int [2][1];
//         // int[][] N2 = new int [1][2];


//         // while (linhas < 10) {
//         //     while (colunas < 10) {
//         //         System.out.printf(" .");
//         //         colunas++;
//         //     }
//         //     linhas ++ ;
//         //     colunas = 0 ;
//         //     System.out.println();

//         // }
    







