/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jmtis
 */
public class ModeloBairro {

    private int id_bairro;
    private String nome;
    private int id_cidade;

    public int getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(int id_bairro) {
        this.id_bairro = id_bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int nome_cidade) {
        this.id_cidade = nome_cidade;
    }

}
