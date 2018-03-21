package reporte;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class ReportBuilderEstudiante extends IReportBuilder {
	
	public ReportBuilderEstudiante(String ruta) {
		this.ruta = ruta;
		report = new Reporte();
		contenido = new ArrayList<Estudiante>();
	}

	public void cargarReporte() {
		try {
			Properties input = new Properties();
			input.load(new FileInputStream(ruta));

			report.setTitulo(input.getProperty("titulo"));
			report.setFecha(input.getProperty("fecha"));
			report.setCantidad(Integer.parseInt(input.getProperty("cantidad")));

			for (int i = 1; i <= report.getCantidad(); i++) {
				Estudiante estudiante = new Estudiante();
				estudiante.setNombre(input.getProperty("nombre" + i));
				estudiante.setCodigo(input.getProperty("codigo" + i));
				estudiante.setProyecto(input.getProperty("proyecto" + i));
				contenido.add(estudiante);
			}

		} catch (Exception e) {
			System.err.println("Error - No cargo correctamente el archivo de reporte estudiantes");
		}
	}

	public void estructurarReporte() {
		DefaultTableModel dtm = new DefaultTableModel();
		String[] data = new String[3];
		String[] columnas = { "Nombre", "Codigo", "Proyecto" };
		dtm.setColumnIdentifiers(columnas);
		for (int i = 0; i < contenido.size(); i++) {
			Estudiante estudiante = (Estudiante) contenido.get(i);
			data[0] = estudiante.getNombre();
			data[1] = estudiante.getCodigo();
			data[2] = estudiante.getProyecto();
			dtm.addRow(data);
		}
		report.setModelo(dtm);
	}

}
