package CONEXAODB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por realizar a conexão com o Banco de Dados.
 *
 * @author erickTavaresNunes
 */

public class DB {

    //Declarando os atributos que serão usados para conexão com o banco de dados, url, usuario e senha do banco
    private final String url = "jdbc:mysql://localhost:3307/ecommerce";
    private final String usuario = "root";
    private final String senha = "catolica";

    /**
     * Função para conexão com banco de dados
     *
     * @return a função retorna a conexão com o banco de dados, caso tenha dado erro, retorna NULL.
     */
    public Connection conectarDB() {
        Connection connection = null;

        try {
            //Carregando o driver JDBC do MYSQL para conectar com BD
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Criando um variavel connection para estabelecer a conexão com o BD com os parâmetro passados anteriormente
            connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (ClassNotFoundException e) {
            //caso a conexão com o BD não seja sucedida, tratamos o erro usando uma exception: "ClassNotFoundException"
            System.out.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            //Caso não seja uma exception de classe não encontrada, tratamos com uma exception geral: "SQLException"
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return connection; // Retorna null se houver erro na conexão
    }

    /**
     * Função para encerrar conexão com Banco de Dados
     *
     * @param connection é um objeto da classe Connection, é utilizado para encerrar a conexão previamente estabelecida.
     */
    public void fecharConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close(); //função para encerrar BD
                System.out.println("Conexão fechada.");
            } catch (SQLException e) {
                //exeption caso aja erro de fechar a conexão com BD
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}
