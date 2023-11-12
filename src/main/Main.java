import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Usando os métodos da classe InterfaceUsuario para ler os dados do financiamento
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

        // Instanciando um objeto do tipo Financiamento
        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

        // Exibindo os resultados
        System.out.println("Pagamento Mensal: " + financiamento.calcularPagamentoMensal());
        System.out.println("Total do Pagamento: " + financiamento.calcularTotalPagamento());
    }
}
