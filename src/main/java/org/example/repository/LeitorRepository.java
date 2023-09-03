package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class LeitorRepository {
    public LeitorRepository(){}
    public LeitorRepository(Connection connection) {
        this.connection = connection;
    }
    private Connection connection = connect();
    private PreparedStatement preparedStatement;
    public boolean cadastro(String nome,String cpf,String email,String senha){
        String sql = "INSERT INTO leitor (nome,cpf,email,senha) VALUES (?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cpf);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, senha);
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean login(String email,String senha){
        try {
            String SQL = "SELECT * FROM leitor WHERE email= ? AND senha= ?";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if ((resultSet.getString("email").equals(email)) && (resultSet.getString("senha").equals(senha))) {
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
}