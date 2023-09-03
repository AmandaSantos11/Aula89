package org.example.model;

public class LeitorModel {
    private int id_leitor;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private EmprestimoModel id_emprestimo;
    public int getId_leitor() {
        return id_leitor;
    }
    public void setId_leitor(int id_leitor) {
        this.id_leitor = id_leitor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public EmprestimoModel getId_emprestimo() {
        return id_emprestimo;
    }
    public void setId_emprestimo(EmprestimoModel id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }
}