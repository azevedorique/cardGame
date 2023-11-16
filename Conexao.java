 import java.sql.*;
 public class Conexao {
    
    public static String URL = "jdbc:mysql://localhost:3306/conexao";
    public static String USER = "root";
    public static String PWD = "root";

    private Connection db = null;
    private Statement sql = null;
    private ResultSet result = null;

    public void OpenDataBase() {
        try {
            db = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Conectado com sucesso");
            sql = db.createStatement();
        } catch (Exception error) {
            System.out.println("Erro de conexão: " + error.getMessage());
        }
    }
    public void CloseDatabase() throws SQLException {
        sql.close();
        db.close();
    }
    public int ExecutaQuery(String my) {
        try {
            return sql.executeUpdate(my);

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return -1;
    }
    
}
