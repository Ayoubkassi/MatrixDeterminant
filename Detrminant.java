/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import static java.lang.Double.parseDouble;
import java.time.LocalDateTime;
/**
 *
 * @author ryota
 */
public class Main {
    
    public static void printArray(int[][] arr){
        int size = arr.length;
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }
    
    public static int determinant(int[][] arr){
        int det = 0;
        int size = arr[0].length;
        if(arr[0].length == 2){
            return (arr[0][0]*arr[1][1])-(arr[1][0]*arr[0][1]);
        }
        else{
            int[][] new_arr = new int[size-1][size-1];
         for (int l = 0; l < size; l++) {
         //optimization
                if(arr[0][l] == 0)
                    continue;
            
            for(int i=0;i<size-1;i++){
                //det+=i*determinant(new_arr);
                
                for (int j = 0,k=0; j < size -1; j++,k++) {
                    if(j == l){
                        k++;
                    }
                    new_arr[i][j] = arr[i+1][k];
                }
                
                //  1 2 3 
                //  0 2 3
                //  0 1 3
                //  0 1 2
            }
            
              //printArray(new_arr);
              det+=arr[0][l]*determinant(new_arr);

          }
            
        }
        
        
        return det;
    }
    public static void main(String[] args){
        
        
        System.out.println("Bismi Allah");
        System.out.println("");
        System.out.println("");
        int[][] arr = {
            {10,0,0,0},
            {6,10,0,0},
            {7,1,10,0},
            {1,9,2,10}
        };
        
        //printArray(arr);
        System.out.println("");
        String begin_time = LocalDateTime.now().toString().split(":")[2];
        float begin = (float) parseDouble(begin_time);
        //System.out.println(begin);
        System.out.println(determinant(arr));
        String end_time = LocalDateTime.now().toString().split(":")[2];
        float end = (float) parseDouble(end_time);
        //System.out.println(end);
        double run_time = end-begin;
        System.out.println("Time is : "+run_time);
        
    }
}

