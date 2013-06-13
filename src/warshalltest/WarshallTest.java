/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warshalltest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author AgtLucas
 */
public class WarshallTest {
    
    static void fechamento(boolean ma[][], boolean mf[][]) {
        int i, j, k;
        
        // Inicializa matriz
        for (i = 0; i < ma.length; i++) {
            for (j = 0; j < ma.length; j++) {
                mf[i][j] = ma[i][j];
            }
        }
        
        // algoritmo de Warshall
        for (k = 0; k < ma.length; i++) {
            for (i = 0; i < ma.length; i++) {
                if (mf[i][k]) {
                    for (j = 0; j < ma.length; j++) {
                        mf[i][j] = mf[i][j] || mf[k][j];
                    }
                }
            }
        }
    }
    
    static void imprime(boolean m[][]) {
        int i, j;
        
        for (i = 0; i < m.length; i++) {
            for (j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println();
    }
    
    static void readFile(String pathFile) throws IOException {
        try {
            InputStream in = new FileInputStream(pathFile);
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader buffer = new BufferedReader(reader);
            String text;
            while ((text = buffer.readLine()) != null) {
                System.out.print(text);
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        boolean ma[][] = new boolean[3][3];
        boolean mf[][] = new boolean[3][3];
        
        ma[0][0] = false; ma[1][0] = true; ma[2][0] = true;
        ma[0][1] = true; ma[1][1] = false; ma[2][1] = true;
        ma[0][2] = true; ma[1][2] = true; ma[2][2] = false;
        
        imprime(ma);
        fechamento(ma, mf);
        imprime(mf);
        
        readFile("/Users/AgtLucas/NetBeansProjects/WarshallTest/src/warshalltest/matriz.txt");
                    
//        try {
//            InputStream entrada = new FileInputStream("/Users/AgtLucas/NetBeansProjects/WarshallTest/src/warshalltest/matriz.txt");
//            InputStreamReader reader = new InputStreamReader(entrada);
//            BufferedReader buffer = new BufferedReader(reader);
//            
//            while ((matrizA = buffer.readLine()) != null) {
//                System.out.println(matrizA);
//            }
//        } catch (FileNotFoundException e) {
//            e.getMessage();
//        }
//        
//        System.out.print(matrizA);
    }
}
