package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class BibliotecarioRepository {
    public BibliotecarioRepository(){}
    public BibliotecarioRepository(Connection connection) {
        this.connection = connection;
    }
    private Connection connection = connect();
    private PreparedStatement preparedStatement;
    public boolean registrarAutor(String nome, String cpf, String email) {
        String sql = "INSERT INTO autor (nome,cpf,email) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
//            System.out.println("Autor registrado!\n");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean login(int acesso){
        String sql = "SELECT * FROM bibliotecario WHERE acesso = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,acesso);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getInt("acesso") == acesso){
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean registrarLivro(String titulo, String descricao, String genero){
        String sql = "INSERT INTO livros (titulo,descricao,genero) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, descricao);
            preparedStatement.setString(3, genero);
            preparedStatement.executeUpdate();
            System.out.println("Livro registrado!\n");
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deletarLivro(int id){
        String sql = "DELETE FROM livros WHERE id_livro = ?";
        try {
            PreparedStatement prepared_livro = connection.prepareStatement(sql);
            prepared_livro.setInt(1, id);
            prepared_livro.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deletarAutor(int id){
        String sql = "DELETE FROM autor WHERE id_autor = ?";
        try {
            PreparedStatement prepared= connection.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deletarLeitor(int id){
        String sql = "DELETE FROM leitor WHERE id_leitor = ?";
        try {
            PreparedStatement prepared = connection.prepareStatement(sql);
            prepared.setInt(1, id);
            prepared.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean associarIdAutorAoLivro(int id_autor, int id_livro){
        String sql = "UPDATE livros SET id_autor = ? WHERE id_livro = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_autor);
            preparedStatement.setInt(2,id_livro);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean associarIdLivroAoAutor(int id_livro, int id_autor){
        String sql = "UPDATE autor SET id_livro = ? WHERE id_autor = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_livro);
            preparedStatement.setInt(2,id_autor);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}