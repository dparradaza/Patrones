package reporte;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class ReportBuilderMateria extends IReportBuilder {

	public ReportBuilderMateria(String ruta) {
		this.ruta = ruta;
		report = new Reporte();
		contenido =new ArrayList<Materia>();
	}

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
				contenido.add(materia);
			}

		} catch (Exception e) {

		}

	}

	public void estructurarReporte() {
		DefaultTableModel dtm = new DefaultTableModel();
		String[] data = new String[3];
		String[] columnas = { "Nombre", "Creditos", "Tipo" };
		dtm.setColumnIdentifiers(columnas);
                dtm.addRow(columnas);
		for (int i = 0; i < contenido.size(); i++) {
			Materia materia = (Materia) contenido.get(i);
			data[0] = materia.getNombre();
			data[1] = "" + materia.getCreditos();
			data[2] = materia.getTipo();
			dtm.addRow(data);
		}
		report.setModelo(dtm);
	}

}
