/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Produto;

/**
 *
 * @author Marcos Vinicius A. Moreira
 * 1º Semestre de 2017
 */
public interface IProduto {
    public void create(Produto p);
    
    public Produto read(Produto p);
    
    public boolean existe(Produto p);
    
    public void update(Produto p);
    
    public void delete(Produto p);
}
