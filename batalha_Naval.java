import java.util.Scanner;
import java.util.Random;

public class batalha_Naval {
    public static void main(String[] args) {

        int linhas  = 0 ;
        int colunas = 1 ;
        

        while (linhas < 10) {
            while (colunas <= 10) {
                System.out.printf(" . ");
                colunas++;
            }
            linhas ++ ;
            colunas = 1 ;
            System.out.println();

        }
    }
}