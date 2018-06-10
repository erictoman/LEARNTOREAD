/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuento;

/**
 *
 * @author ertim
 */
public class Pagina {
    private String NumPagina;
    private String Contenido;
    public Pagina(String NumPagina, String Contenido){
        this.NumPagina=NumPagina;
        this.Contenido=Contenido;
    }

    public String getNumPagina() {
        return NumPagina;
    }

    public void setNumPagina(String NumPagina) {
        this.NumPagina = NumPagina;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String Contenido) {
        this.Contenido = Contenido;
    }
    
    
}
