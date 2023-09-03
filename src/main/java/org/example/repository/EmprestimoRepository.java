package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class EmprestimoRepository {
    public EmprestimoRepository(){}
    public EmprestimoRepository(Connection connection) {
        this.connection = connection;
    }
    private Connection connection = connect();
    private PreparedStatement prepareStatement;
    public boolean efetuarEmprestimo(int id_livro, int id_leitor){
        String sql_emprestimo = "INSERT INTO emprestimo (id_livro,id_leitor,status) VALUES (?,?,?)";
        try{
            PreparedStatement prepared_emprestimo = connection.prepareStatement(sql_emprestimo);
            prepared_emprestimo.setInt(1,id_livro);
            prepared_emprestimo.setInt(2,id_leitor);
            prepared_emprestimo.setBoolean(3, true);
            prepared_emprestimo.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean associarIdLeitorAoEmprestimo(int id_leitor, int id_emprestimo) {
        try {
            String sql = "UPDATE leitor SET id_emprestimo = ? WHERE id_leitor = ?";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(2,id_emprestimo);
            prepareStatement.setInt(1, id_leitor);
            prepareStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean atualizarStatusDoLivro(int id_livro){
        String sql_livro = "UPDATE livros SET status = ? WHERE id_livro = ?";
        try {
            PreparedStatement prepared_livro = connection.prepareStatement(sql_livro);
            prepared_livro.setBoolean(1, false);
            prepared_livro.setInt(2, id_livro);
            prepared_livro.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}