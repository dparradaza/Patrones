package reporte;

public class Materia {
    private String nombre;
    private int creditos;
    private String tipo;

    public Materia() {
        this.nombre = null;
        this.creditos = 0;
        this.tipo = null;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
