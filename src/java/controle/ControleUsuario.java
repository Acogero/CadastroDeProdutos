/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.UsuarioDAO;
import bd.DBUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Marcos Vinicius A. Moreira
 * 1º Semestre de 2017
 */
public class ControleUsuario extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
        Usuario user = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        String acao = request.getParameter("acao");
        
        if(acao.equals("Logar")){
            if(request.getParameter("usuario") != null && request.getParameter("senha") != null){
                user.setNome(request.getParameter("usuario"));
                user.setSenha(request.getParameter("senha"));
                
                try{
                    if(dao.existe(user)){
                        //SESSÃO
                            HttpSession session = request.getSession();
                            session.setAttribute("nome", request.getParameter("nome"));
                        //----------
                        
                        response.sendRedirect("index.jsp");
                    }else{
                        /*
                            ENVIAR UMA MENSAGEM DE ERRO VIA JAVASCRIPT
                        */
                        response.sendRedirect("login.jsp");
                    }
                }catch(Exception e){
                    response.sendRedirect("login.jsp");
                }
            }
        }
        
        if(acao.equals("Cadastrar")){
            DBUtils.createSchema();
            DBUtils.createTable();
            
            if(request.getParameter("nome") != null && request.getParameter("email") != null && request.getParameter("senha") != null){
                user.setNome(request.getParameter("nome"));
                user.setEmail(request.getParameter("email"));
                user.setSenha(request.getParameter("senha"));
                
                try{
                    if(!dao.existe(user)){
                        if(dao.create(user)){
                            response.sendRedirect("login.jsp");
                        }
                    }
                }catch(Exception e){
                    response.sendRedirect("cadastrarUsuario.jsp");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
