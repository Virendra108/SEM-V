import java.util.Scanner;

public class HammingCode {
    public static void main(String[] args) {
        int[] arr = new int[7];
        int p1, p2, p4;
        
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter the element of bit code: ");
            arr[i] = sc.nextInt();
        }
        
        p1 = arr[0] ^ arr[2] ^ arr[4] ^ arr[6];
        p2 = arr[1] ^ arr[2] ^ arr[5] ^ arr[6];
        p4 = arr[3] ^ arr[4] ^ arr[5] ^ arr[6];
        
        int binaryNumber = (p4 << 2) | (p2 << 1) | p1;
        
        System.out.println("The decimal value of the binary number " + p4 + p2 + p1 + " is: " + binaryNumber);
        int ERRindex=binaryNumber - 1;
        if (binaryNumber>0) {
            System.out.println("So the error bit is at index position (-1): "+ ERRindex);
        }
        else{
            System.out.println("No error in the code");
        }
        if (binaryNumber != 0) {
            // Correcting the bit at position (binaryNumber - 1) due to zero-based indexing in Java
            int position = binaryNumber - 1;
            arr[position] = arr[position] == 0 ? 1 : 0;
        }
        
        System.out.print("Correct bit code is: ");
        for (int i = 0; i < 7; i++) {
            System.out.print(arr[i]);
        }
        
        sc.close();
    }
}
