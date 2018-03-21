package reporte;

import java.util.ArrayList;

public class Reporte {
    
    private String titulo;
    private String fecha;
    private int cantidad;
    private ArrayList contenido;

    public String getTitulo() {
        return titulo;
    }

    public ArrayList getContenido() {
        return contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }    

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(ArrayList contenido) {
        this.contenido = contenido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }    
}
