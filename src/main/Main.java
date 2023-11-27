package main;

import util.InterfaceUsuario;
import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;

import java.util.ArrayList;
import java.io.*;

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
        Financiamento financiamentoUsuario = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual) {
            @Override
            public double calcularPagamentoMensal() {
                return (getValorImovel() / getPrazoFinanciamento()) * (1 + (getTaxaJurosAnual() / 12)) + 80;
            }
        };
        financiamentos.add(financiamentoUsuario);

        // Adicionando os objetos de financiamento pré-definidos
        financiamentos.add(new Casa(40000, 24, 11, 10, 30));
        financiamentos.add(new Apartamento(50000, 18, 10, 2, 1));
        financiamentos.add(new Apartamento(60000, 72, 9, 3, 1));
        financiamentos.add(new Terreno(90000, 36, 8, "Norte"));
        financiamentos.add(new Terreno(30000, 24, 12, "Sul"));

        // Adicionando o custo de cada financiamento no total
        for(Financiamento f : financiamentos) {
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\nTotal de Todos os Imóveis: R$ " + totalImoveis);
        System.out.println("Total de Todos os Financiamentos: R$ " + totalFinanciamentos);

        financiamentos.forEach(financiamento -> {
            System.out.println(financiamento.toString());
        });
        /*
        for (int i = 0; i < financiamentos.size(); i++) {

            Financiamento f = financiamentos.get(i);
            System.out.println("Financiamento " + (i + 1) +
                    " - Valor do Imóvel: R$ " + f.getValorImovel() +
                    ", Valor do Financiamento: R$ " + f.calcularTotalPagamento());
        }
        */

        salvarDadosFinanciamentos(financiamentos);
        lerDadosFinanciamentos();
        salvarArrayListSerializado(financiamentos);
        lerArrayListSerializado();

        System.out.println("Execução realizada com sucesso");
    }

    public static void salvarDadosFinanciamentos(ArrayList<Financiamento> financiamentos) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("financiamentos.txt"));
            for (Financiamento f : financiamentos) {
                writer.println(f.toString());
            }
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerDadosFinanciamentos() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("financiamentos.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarArrayListSerializado(ArrayList<Financiamento> financiamentos) {
        try {
            FileOutputStream fileOut = new FileOutputStream("financiamentos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(financiamentos);
            out.close();
            fileOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static void lerArrayListSerializado() {
        try {
            FileInputStream fileIn = new FileInputStream("financiamentos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Financiamento> financiamentosRecuperados = (ArrayList<Financiamento>) in.readObject();
            in.close();
            fileIn.close();

            // Printing recovered financing
            for (Financiamento f : financiamentosRecuperados) {
                System.out.println(f);
            }
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("Class Financiamento not found");
            c.printStackTrace();
        }
    }

}
