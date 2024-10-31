package CRUD;

import CONEXAODB.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUD {

    private String tabela;

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public void insert(String[] colunas, String[] valores) {
        // Gera a string de parâmetros "? , ?" com o tamanho correto
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            placeholders.append("?");
            if (i < valores.length - 1) {
                placeholders.append(", ");
            }
        }

        String sql = "INSERT INTO " + tabela + " (" + String.join(", ", colunas) + ") VALUES (" + placeholders.toString() + ")";

        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < valores.length; i++) {
                stmt.setString(i + 1, valores[i]);
            }

            stmt.executeUpdate();
            System.out.println("Registro foi adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String atributo, String valorAntigo, String valorNovo) {
        String sql = "UPDATE " + tabela + " SET " + atributo + " = ? WHERE " + atributo + " = ?";

        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, valorNovo);
            stmt.setString(2, valorAntigo);
            stmt.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void drop(int id) {
        String colunaId;

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
            default:
                System.out.println("Tabela inválida!");
                return;
        }

        String sql = "DELETE FROM " + tabela + " WHERE " + colunaId + " = ?";
        try (Connection conn = new DB().conectarDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Registro foi removido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select() {
        String sql = "SELECT * FROM " + getTabela();

        try (Connection conn = new DB().conectarDB()) {
            if (conn == null) {
                System.out.println("Conexão não estabelecida. Verifique a configuração do banco de dados.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
