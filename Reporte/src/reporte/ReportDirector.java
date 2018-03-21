package reporte;

public class ReportDirector {

    private IReportBuilder myBuilder;

    public ReportDirector(IReportBuilder builder) {
        myBuilder = builder;
    }   
 
    public void buildReport() {
        myBuilder.cargarReporte();
        myBuilder.estructurarReporte();
        
    }

    public Reporte getReport() {
        return this.myBuilder.getReport();
    }
}
