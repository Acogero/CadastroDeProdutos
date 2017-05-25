/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static bd.ConnectionFactory.getConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import modelo.Produto;

/**
 *
 * @author Marcos Vinicius A. Moreira
 * 1º Semestre de 2017
 */
public class ProdutoDAO extends Produto implements IProduto{

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    private String sql;
    
    Produto p = new Produto();
    
    @Override
    public boolean create(Produto p) {
        try{
            sql = "INSERT INTO produto (nome, preco, quantidade) VALUES (?, ?, ?);";
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setString(1, p.getNome());
            ps.setFloat(2, p.getPreco());
            ps.setInt(3, p.getQuantidade());
            
            ps.execute();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            try{
                getConnection().close();
            }catch(SQLException e){
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Produto> read() throws ServletException{
        List<Produto> listaP = null;
        try{
            sql = "SELECT * FROM produto;";
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            listaP = new ArrayList<>();
            
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                
                listaP.add(produto);
            }
        }catch(Exception e){
            throw new ServletException(e.getMessage());
        }finally{
            try{
                getConnection().close();
            }catch(SQLException ex){                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaP;
    }

    @Override
    public boolean existe(Produto p) {
        try{
            sql = "SELECT * FROM produto WHERE nome = ? AND preco = ?;";
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setString(1, p.getNome());
            ps.setFloat(2, p.getPreco());
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQuantidade(rs.getInt("quantidade"));
                
                return true;
            }
        }catch(Exception e){
            return false;
        }finally{
            try{
                getConnection().close();
            }catch(Exception ex){
            }
        }
        return false;
    }

    @Override
    public void update(Produto p) {
        try{
            sql = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?;";
            con = getConnection();
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setString(1, p.getNome());
            ps.setFloat(2, p.getPreco());
            ps.setInt(3, p.getQuantidade());
            
            ps.executeUpdate();
            getConnection().commit();
        }catch(Exception e){
        }finally{
            try{
                getConnection().close();
            }catch(Exception ex){
                
            }
        }
    }

    @Override
    public void delete(Produto p) {
        try{
            sql = "DELETE FROM produto WHERE idProduto = ?;";
            con = getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setInt(1, p.getIdProduto());
            getConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                getConnection().close();
            }catch(Exception ex){
                
            }
        }
    }
    
}
