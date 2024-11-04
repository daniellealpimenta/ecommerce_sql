package Model;

import java.util.Date;

public class Cliente {
    //Atributos necessários para nossa classe cliente
    private int Cliente_ID;
    private String Nome;
    private String Email;
    private String Telefone;
    private Date Data_Cadastro;

    //getters and setters
    public int getCliente_ID() {
        return Cliente_ID;
    }

    public void setCliente_ID(int cliente_ID) {
        Cliente_ID = cliente_ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public Date getData_Cadastro() {
        return Data_Cadastro;
    }

    public void setData_Cadastro(Date data_Cadastro) {
        Data_Cadastro = data_Cadastro;
    }
}
