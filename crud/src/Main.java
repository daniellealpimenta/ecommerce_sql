import CONEXAODB.DB;
import CRUD.CRUD;

import java.util.Scanner;
import java.sql.Connection;
import java.util.InputMismatchException;

public class Main {

    //Atributo usado par manter o programa em execução
    static boolean ligado = true;
    //Esse atributo armazena a opção escolhida pelo usuário
    static int opcao;

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        // Iniciando a classe de conexão com BD
        DB conection = new DB();
        //Iniciando conexão com banco de dados a partir da função 'conectarDB()'
        Connection connection = conection.conectarDB();
        if (connection == null) {
            System.out.println("Falha ao conectar ao banco de dados. O programa será encerrado.");
            return; // Encerra o programa se não houver conexão
        }

        CRUD crud = new CRUD();

        while (ligado) {
            System.out.println("""
                    ------ MENU DE OPÇÕES ------
                    1 - ADICIONAR
                    2 - REMOVER
                    3 - EDITAR
                    4 - SELECIONAR
                    5 - SAIR
                    """);

            try {
                opcao = ler.nextInt();
                ler.nextLine(); // Consumir o '\n'

                switch (opcao) {
                    case 1:
                        // Adicionar registro
                        System.out.println("""
                                ------ ADICIONAR ------
                                QUAL TABELA VOCÊ GOSTARIA DE ADICIONAR INFORMAÇÕES?
                                1 - CLIENTES
                                2 - ENDEREÇOS
                                3 - CATEGORIAS
                                4 - FORNECEDORES
                                5 - PRODUTOS
                                6 - STATUS DE PEDIDO
                                7 - VENDAS
                                8 - PAGAMENTOS
                                9 - ITENS DE VENDA
                                10 - CARRINHO
                                """);
                        opcao = ler.nextInt();
                        ler.nextLine();

                        String[] colunas = null;
                        String[] valores;

                        switch (opcao) {
                            case 1:
                                crud.setTabela("Clientes");
                                colunas = new String[]{"Nome", "Email", "Telefone", "Data_Cadastro"};
                                break;
                            case 2:
                                crud.setTabela("Enderecos");
                                colunas = new String[]{"Cliente_ID", "Rua", "Cidade", "Estado", "CEP"};
                                break;
                            case 3:
                                crud.setTabela("Categorias");
                                colunas = new String[]{"Nome", "Descricao"};
                                break;
                            case 4:
                                crud.setTabela("Fornecedores");
                                colunas = new String[]{"Nome", "Contato", "Telefone", "Email", "Categoria_ID_Fornecedor"};
                                break;
                            case 5:
                                crud.setTabela("Produtos");
                                colunas = new String[]{"Nome", "Descricao", "Preco", "Estoque", "Categoria_ID", "Fornecedor_ID"};
                                break;
                            case 6:
                                crud.setTabela("Status_Pedido");
                                colunas = new String[]{"Descricao"};
                                break;
                            case 7:
                                crud.setTabela("Vendas");
                                colunas = new String[]{"Cliente_ID_Vendas", "Status_ID", "Data_Venda"};
                                break;
                            case 8:
                                crud.setTabela("Pagamentos");
                                colunas = new String[]{"Venda_ID_Pagamento", "Data_Pagamento", "Valor_Pago", "Metodo_Pagamento"};
                                break;
                            case 9:
                                crud.setTabela("Itens_Venda");
                                colunas = new String[]{"Produto_ID_Itens", "Venda_ID", "Quantidade", "Preco_Unitario"};
                                break;
                            case 10:
                                crud.setTabela("Carrinho");
                                colunas = new String[]{"Venda_ID_Carrinho", "Quantidade"};
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        valores = new String[colunas.length];
                        for (int i = 0; i < colunas.length; i++) {
                            if (i == colunas.length - 1){
                                System.out.println("Escreva a data nesse estilo: yyyy-mm-dd, se n da erro, animal");
                            }
                            System.out.printf("Digite o valor para %s: ", colunas[i]);
                            valores[i] = ler.nextLine();

                        }
                        crud.insert(colunas, valores);
                        break;

                    case 2:
                        // Remover registro
                        System.out.println("Qual tabela você gostaria de remover informações?\n");
                        System.out.println("""
                                ------ REMOVER ------
                                QUAL TABELA VOCÊ GOSTARIA DE REMOVER INFORMAÇÕES?
                                1 - CLIENTES
                                2 - ENDEREÇOS
                                3 - CATEGORIAS
                                4 - FORNECEDORES
                                5 - PRODUTOS
                                6 - STATUS DE PEDIDO
                                7 - VENDAS
                                8 - PAGAMENTOS
                                9 - ITENS DE VENDA
                                10 - CARRINHO
                                """);
                        int idOpcao = ler.nextInt();
                        System.out.println("Qual o ID do registro que você gostaria de remover?");
                        int id = ler.nextInt();
                        ler.nextLine();

                        switch (idOpcao) {
                            case 1:
                                crud.setTabela("Clientes");
                                break;
                            case 2:
                                crud.setTabela("Enderecos");
                                break;
                            case 3:
                                crud.setTabela("Categorias");
                                break;
                            case 4:
                                crud.setTabela("Fornecedores");
                                break;
                            case 5:
                                crud.setTabela("Produtos");
                                break;
                            case 6:
                                crud.setTabela("Status_Pedido");
                                break;
                            case 7:
                                crud.setTabela("Vendas");
                                break;
                            case 8:
                                crud.setTabela("Pagamentos");
                                break;
                            case 9:
                                crud.setTabela("Itens_Venda");
                                break;
                            case 10:
                                crud.setTabela("Carrinho");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        crud.drop(id);
                        break;

                    case 3:
                        // Editar registro
                        System.out.println("Qual tabela você gostaria de editar informações?\n");
                        System.out.println("""
                                ------ EDITAR ------
                                QUAL TABELA VOCÊ GOSTARIA DE EDITAR INFORMAÇÕES?
                                1 - CLIENTES
                                2 - ENDEREÇOS
                                3 - CATEGORIAS
                                4 - FORNECEDORES
                                5 - PRODUTOS
                                6 - STATUS DE PEDIDO
                                7 - VENDAS
                                8 - PAGAMENTOS
                                9 - ITENS DE VENDA
                                10 - CARRINHO
                                """);
                        int editOpcao = ler.nextInt();
                        System.out.println("Qual o atributo que você gostaria de alterar?");
                        String atributo = ler.next();
                        System.out.println("Qual o valor antigo que você gostaria de alterar?");
                        String valorAntigo = ler.next();
                        System.out.println("Qual o novo valor?");
                        String valorNovo = ler.next();

                        switch (editOpcao) {
                            case 1:
                                crud.setTabela("Clientes");
                                break;
                            case 2:
                                crud.setTabela("Enderecos");
                                break;
                            case 3:
                                crud.setTabela("Categorias");
                                break;
                            case 4:
                                crud.setTabela("Fornecedores");
                                break;
                            case 5:
                                crud.setTabela("Produtos");
                                break;
                            case 6:
                                crud.setTabela("Status_Pedido");
                                break;
                            case 7:
                                crud.setTabela("Vendas");
                                break;
                            case 8:
                                crud.setTabela("Pagamentos");
                                break;
                            case 9:
                                crud.setTabela("Itens_Venda");
                                break;
                            case 10:
                                crud.setTabela("Carrinho");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        crud.update(atributo, valorAntigo, valorNovo);
                        break;

                    case 4:
                        // Selecionar registro
                        System.out.println("Qual tabela você gostaria de selecionar as informações?\n");
                        System.out.println("""
                                ------ SELECIONAR ------
                                QUAL TABELA VOCÊ GOSTARIA DE SELECIONAR INFORMAÇÕES?
                                1 - CLIENTES
                                2 - ENDEREÇOS
                                3 - CATEGORIAS
                                4 - FORNECEDORES
                                5 - PRODUTOS
                                6 - STATUS DE PEDIDO
                                7 - VENDAS
                                8 - PAGAMENTOS
                                9 - ITENS DE VENDA
                                10 - CARRINHO
                                """);
                        int selectOpcao = ler.nextInt();
                        ler.nextLine();

                        switch (selectOpcao) {
                            case 1:
                                crud.setTabela("Clientes");
                                break;
                            case 2:
                                crud.setTabela("Enderecos");
                                break;
                            case 3:
                                crud.setTabela("Categorias");
                                break;
                            case 4:
                                crud.setTabela("Fornecedores");
                                break;
                            case 5:
                                crud.setTabela("Produtos");
                                break;
                            case 6:
                                crud.setTabela("Status_Pedido");
                                break;
                            case 7:
                                crud.setTabela("Vendas");
                                break;
                            case 8:
                                crud.setTabela("Pagamentos");
                                break;
                            case 9:
                                crud.setTabela("Itens_Venda");
                                break;
                            case 10:
                                crud.setTabela("Carrinho");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                continue;
                        }

                        crud.select();
                        break;

                    case 5:
                        System.out.println("Saindo do sistema...");
                        ligado = false;
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                ler.nextLine(); // Limpar o buffer
            }
        }

        ler.close();
    }
}
