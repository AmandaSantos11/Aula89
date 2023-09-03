package org.example.controller;
import org.example.model.LeitorModel;
import org.example.repository.LeitorRepository;
public class LeitorController {
    LeitorRepository leitorRepository = new LeitorRepository();
    LeitorModel leitorModel = new LeitorModel();
    public boolean cadastro(String nome,String cpf,String email,String senha){
        leitorModel.setNome(nome);
        leitorModel.setCpf(cpf);
        leitorModel.setEmail(email);
        leitorModel.setSenha(senha);

        return leitorRepository.cadastro(leitorModel.getNome(),leitorModel.getCpf(),leitorModel.getEmail(),leitorModel.getSenha());
    }
    public boolean login(String email,String senha){
        leitorModel.setEmail(email);
        leitorModel.setSenha(senha);

        return leitorRepository.login(leitorModel.getEmail(),leitorModel.getSenha());
    }
}