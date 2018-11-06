/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jmtis
 */
public class ConectaBanco {
    public Statement stm;// responsavel por preparar e realizar pesquisas no banco de dados
    public ResultSet rs;// responsavel por armazenar o resultado de uma pesquisa passada para o statement
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// responsavel por identificar o serviço do banco de dados
    private String caminho = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=SistemadeVenda";// responsavel por setar o local do banco de daods
    private String usuario = "sa";
    private String senha = "mygod&1000";
    public Connection conn;// reponsavel por realizar a conexão com o banco de dados
    
    public void conexao(){// metodo responsavel por realizar a conexao com o banco de dados
      
        try {
            System.setProperty("com.microsoft.sqlserver.jdbc.Drivers", driver);// seta a propriedade do driver dobanco de dados
            conn = DriverManager.getConnection(caminho, usuario, senha);// realiza a conexao com o banco de dados
            //JOptionPane.showMessageDialog(null,"Conectado com sucesso !");// mostra uma mesagem de conexao realizado com suceso
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Erro de conexão com o banco !\n Erro: " + ex.getMessage());// exibe uma mensagem caso a conexao nao foi realizada
        }
    }
    
    public void desconecta (){// metodo para fechar a conexao com o banco de dados
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null,"Desconectado com sucesso !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao desconectar o banco !\n Erro: " + ex.getMessage());
        }
    }
    // metodo usado para otimizar o sistema chamando ele e passando apenas a sql, par pesquisas e exclusoes 
    public void executaSQL (String sql){
        
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           // JOptionPane.showMessageDialog(null,"Erro ao executar SQL !\n Erro: " + ex.getMessage());
        }
        
    }
    
}
