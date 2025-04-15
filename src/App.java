import java.io.IOException;
import java.util.Scanner;

import utils.Utils;

public class App {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int opcao;
        do {

            opcao = obterEscolhaMenu();

            // executa a funcionalidade conforme escolhido pelo usuario
            processarEscolha(opcao);
        } while (opcao != 6);
    }

    private static int obterEscolhaMenu() {
        Utils.imprimirLogoASCII();
        Utils.imprimirMensagemComMoldura("           DESAFIO TARGET SISTEMAS          ");
        System.out.println("+ ---------------------------------------------+ ");
        System.out.println("| Selecione a opção que deseja executar        | ");
        System.out.println("| 1 - Somar                                    | ");
        System.out.println("| 2 - Fibonacci                                | ");
        System.out.println("| 3 - Faturamento Diário                       | ");
        System.out.println("| 4 - Faturamento mensal de uma distribuidora  | ");
        System.out.println("| 5 - Inverta os caracteres                    | ");
        System.out.println("| 6 - Finalizar                                | ");
        System.out.println("+ ---------------------------------------------+ ");
        
        int opcao = teclado.nextInt();
        teclado.nextLine();
        return opcao;
    }

    private static void processarEscolha(int opcao) {
        switch (opcao) {
            case 1:
                limparTela();
                questao1();
                pausa();
                break;
            case 2:
                limparTela();
                questao2();
                pausa();
                break;
            case 3:
                limparTela();
                questao3();
                pausa();
                break;
            case 4:
                limparTela();
                questao4();
                pausa();
                break;
            case 5:
                limparTela();
                questao5();
                pausa();
                break;
            case 6:
                limparTela();
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção Inválida ! Tente novamente");
                break;
        }
    }

    private static void pausa() {
        System.out.println("\nTecle ENTER para continuar.");
        teclado.nextLine();
        limparTela();
    }

    private static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();

        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void questao1() {
        System.out.println(Soma.somar());
    }

    public static void questao2() {
        Fibonacci.lerDados();
    }

    public static void questao3() {
        FaturamentoDiario.LerRegistro();
    }

    public static void questao4() {
        FaturamentoMensal.faturamento();
    }

    public static void questao5() {
        System.out.println("Digite uma palavra");
        String input = teclado.nextLine();
        Inverter.reverter(input);
    }

}
