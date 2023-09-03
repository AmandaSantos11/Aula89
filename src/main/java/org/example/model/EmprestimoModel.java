package org.example.model;
public class EmprestimoModel {
    private int id_emprestimo;
    private String data_retirada;
    private String data_devolucao;
    private Boolean status;
    private int id_leitor;
    private int id_livro;
    public int getId_emprestimo() {
        return id_emprestimo;
    }
    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }
    public String getData_retirada() {
        return data_retirada;
    }
    public void setData_retirada(String data_retirada) {
        this.data_retirada = data_retirada;
    }
    public String getData_devolucao() {
        return data_devolucao;
    }
    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public int getId_leitor() {
        return id_leitor;
    }
    public void setId_leitor(int id_leitor) {
        this.id_leitor = id_leitor;
    }
    public int getId_livro() {
        return id_livro;
    }
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
}