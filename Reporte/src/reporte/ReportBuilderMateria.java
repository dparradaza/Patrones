package reporte;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ReportBuilderMateria implements IReportBuilder {

    private Reporte report;
    private String ruta;

    public ReportBuilderMateria(String ruta) {
        this.ruta = ruta;
        report = new Reporte();
        report.setContenido(new ArrayList<Materia>());
    }

    @Override
    public void cargarReporte() {
        try {
            Properties input = new Properties();
            input.load(new FileInputStream(ruta));

            report.setTitulo(input.getProperty("titulo"));
            report.setFecha(input.getProperty("fecha"));
            report.setCantidad(Integer.parseInt(input.getProperty("cantidad")));

            for (int i = 1; i <= report.getCantidad(); i++) {
                Materia materia = new Materia();
                materia.setNombre(input.getProperty("nombre" + i));
                materia.setCreditos(Integer.parseInt(input.getProperty("creditos" + i)));
                materia.setTipo(input.getProperty("tipo" + i));
                report.getContenido().add(materia);
            }

        } catch (Exception e) {
        }

    }

    @Override
    public String estructurarReporte() {
        return null;
    }

    @Override
    public Reporte getReport() {
        return report;
    }

}
