import java.util.Scanner;

public class Fibonacci {

    public static void lerDados() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe um número para verificar se pertence à sequência de Fibonacci: ");
        int number = teclado.nextInt();
        teclado.nextLine();

        boolean isFibonacci = Fibonacci.isNumberInFibonacci(number);

        if (isFibonacci) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
        }

    }

    private static boolean isNumberInFibonacci(int number) {
        if (number < 0) {
            return false;
        }

        int a = 0, b = 1;

        while (a <= number) {
            if (a == number) {
                return true;
            }
            int next = a + b;
            a = b;
            b = next;
        }

        return false;
    }
}
