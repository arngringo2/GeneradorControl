/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generator.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import generatorcontrol.modelo.Control;
import generatorcontrol.modelo.Materia;

/**
 *
 * @author JUAN
 */
public class ControlBO {
    
    public Materia obtenerControles(Materia mat){
    
        if(mat.getFechasDeClase().size() == 1){
        
            mat = obtenerControlesUnaVezporSemana(mat);
        
        }else{
        
            mat = obtenerControlesDosvecesporSemana(mat);
            
        }
        
        return mat;
    }

    public Materia obtenerControlesUnaVezporSemana(Materia miMateria) {
        
        String codMateria   = miMateria.getCodmateria();
        String jornada      = miMateria.getJornada();
        String grupo        = miMateria.getGrupo();
        //int tiempo          = miCurso.getTiempo();
        
        ArrayList<Control> controles = new ArrayList();
        Date fechaInicial;
        int i = 0;
        Date primerClase = ObtenerPrimerClase();
        
        while (i < 16) {
            //calculando la sigueinte clase
            //saco el calendar
            Calendar fechaSiguiente = Calendar.getInstance();
            fechaSiguiente.setTime(primerClase);
            fechaSiguiente.add(Calendar.DATE, 7);

            //vuelvo a date

            //generar la siguiente clase dependiendo de la inicial
            Date fechaClase;
            Control miControl = new Control(fechaSiguiente.getTime(), 0);
            controles.add(miControl);
            i++;
            //primerclase debe ser la semilla para la siguiente
            primerClase = fechaSiguiente.getTime();
        }
        miMateria.setControles(controles);
        return miMateria;

    }

    public Materia obtenerControlesDosvecesporSemana(Materia mat) {
        ArrayList<Control> fechasControles = new ArrayList<Control>();

        ArrayList<Date> fechas = obtenerClasesdelCurso();
        int i = 0;
        int par = 0;
        int impar = 1;

        Date fechaInicial   = mat.getFechasDeClase().get(0).getFechaClase();
        Date fechaFinal     = mat.getFechasDeClase().get(1).getFechaClase();

        fechasControles.add(new Control(fechaInicial, mat.getFechasDeClase().get(0).getTiempo()));
        fechasControles.add(new Control(fechaFinal, mat.getFechasDeClase().get(1).getTiempo()));


        while (i <= 16) {

            //generar los cajones par
            Calendar fechaPar = Calendar.getInstance();
            fechaPar.setTime(fechaInicial);
            fechaPar.add(Calendar.DATE, 7);

            //tiempo de la primer clase
            int tiempoclase1 = mat.getFechasDeClase().get(0).getTiempo();
            fechasControles.add(new Control(fechaPar.getTime(), tiempoclase1 ));
            fechaInicial = fechaPar.getTime();

            //generar los cajones par
            Calendar fechaImpar = Calendar.getInstance();
            fechaImpar.setTime(fechaFinal);
            fechaImpar.add(Calendar.DATE, 7);

             int tiempoclase2 = mat.getFechasDeClase().get(1).getTiempo();
            fechasControles.add(new Control(fechaImpar.getTime(), tiempoclase2 ));
            fechaFinal = fechaImpar.getTime();


            i++;
            par += 2;
            impar += 2;

        }
        mat.setControles(fechasControles);
        return mat;
    }

    private Date ObtenerPrimerClase() {
        Calendar fechaInicio = null;
        try {
            //crear la clase  2 de febrero del 2016
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = "2016-02-02";
            fechaInicio = Calendar.getInstance();
            fechaInicio.setTime(sdf.parse(fecha));

        } catch (ParseException ex) {
            Logger.getLogger(ControlBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fechaInicio.getTime();
    }

    private ArrayList<Date> obtenerClasesdelCurso() {
        ArrayList<Date> fechas = new ArrayList<Date>();
        Calendar primerClase = null;
        Calendar segundaClase = null;

        try {
            //crear la clase  2 de febrero del 2016
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = "2016-02-01";
            primerClase = Calendar.getInstance();
            primerClase.setTime(sdf.parse(fecha));

            fechas.add(primerClase.getTime());

            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha2 = "2016-02-04";
            segundaClase = Calendar.getInstance();
            segundaClase.setTime(sdf2.parse(fecha2));

            fechas.add(segundaClase.getTime());

        } catch (ParseException ex) {
            Logger.getLogger(ControlBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechas;
    }
}
