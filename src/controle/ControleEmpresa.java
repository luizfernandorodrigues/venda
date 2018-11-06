/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloEmpresa;

/**
 *
 * @author luizf
 */
public class ControleEmpresa {

    ModeloEmpresa mod = new ModeloEmpresa();
    ConectaBanco ConnEmpresa = new ConectaBanco();
    int codCidade, codEstado;

    public void Salvar(ModeloEmpresa mod) {
        AchaEstado(mod.getEstadoEmpresa());
        AchaCidade(mod.getCidadeEmpresa());
        ConnEmpresa.conexao();
        try {
            PreparedStatement pst = ConnEmpresa.conn.prepareStatement("insert into empresa (nome_empresa, cnpj_empresa, endereco_empresa, "
                    + "telefone_empresa, bairro_empresa, id_cidade, id_estado, email_empresa, inscricao_empresa) values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getNomeEmpresa());
            pst.setString(2, mod.getCnpjEmpresa());
            pst.setString(3, mod.getEnderecoEmpresa());
            pst.setString(4, mod.getTelefoneEmpresa());
            pst.setString(5, mod.getBairroEmpresa());
            pst.setInt(6, codCidade);
            pst.setInt(7, codEstado);
            pst.setString(8, mod.getEmailEmpresa());
            pst.setString(9, mod.getInscricaoEmpresa());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AchaCidade(String cidade) {
        ConnEmpresa.conexao();

        try {
            ConnEmpresa.executaSQL("select * from cidade where nome_cidade='" + cidade + "'");
            ConnEmpresa.rs.first();
            codCidade = ConnEmpresa.rs.getInt("id_cidade");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possivel Buscar o Codigo da Cidade! \n" + ex);
        }
        ConnEmpresa.desconecta();
    }

    public void AchaEstado(String estado) {
        ConnEmpresa.conexao();

        try {
            ConnEmpresa.executaSQL("Select * from estado where sigla_estado ='" + estado + "'");
            ConnEmpresa.rs.first();
            codEstado = ConnEmpresa.rs.getInt("id_estado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi Possivel Buscar o Código do Estado !!\n ERRO:   " + ex);
        }
    }

}
