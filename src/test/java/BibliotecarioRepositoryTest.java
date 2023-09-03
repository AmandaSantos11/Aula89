import org.example.repository.BibliotecarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.Mockito.*;

public class BibliotecarioRepositoryTest {
    private BibliotecarioRepository bibliotecario;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet result = mock(ResultSet.class);
    private ByteArrayOutputStream capturaASaidaDoConsole = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(capturaASaidaDoConsole));

        try {
            when(connect.prepareStatement(anyString())).thenReturn(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bibliotecario = new BibliotecarioRepository(connect);
    }

    @Test
    void testRegistrarAutor() {
        try {
            when(statement.executeUpdate()).thenReturn(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bibliotecario.registrarAutor("Matheus","11111111111","math@gmail.com");

        String mensagemEsperada = "Conectado ao servidor PostgreSQL com sucesso!";

        Assertions.assertEquals(mensagemEsperada.replaceAll("\\r?\\n", ""),capturaASaidaDoConsole.toString().trim().replaceAll("\\r?\\n", ""));
    }

    @Test
    void testLoginValido() throws SQLException {
        when(statement.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(true);
        when(result.getInt("acesso")).thenReturn(1234);

        boolean resultado = bibliotecario.login(1234);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testLoginInvalido() throws SQLException {
        when(statement.executeQuery()).thenReturn(result);
        when(result.next()).thenReturn(false);

        boolean resultado = bibliotecario.login(1234);

        Assertions.assertFalse(resultado);
    }

    @Test
    void testRegistrarLivro()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.registrarLivro("Bolhas ao vento","descrição doida","Aventura");

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarLivro()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.deletarLivro(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarAutor()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.deletarAutor(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testDeletarLeitor()throws SQLException {
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.deletarLeitor(1);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdAutorAoLivro()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.associarIdAutorAoLivro(1, 2);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdLivroAoAutor()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean resultado = bibliotecario.associarIdLivroAoAutor(1, 2);

        Assertions.assertTrue(resultado);
    }
}