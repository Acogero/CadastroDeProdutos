/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Usuario;

/**
 *
 * @author Marcos Vinicius A. Moreira
 * 1º Semestre de 2017
 */
public interface IUsuario {
    public boolean create(Usuario u);
    
    public Usuario read(String nome, String email);
    
    public void update(Usuario u);
    
    public void delete (Usuario u);
}
