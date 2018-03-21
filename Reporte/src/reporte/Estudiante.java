package reporte;

public class Estudiante {
    
    private String nombre;
    private String codigo;
    private String proyecto;

    public Estudiante() {
        this.nombre = null;
        this.codigo = null;
        this.proyecto = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }    
}
