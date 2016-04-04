/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author JUAN
 */
public class Materia {
    
    
    String codmateria;
    String jornada;
    String grupo;
    ArrayList<HorarioClase> fechasDeClase;
    ArrayList<Control> controles;

    public Materia(String codmateria, String jornada, String grupo, ArrayList<HorarioClase> fechasDeClase, ArrayList<Control> controles) {
        this.codmateria = codmateria;
        this.jornada = jornada;
        this.grupo = grupo;
        this.fechasDeClase = fechasDeClase;
        this.controles = controles;
    }

    public String getCodmateria() {
        return codmateria;
    }

    public void setCodmateria(String codmateria) {
        this.codmateria = codmateria;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public ArrayList<HorarioClase> getFechasDeClase() {
        return fechasDeClase;
    }

    public void setFechasDeClase(ArrayList<HorarioClase> fechasDeClase) {
        this.fechasDeClase = fechasDeClase;
    }

    public ArrayList<Control> getControles() {
        return controles;
    }

    public void setControles(ArrayList<Control> controles) {
        this.controles = controles;
    }

  
    
    
    
    
    
    
    
}
