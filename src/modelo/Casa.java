package modelo;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;

    }
    public String toString() {
        return "Casa: " + "\n" + "Valor do imóvel: " + getValorImovel() + "\n" + "Prazo do financiamento: " + getPrazoFinanciamento() + "\n" + "Taxa de juros anual: " + getTaxaJurosAnual() + "\n" + "Área construída: " + areaConstruida + "\n" + "Tamanho do terreno: " + tamanhoTerreno + "\n" + "Pagamento mensal: " + calcularPagamentoMensal() + "\n" + "Total do pagamento: " + calcularTotalPagamento() + "\n";
    }
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / getPrazoFinanciamento()) * (1 + (getTaxaJurosAnual() / 12)) + 80;
    }
}
