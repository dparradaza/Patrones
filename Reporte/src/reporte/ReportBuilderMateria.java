package reporte;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

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
	public void estructurarReporte() {
		DefaultTableModel dtm = new DefaultTableModel();
		String[] data = new String[3];
		String[] columnas = { "Nombre", "Creditos", "Tipo" };
		dtm.setColumnIdentifiers(columnas);
		for (int i = 0; i < report.getContenido().size(); i++) {
			Materia materia = (Materia) report.getContenido().get(i);
			data[0] = materia.getNombre();
			data[1] = "" + materia.getCreditos();
			data[2] = materia.getTipo();
			dtm.addRow(data);
		}
		report.setModelo(dtm);
	}

	@Override
	public Reporte getReport() {
		return report;
	}

}
