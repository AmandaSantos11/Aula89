package org.example.controller;
import org.example.model.*;
import org.example.repository.BibliotecarioRepository;
public class BibliotecarioController {
    BibliotecarioRepository bibliotecarioRepository = new BibliotecarioRepository();
    BibliotecarioModel bibliotecarioModel = new BibliotecarioModel();
    AutorModel autorModel = new AutorModel();
    LeitorModel leitorModel = new LeitorModel();
    LivroModel livroModel = new LivroModel();
    public boolean registrarAutor(String nome,String cpf,String email){
        autorModel.setNome(nome);
        autorModel.setCpf(cpf);
        autorModel.setEmail(email);

        return bibliotecarioRepository.registrarAutor(autorModel.getNome(),autorModel.getCpf(),autorModel.getEmail());
    }
    public boolean login(int acesso){
        bibliotecarioModel.setAcesso(acesso);
        return bibliotecarioRepository.login(bibliotecarioModel.getAcesso());
    }
    public boolean registrarLivro(String titulo, String descricao, String genero) {
        livroModel.setTitulo(titulo);
        livroModel.setDescricao(descricao);
        livroModel.setGenero(genero);
        return bibliotecarioRepository.registrarLivro(livroModel.getTitulo(), livroModel.getDescricao(), livroModel.getGenero());
    }

    public boolean deletarLivro(int id){
        livroModel.setId_livro(id);
        return bibliotecarioRepository.deletarLivro(livroModel.getId_livro());
    }
    public boolean deletarAutor(int id){
        autorModel.setId_autor(id);
        return bibliotecarioRepository.deletarLivro(autorModel.getId_autor());
    }
    public boolean deletarLeitor(int id){
        leitorModel.setId_leitor(id);
        return bibliotecarioRepository.deletarLivro(leitorModel.getId_leitor());
    }
    public boolean associarIdAutorAoLivro(int id_autor, int id_livro) {
        livroModel.setId_autor(id_autor);
        livroModel.setId_livro(id_livro);
        return bibliotecarioRepository.associarIdAutorAoLivro(livroModel.getId_autor(),livroModel.getId_livro());
    }
    public boolean associarIdLivroAoAutor(int id_livro, int id_author){
        autorModel.setId_livro(id_livro);
        autorModel.setId_autor(id_author);
        return bibliotecarioRepository.associarIdLivroAoAutor(autorModel.getId_livro(),autorModel.getId_autor());
    }
}