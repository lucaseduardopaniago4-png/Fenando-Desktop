package util; 

import java.sql.Connection;     
import java.sql.DriverManager;   
import java.sql.SQLException;    

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/bancoagro";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123";

    /**
     * Método responsável por criar e retornar uma conexão com o banco de dados.
     * 
     * @return Connection (objeto de conexão com o banco)
     */
    public static Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver PostgreSQL não encontrado.", e);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco.", e);
        }
    }

    /**
     * Método responsável por fechar a conexão com o banco.
     * 
     * @param con conexão que será fechada
     */
    public static void fechar(Connection con) {
        try {
            if (con != null) {
                con.close(); 
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão.");
        }
    }
}