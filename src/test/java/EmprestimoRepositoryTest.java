import org.example.repository.EmprestimoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class EmprestimoRepositoryTest {
    private EmprestimoRepository emprestimo;
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

        emprestimo = new EmprestimoRepository(connect);
    }

    @Test
    void testEfetuarEmprestimo() throws SQLException {
        boolean resultado = emprestimo.efetuarEmprestimo(1, 2);

        verify(statement).executeUpdate();

        verify(statement).setInt(1, 1);
        verify(statement).setInt(2, 2);
        verify(statement).setBoolean(3, true);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAssociarIdLeitorAoEmprestimo()throws SQLException{
        boolean resultado = emprestimo.associarIdLeitorAoEmprestimo(1, 2);

        verify(statement).executeUpdate();

        verify(statement).setInt(1, 1);
        verify(statement).setInt(2, 2);

        Assertions.assertTrue(resultado);
    }

    @Test
    void testAtualizarStatusDoLivro()throws SQLException{
        boolean resultado = emprestimo.atualizarStatusDoLivro(1);

        verify(statement).executeUpdate();

        verify(statement).setBoolean(1, false);
        verify(statement).setInt(2, 1);

        Assertions.assertTrue(resultado);
    }
}