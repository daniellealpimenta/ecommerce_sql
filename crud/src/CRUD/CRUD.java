// ### INÍCIO COMENTARIOS ANA JULIA ###

// Pacote onde essa classe está
package CRUD;

// Bibliotecas/classes importadas  
import CONEXAODB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {
    // Declarando atributo privado do tipo String
    private String tabela;
    // Metodo get do atributo(é o metodo que pega o valor salvo no atributo)
    public String getTabela() {
        return tabela;
    }
    // Metodo set do atributo(é o metodo que atribui valor no atributo)
    public void setTabela(String tabela) {
        this.tabela = tabela;
    }
    // Método de insert que recebe dois arrays de strings como parametro o colunas (tem nomes das colunas) e valores (tem os valores a serem inseridos)
    public void insert(String[] colunas, String[] valores) {
        //  Inicializa um objeto StringBuilder como o nome placeholders 
        StringBuilder placeholders = new StringBuilder();
        // Loop que percorre todos os elementos do array valores
        for (int i = 0; i < valores.length; i++) {
	    // A cada iteração adiciona um placeholder para receber um valor posteriormente 
            placeholders.append("?");
	    // Verifica se o indice é o último do array
            if (i < valores.length - 1) {
                placeholders.append(", ");
            }
        }

	// Cria uma a query de insert, juntando o nome da tabela, das colunas e os placeholders
        String sql = "INSERT INTO " + tabela + " (" + String.join(", ", colunas) + ") VALUES (" + placeholders.toString() + ")";
	// Tenta estabelecer uma conexão com o banco de dados 
        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Atribui os valores do array valores aos placeholders adicionados anteriormente
            for (int i = 0; i < valores.length; i++) {
                stmt.setString(i + 1, valores[i]);
            }
	    //Executa a query   
            stmt.executeUpdate();
	    // Imprime uma mensagem de sucesso
            System.out.println("Registro foi adicionado com sucesso!");
	  // Se ocorrer uma exceção SQLException, imprime o erro
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método de updateque recebe três strings como parametro o atributo (nome da coluna que vai ser atualizada), o valorAntigo (valor atual do atributo) e valorNovo (novo valor do atributo)
    public void update(String atributo, String valorAntigo, String valorNovo) {
	// Cria uma a query de update, para atualizar o valor do atributo especificado
        String sql = "UPDATE " + tabela + " SET " + atributo + " = ? WHERE " + atributo + " = ?";
	// Tenta estabelecer uma conexão com o banco de dados 
        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
	    //Atribui os valores
            stmt.setString(1, valorNovo);
            stmt.setString(2, valorAntigo);
	    // Executa a atualização
            stmt.executeUpdate();
	    // Imprime uma mensagem de sucesso
            System.out.println("Registro atualizado com sucesso!");
	// Se ocorrer uma exceção SQLException, imprime o erro
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// ### FIM COMENTARIOS ANA JULIA ###


// ### COMENTÁRIOS FILIPI ###
    
    // Define um método drop que recebe parâmetro id 
    public void drop(int id) {
	//Declara o atributo colunaId do tipo String 
        String colunaId;
	// O  switch verifica o valor da variável tabela e define a variável colunaId com o nome da coluna correspondente
        switch (tabela) {
            case "Clientes":
                colunaId = "Cliente_ID";
                break;
            case "Enderecos":
                colunaId = "Endereco_ID";
                break;
            case "Categorias":
                colunaId = "Categoria_ID";
                break;
            case "Fornecedores":
                colunaId = "Fornecedor_ID";
                break;
            case "Produtos":
                colunaId = "Produto_ID";
                break;
            case "Status_Pedido":
                colunaId = "Status_ID";
                break;
            case "Vendas":
                colunaId = "Venda_ID";
                break;
            case "Pagamentos":
                colunaId = "Pagamento_ID";
                break;
            case "Itens_Venda":
                colunaId = "Item_ID";
                break;
            case "Carrinho":
                colunaId = "Carrinho_ID";
                break;
	    // Se não corresponder a nenhum dos casos, imprime “Tabela inválida!” e encerra o método.
            default:
                System.out.println("Tabela inválida!");
                return;
        }
	//Cria uma variavel string sql que com o comando SQL para deletar um registro da tabela especificada 
	String sql = "DELETE FROM " + tabela + " WHERE " + colunaId + " = ?";
	//Tenta fazer uma conexão com o banco de dados 
        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
	    // Define o valor do id
            stmt.setInt(1, id);
	    // Executa a ação delete no banco de dados
            stmt.executeUpdate();
	    // Imprime se a ação for bem-sucedida.
            System.out.println("Registro foi removido com sucesso!");
	  // Imprime um StackTrace caso haja alguma SQLException 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //// Define o método void select que nao recebe parâmetro
    public void select() {
	//Cria uma variavel string sql que com o comando SQL para selecionar os registros da tabela especificada 
        String sql = "SELECT * FROM " + getTabela();
	
	//Tenta fazer uma conexão com o banco de dados 
        try (Connection conn = new DB().conectarDB()) {
	    // Se for null, imprime uma mensagem de erro e encerra o método
            if (conn == null) {
                System.out.println("Conexão não estabelecida. Verifique a configuração do banco de dados.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql);
		 // Executa a consulta SQL e armazena o resultado em um ResultSet
                 ResultSet rs = stmt.executeQuery()) {
		// Itera sobre os resultados da consulta (rs.next()) de acordo com valor da tabela, imprime os dados daquela tabela.
                while (rs.next()) {
                    switch (tabela) {
                        case "Clientes":
                            System.out.println("ID: " + rs.getInt("Cliente_ID") + ", Nome: " + rs.getString("Nome"));
                            break;
                        case "Enderecos":
                            System.out.println("ID: " + rs.getInt("Endereco_ID") + ", Rua: " + rs.getString("Rua"));
                            break;
                        case "Categorias":
                            System.out.println("ID: " + rs.getInt("Categoria_ID") + ", Nome: " + rs.getString("Nome"));
                            break;
                        case "Fornecedores":
                            System.out.println("ID: " + rs.getInt("Fornecedor_ID") + ", Nome: " + rs.getString("Nome"));
                            break;
                        case "Produtos":
                            System.out.println("ID: " + rs.getInt("Produto_ID") + ", Nome: " + rs.getString("Nome") + ", Preço: " + rs.getDouble("Preco"));
                            break;
                        case "Status_Pedido":
                            System.out.println("ID: " + rs.getInt("Status_ID") + ", Descrição: " + rs.getString("Descricao"));
                            break;
                        case "Vendas":
                            System.out.println("ID: " + rs.getInt("Venda_ID") + ", Data da Venda: " + rs.getDate("Data_Venda"));
                            break;
                        case "Pagamentos":
                            System.out.println("ID: " + rs.getInt("Pagamento_ID") + ", Valor Pago: " + rs.getDouble("Valor_Pago"));
                            break;
                        case "Itens_Venda":
                            System.out.println("ID: " + rs.getInt("Item_ID") + ", Quantidade: " + rs.getInt("Quantidade"));
                            break;
                        case "Carrinho":
                            System.out.println("ID: " + rs.getInt("Carrinho_ID") + ", Quantidade: " + rs.getInt("Quantidade"));
                            break;
                        default:
                            System.out.println("Tabela inválida!");
                            return;
                    }
                }
            }
	  // Imprime um StackTrace caso haja alguma SQLException
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
	

// ### COMENTÁRIOS FILIPI ###
