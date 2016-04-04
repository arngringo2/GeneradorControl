/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorcontrol.modelo;

import java.util.Date;

/**
 *
 * @author JUAN
 */
public class Control {
    
    Date fechaDeClase;
    int tiempo;

    public Control(Date fechaDeClase, int tiempo) {
        this.fechaDeClase = fechaDeClase;
        this.tiempo = tiempo;
    }

    public Date getFechaDeClase() {
        return fechaDeClase;
    }

    public void setFechaDeClase(Date fechaDeClase) {
        this.fechaDeClase = fechaDeClase;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    
   
    
}
