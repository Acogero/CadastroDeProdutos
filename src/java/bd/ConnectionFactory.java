/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marcos Vinicius A. Moreira
 * 1º Semestre de 2017
 */
public class ConnectionFactory {
    
    //Conexão com o banco de dados
        private static final String urlBD = "jdbc:mysql://localhost:3306/"; // link de conexão com o banco
        private static final String BD = "crudProdutos"; //nome do schema
        private static final String userBD = "root"; //nome de usuário
        private static final String passBD = "root"; //senha do usuário
        private static final String driver = "com.mysql.jdbc.Driver"; // Driver do mysql
    //----------------------------
        
    //Caso o banco já esteja criado
        public static Connection getConnection() throws ClassNotFoundException{
            Connection connection = null;
            try{
                Class.forName(driver);
                if(connection == null || (connection != null && connection.isClosed())){
                    connection = (Connection) DriverManager.getConnection(urlBD + BD, userBD, passBD);
                }
            } catch(SQLException sqlx){
                throw new RuntimeException(sqlx);
            }
            return connection;
        }
    //-----------------------------
        
    //Caso o banco ainda não esteja criado
        public static Connection getConexao(){
            Connection connection = null;
            try{
                Class.forName(driver);
                if(connection == null || (connection != null && connection.isClosed())){
                    connection = (Connection) DriverManager.getConnection(urlBD, userBD, passBD);
                }
            }catch(Exception e){
                throw new RuntimeException(e);
            }
            return connection;
        }
    //-------------------------------------
}
