package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    public String toString() {
        return "Terreno: " + "\n" + "Valor do imóvel: " + getValorImovel() + "\n" + "Prazo do financiamento: " + getPrazoFinanciamento() + "\n" + "Taxa de juros anual: " + getTaxaJurosAnual() + "\n" + "Tipo de zona: " + tipoZona + "\n" + "Pagamento mensal: " + calcularPagamentoMensal() + "\n" + "Total do pagamento: " + calcularTotalPagamento() + "\n";
    }
    public double calcularPagamentoMensal() {
        return (getValorImovel() / getPrazoFinanciamento()) * (1 + (getTaxaJurosAnual() / 12)) * 1.02;
}
}
