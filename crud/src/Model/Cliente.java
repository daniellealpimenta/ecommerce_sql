package Model;

import java.util.Date;

/**
 * Classe criada para chamada de função referente às informações da tabela Cliente.
 *
 * @author caioQueiroz
 */
public class Cliente {
    //Atributos necessários para nossa classe cliente
    private int Cliente_ID;
    private String Nome;
    private String Email;
    private String Telefone;
    private Date Data_Cadastro;

    /**
     * Função get, para acessar o ID do cliente.
     *
     * @return retorna o id do cliente
     */
    public int getCliente_ID() {
        return Cliente_ID;
    }

    /**
     * Função set, para atribuir o ID do cliente.
     *
     * @param cliente_ID é o valor que vai ser atribuido na variável.
     */
    public void setCliente_ID(int cliente_ID) {
        Cliente_ID = cliente_ID;
    }

    /**
     * Função get, para acessar o nome do cliente.
     *
     * @return retorna o nome do cliente
     */
    public String getNome() {
        return Nome;
    }
    /**
     * Função set, para atribuir o nome do cliente.
     *
     * @param nome é o valor que vai ser atribuido na variável.
     */
    public void setNome(String nome) {
        Nome = nome;
    }
    /**
     * Função get, para acessar o email do cliente.
     *
     * @return retorna o email do cliente
     */
    public String getEmail() {
        return Email;
    }
    /**
     * Função set, para atribuir o email do cliente.
     *
     * @param email é o valor que vai ser atribuido na variável.
     */
    public void setEmail(String email) {
        Email = email;
    }
    /**
     * Função get, para acessar o telefone do cliente.
     *
     * @return retorna o telefone do cliente
     */
    public String getTelefone() {
        return Telefone;
    }
    /**
     * Função set, para atribuir o valor de telefone do cliente.
     *
     * @param telefone é o valor que vai ser atribuido na variável.
     */
    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
    /**
     * Função get, para acessar a data_cadastro do cliente.
     *
     * @return retorna a data_cadastro do cliente
     */
    public Date getData_Cadastro() {
        return Data_Cadastro;
    }
    /**
     * Função set, para atribuir o valor da data de cadastro do cliente.
     *
     * @param data_Cadastro é o valor que vai ser atribuido na variável.
     */
    public void setData_Cadastro(Date data_Cadastro) {
        Data_Cadastro = data_Cadastro;
    }
}
