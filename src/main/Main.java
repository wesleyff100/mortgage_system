package main;

import util.InterfaceUsuario;
import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        System.out.println("\nDetalhes dos Financiamentos:");

        // Recebendo o primeiro financiamento do usuário
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();
        Financiamento financiamentoUsuario = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        financiamentos.add(financiamentoUsuario);

        // Adicionando os objetos de financiamento pré-definidos
        financiamentos.add(new Casa(40000, 15, 11));
        financiamentos.add(new Apartamento(40000, 15, 11));
        financiamentos.add(new Apartamento(40000, 15, 11));
        financiamentos.add(new Terreno(40000, 15, 11));
        financiamentos.add(new Terreno(40000, 15, 11));

        // Adicionando o custo de cada financiamento no total
        for(Financiamento f : financiamentos) {
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\nTotal de Todos os Imóveis: R$ " + totalImoveis);
        System.out.println("Total de Todos os Financiamentos: R$ " + totalFinanciamentos);

        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento f = financiamentos.get(i);
            System.out.println("Financiamento " + (i + 1) +
                    " - Valor do Imóvel: R$ " + f.getValorImovel() +
                    ", Valor do Financiamento: R$ " + f.calcularTotalPagamento());
        }

        System.out.println("Execução realizada com sucesso");
    }
}
