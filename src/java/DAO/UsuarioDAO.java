/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bd.ConnectionFactory;
import static bd.ConnectionFactory.getConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author Marcos Vinicius A. Moreira
 * 1º Semestre de 2017
 */
public class UsuarioDAO extends Usuario implements IUsuario{

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    private String sql;
    Usuario u = new Usuario();
    
    @Override
    public boolean create(Usuario u) {
        try{
            sql = "INSERT INT usuario (nome, email, senha) VALUES (?, ?, ?);";
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            
            ps.execute();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            try{
                getConnection().close();
            }catch(SQLException sq){
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Usuario read(String nome, String email) {
        try{
            sql = "SELECT nome, email FROM usuario WHERE nome = ? AND email = ?;";
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setString(1, nome);
            ps.setString(2, email);
            
            rs = ps.executeQuery();
            if(rs.next()){
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
            }
            return u;
        }catch(Exception e){
            return null;
        }finally{
        try{
            getConnection().close();
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }

    @Override
    public void update(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
