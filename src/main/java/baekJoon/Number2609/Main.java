package baekJoon.Number2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
	public static int calNumber(int num1, int num2) {
		int minMax = minMax(num1, num2);
		return (num1 * num2)/minMax;
	}
	
    public static int minMax(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        } else {
            return minMax(num2, num1%num2);
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<len; i++) {
        	String[] split = br.readLine().split(" ");
        	int[] array = new int[2];
        	for (int j = 0; j < split.length; j++) {
				array[j] = Integer.parseInt(split[j]);
			}
            Arrays.sort(array);
            sb.append(calNumber(array[1], array[0]) + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}
