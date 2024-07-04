import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testaConexão {
    public static void main(String[] args) {
        // URL de conexão ao banco de dados MySQL
        String jdbcUrl = "jdbc:mysql://localhost:3306/escola"; // "escola" é o nome do banco de dados
        String username = "root"; // Usuário padrão do MySQL no XAMPP
        String password = ""; // Senha do usuário root. Por padrão, é vazio no XAMPP

        try {
            // Tenta estabelecer a conexão
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexão estabelecida com sucesso!");
            // Fecha a conexão
            connection.close();
        } catch (SQLException e) {
            // Imprime qualquer erro que ocorra durante a conexão
            e.printStackTrace();
        }
    }
}
