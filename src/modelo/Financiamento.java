package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    // Atributos da classe
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;


    // Construtor da classe Financiamento
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Métodos de acesso para os atributos privados
    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Método para calcular o pagamento mensal com base no valor do imóvel, prazo e taxa de juros
    public abstract double calcularPagamentoMensal();

    // Método para calcular o total do pagamento com base no pagamento mensal e prazo do financiamento
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento;
    }

    // Método para exibir os dados do financiamento
    public void mostrarDadosFinanciamento() {
        System.out.println("Valor do imóvel: " + getValorImovel());
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento());
        System.out.println("Taxa de juros anual: " + getTaxaJurosAnual());
    }
}
