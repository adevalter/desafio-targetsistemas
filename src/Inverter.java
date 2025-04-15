public class Inverter {

    public static void reverter(String input) {
        

        char[] caracteres = input.toCharArray();

        int inicio = 0;
        int fim = caracteres.length - 1;

        while (inicio < fim) {

            char temp = caracteres[inicio];
            caracteres[inicio] = caracteres[fim];
            caracteres[fim] = temp;

            inicio++;
            fim--;
        }

        String resultado = new String(caracteres);

        System.out.println("String invertida: " + resultado);
    }

}
