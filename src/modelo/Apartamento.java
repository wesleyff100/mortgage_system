package modelo;

public class Apartamento extends Financiamento {
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual()/12;
        double meses = getPrazoFinanciamento()*12;
        double valorImovel = getValorImovel();
        double numerador = valorImovel * Math.pow((1+taxaMensal), meses);
        double denominador = Math.pow((1+taxaMensal),meses -1);

        return numerador/denominador;
    }
}
