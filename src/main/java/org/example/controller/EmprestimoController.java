package org.example.controller;
import org.example.model.EmprestimoModel;
import org.example.model.LeitorModel;
import org.example.model.LivroModel;
import org.example.repository.EmprestimoRepository;
public class EmprestimoController {
    EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
    EmprestimoModel emprestimoModel = new EmprestimoModel();
    LivroModel livroModel = new LivroModel();
    LeitorModel leitorModel = new LeitorModel();
    public boolean efetuarEmprestimo(int id_livro, int id_leitor){
        livroModel.setId_livro(id_livro);
        leitorModel.setId_leitor(id_leitor);
        emprestimoModel.setId_livro(livroModel.getId_livro());
        emprestimoModel.setId_leitor(leitorModel.getId_leitor());
        return emprestimoRepository.efetuarEmprestimo(emprestimoModel.getId_livro(),emprestimoModel.getId_leitor());
    }
    public boolean associarIdLeitorAoEmprestimo(int id_leitor, int id_emprestimo){
        leitorModel.setId_leitor(id_leitor);
        emprestimoModel.setId_emprestimo(id_emprestimo);

        return emprestimoRepository.associarIdLeitorAoEmprestimo(leitorModel.getId_leitor(),emprestimoModel.getId_emprestimo());
    }
    public boolean atualizarStatusDoLivro(int id_livro){
        livroModel.setId_livro(id_livro);

        return emprestimoRepository.atualizarStatusDoLivro(livroModel.getId_livro());
    }
}