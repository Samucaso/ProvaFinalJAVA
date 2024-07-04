package com.example.main;

import com.example.dao.AlunoDAO;
import com.example.model.Aluno;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();

        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite o email do aluno:");
        String email = scanner.nextLine();

        System.out.println("Digite o CPF do aluno:");
        String cpf = scanner.nextLine();

        System.out.println("Digite a data de nascimento do aluno (dd/MM/yyyy):");
        String dataNascimentoStr = scanner.nextLine();
        Date dataNascimento = null;
        try {
            dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Digite a naturalidade do aluno:");
        String naturalidade = scanner.nextLine();

        System.out.println("Digite o endereço do aluno:");
        String endereco = scanner.nextLine();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCpf(cpf);
        aluno.setDataNascimento(dataNascimento);
        aluno.setNaturalidade(naturalidade);
        aluno.setEndereco(endereco);

        alunoDAO.save(aluno);

        System.out.println("Aluno salvo com sucesso!");

        List<Aluno> alunos = alunoDAO.list();
        for (Aluno alunoListado : alunos) {
            System.out.println("ID: " + alunoListado.getId());
            System.out.println("Nome: " + alunoListado.getNome());
            System.out.println("Email: " + alunoListado.getEmail());
            System.out.println("CPF: " + alunoListado.getCpf());
            System.out.println("Data de Nascimento: " + alunoListado.getDataNascimento());
            System.out.println("Naturalidade: " + alunoListado.getNaturalidade());
            System.out.println("Endereço: " + alunoListado.getEndereco());
            System.out.println("--------------------------------");
        }

        System.out.println("Digite a letra inicial do nome para filtrar:");
        String letra = scanner.nextLine();

        List<Aluno> alunosFiltrados = alunoDAO.findByNomeStartingWith(letra);
        for (Aluno alunoFiltrado : alunosFiltrados) {
            System.out.println("ID: " + alunoFiltrado.getId());
            System.out.println("Nome: " + alunoFiltrado.getNome());
            System.out.println("Email: " + alunoFiltrado.getEmail());
            System.out.println("CPF: " + alunoFiltrado.getCpf());
            System.out.println("Data de Nascimento: " + alunoFiltrado.getDataNascimento());
            System.out.println("Naturalidade: " + alunoFiltrado.getNaturalidade());
            System.out.println("Endereço: " + alunoFiltrado.getEndereco());
            System.out.println("--------------------------------");
        }
    }
}
