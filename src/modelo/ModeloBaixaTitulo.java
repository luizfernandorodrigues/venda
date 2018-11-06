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
public class ModeloBaixaTitulo {

    private int CodParcela;
    private String dataVencimento;
    private int codVenda;
    private float valorVenda;

    public int getCodParcela() {
        return CodParcela;
    }

    public void setCodParcela(int CodParcela) {
        this.CodParcela = CodParcela;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

}
