import java.util.Scanner;

public class _17_PrintBinaryStringWithoutConsecutive1s {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        generateBinaryString("", n);
        in.close();
    }

    private static void generateBinaryString(String s, int n) {
        if(n == 0) {
            System.out.println(s);
            return;
        }
        generateBinaryString(s+'0', n-1);
        if(s.length() == 0 || s.charAt(s.length()-1) != '1') {
            generateBinaryString(s+'1', n-1);
        }
    }
}
