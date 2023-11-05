/*Write a program non-recursive and recursive program to calculate
Fibonacci numbers and analyze their time and space complexity.*/

import java.util.Scanner;
// FibonacciSequence non-recursive
public class FibonacciSequence_1a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many terms? ");
        int nTerms = scanner.nextInt();

        // First two terms
        int n1 = 0, n2 = 1;
        int count = 0;

        // Check if the number of terms is valid
        if (nTerms <= 0) {
            System.out.println("Please enter a positive integer");
        } else if (nTerms == 1) {
            System.out.println("Fibonacci sequence up to " + nTerms + ":");
            System.out.println(n1);
        } else {
            System.out.println("Fibonacci sequence:");
            while (count < nTerms) {
                System.out.println(n1);
                int nth = n1 + n2;
                // Update values
                n1 = n2;
                n2 = nth;
                count++;
            }
        }
    }
}
