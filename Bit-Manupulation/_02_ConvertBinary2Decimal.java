
import java.util.Scanner;

public class _02_ConvertBinary2Decimal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String binary = in.next();
        System.out.println("Decimal Value of "+binary+" is :"+ convertBinary2Decimal(binary));
        in.close();
    }

    private static int convertBinary2Decimal(String binary) {
        int decimalValue = 0;
        int n = binary.length();
        int powOf2 = 1;
        for(int i=n-1; i>=0; i--) {
            if(binary.charAt(i) == '1') {
                decimalValue += powOf2;
            }
            powOf2 *= 2;
        }
        return decimalValue;
    }
}
