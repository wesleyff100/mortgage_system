package modelo;

public class Apartamento extends Financiamento {
    private int numVagasGaragem;
    private int numAndar;


    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numAndar, int numVagasGaragem) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numAndar = numAndar;
        this.numVagasGaragem = numVagasGaragem;

    }
        @Override
    public String toString() {
        return "Apartamento: " + "\n" + "Valor do imóvel: " + getValorImovel() + "\n" + "Prazo do financiamento: " + getPrazoFinanciamento() + "\n" + "Taxa de juros anual: " + getTaxaJurosAnual() + "\n" + "Número de vagas na garagem: " + numVagasGaragem + "\n" + "Número do andar: " + numAndar + "\n" + "Pagamento mensal: " + calcularPagamentoMensal() + "\n" + "Total do pagamento: " + calcularTotalPagamento() + "\n";
    }
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / getPrazoFinanciamento()) * (1 + (getTaxaJurosAnual() / 12)) + 80;
    }
}
