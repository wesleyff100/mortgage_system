package modelo;

public class Terreno extends Financiamento {
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }
}
