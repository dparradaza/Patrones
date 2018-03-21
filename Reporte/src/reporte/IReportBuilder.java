package reporte;

import java.util.ArrayList;

public abstract class IReportBuilder {
	
	protected Reporte report;
	protected String ruta;
	protected ArrayList contenido;

	public abstract void cargarReporte();
	public abstract void estructurarReporte();

	public Reporte getReport() {
		return report;
	}
}
