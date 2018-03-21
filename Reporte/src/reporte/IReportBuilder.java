package reporte;

import javax.swing.table.DefaultTableModel;

public interface IReportBuilder {

	public void cargarReporte();

	public void estructurarReporte();

	public Reporte getReport();
}
