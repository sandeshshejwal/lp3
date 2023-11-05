/*Write a program non-recursive and recursive program to calculate
Fibonacci numbers and analyze their time and space complexity.*/

//RECURSIVE APPROACH

public class FibonacciSequence_1b {

    static int recurFibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recurFibo(n - 1) + recurFibo(n - 2);
        }
    }

    public static void main(String[] args) {
        int nTerms = 7;

        // Check if the number of terms is valid
        if (nTerms <= 0) {
            System.out.println("Please enter a positive integer");
        } else {
            System.out.println("Fibonacci sequence:");
            for (int i = 0; i < nTerms; i++) {
                System.out.println(recurFibo(i));
            }
        }
    }
}
