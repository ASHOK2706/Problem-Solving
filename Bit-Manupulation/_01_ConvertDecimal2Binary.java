/*

*/

import java.util.Scanner;

public class _01_ConvertDecimal2Binary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Binary Reprasantaion of "+n+" is : "+convertDecimal2Binary(n));
        in.close();
    }

    private static String convertDecimal2Binary(int n) {
        String result = "";
        while(n != 0) {
            if(n % 2 == 1) {
                result = '1' + result;
            }
            else {
                result = '0' + result;
            }
            n = n / 2;
        }
        return result;
    }
}