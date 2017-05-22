/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;

/**
 *
 * @author Marcos Vinicius A. Moreira
 * 1º Semestre de 2017
 */
public class DBUtils {
    
    //MÉTODO PARA CRIAR A BASE DE DADOS
        public static void createSchema(){
            Connection con = null;
            Statement stmt = null;
            try{
                con = ConnectionFactory.getConexao();
                con.setAutoCommit(false);
                stmt = (Statement) con.createStatement();
                stmt.execute("CREATE DATABASE IF NOT EXISTS crudProdutos;");
                
                con.commit();
            }catch(Exception e){
                e.printStackTrace();
                try{
                    con.rollback();
                }catch(SQLException sqlex){
                }
            }finally{
                try{
                    con.close();
                }catch(SQLException ex){
                }
            }
        }
    //---------------------------------
        
    //método para criar as tabelas de Usuário e produto
        public static void createTable() throws ClassNotFoundException{
            Connection con = null;
            Statement stmt = null;
            
            try{
                con = ConnectionFactory.getConnection();
                con.setAutoCommit(false);
                stmt = (Statement) con.createStatement();
                stmt.execute("CREATE TABLE IF NOT EXISTS usuario("
                        + "idUsuario int AUTO_INCREMENT, nome VARCHAR(70) NOT NULL, "
                        + "email VARCHAR(150), senha VARCHAR(25) NOT NULL, PRIMARY KEY (idUsuario));");
                
                stmt.execute("CREATE TABLE IF NOT EXISTS produto("
                        + "idProduto int AUTO_INCREMENT, nome VARCHAR(150) NOT NULL, "
                        + "preco FLOAT NOT NULL, quantidade INT NOT NULL, PRIMARY KEY (idProduto));");
                
                con.commit();
            }catch (Exception e){
                e.printStackTrace();
                try{
                    con.rollback();
                }catch(SQLException ex){
                }
            } finally {
                try{
                    con.close();
                }catch(SQLException sqlex){
                }
            }
        }
    //-------------------------------------------------
        
    //EXCLUIR TABELA
        public static void dropTable(){
            Connection con = null;
            Statement stmt = null;
            try{
                con = ConnectionFactory.getConnection();
                con.setAutoCommit(false);
                stmt = (Statement) con.createStatement();
                stmt.execute("DROP TABLE crudProdutos");
                
                con.commit();
            }catch(Exception e){
                e.printStackTrace();
                try{
                    con.rollback();
                }catch(SQLException ex){
                }
            }finally{
                try{
                    con.close();
                }catch(SQLException es){
                }
            }
        }
    //--------------------------------------------------
}
