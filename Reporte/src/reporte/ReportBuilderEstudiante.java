package reporte;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ReportBuilderEstudiante implements IReportBuilder {

    private Reporte report;    
    private String ruta;
    private String[] lis;

   
    
    
    public ReportBuilderEstudiante(String ruta) {
        this.ruta=ruta;
        report = new Reporte();
        report.setContenido(new ArrayList<Estudiante>());
    }

    @Override
    public Reporte getReport() {
        return report;
    }
    
    @Override
    public void cargarReporte() {
        try{
            Properties input = new Properties();
            input.load(new FileInputStream(ruta));
            
            report.setTitulo(input.getProperty("titulo"));
            report.setFecha(input.getProperty("fecha"));            
            report.setCantidad(Integer.parseInt(input.getProperty("cantidad")));
           
            for (int i = 1; i <= report.getCantidad(); i++) {     
                Estudiante estudiante= new Estudiante();
                estudiante.setNombre(input.getProperty("nombre"+i));
                estudiante.setCodigo(input.getProperty("codigo"+i));
                estudiante.setProyecto(input.getProperty("proyecto"+i));
                report.getContenido().add(estudiante);
            }
            
        }catch(Exception e){
        }
    }

    @Override
    public String estructurarReporte() {
        for (int i = 0; i < 10; i++) {
            
        }
        Estudiante estudiante = (Estudiante) report.getContenido().get(0);
        return "Nombre: " + estudiante.getNombre()+estudiante.getCodigo()+estudiante.getProyecto();
    }


}
