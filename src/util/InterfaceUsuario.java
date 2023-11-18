package util;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InterfaceUsuario {
    // Scanner para receber entrada do usuário
    private Scanner scanner;

    // Construtor que inicializa o scanner
    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Método para solicitar ao usuário o valor do imóvel
    public double pedirValorImovel() {
        double valorImovel;

        do {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorImovel = scanner.nextDouble();

                if (valorImovel <= 0) {
                    System.out.println("Por favor, digite um valor válido maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um valor válido.");
                scanner.next(); // Limpar o buffer do scanner
                valorImovel = -1; // Definir um valor inválido para continuar no loop
            }

        } while (valorImovel <= 0);

        return valorImovel;
    }

    // Método para solicitar ao usuário o prazo do financiamento
    public int pedirPrazoFinanciamento() {
        int prazoFinanciamento;

        do {
            try {
                System.out.println("Digite o prazo do financiamento em anos: ");
                prazoFinanciamento = scanner.nextInt();

                if (prazoFinanciamento <= 0 || prazoFinanciamento > 35) {
                    System.out.println("Por favor, digite um valor válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um valor válido.");
                scanner.next(); // Limpar o buffer do scanner
                prazoFinanciamento = -1; // Definir um valor inválido para continuar no loop
            }

        } while (prazoFinanciamento <= 0 || prazoFinanciamento > 35);

        return prazoFinanciamento;
    }

    // Método para solicitar ao usuário a taxa de juros anual
    public double pedirTaxaJurosAnual() {
        double taxaJurosAnual;

        do {
            try {
                System.out.println("Digite a taxa de juros anual: ");
                taxaJurosAnual = scanner.nextDouble();

                if (taxaJurosAnual <= 0 || taxaJurosAnual > 1000) {
                    System.out.println("Por favor, digite um valor válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite um valor válido.");
                scanner.next(); // Limpar o buffer do scanner
                taxaJurosAnual = -1; // Definir um valor inválido para continuar no loop
            }

        } while (taxaJurosAnual <= 0 || taxaJurosAnual > 1000);

        return taxaJurosAnual;
    }
}
