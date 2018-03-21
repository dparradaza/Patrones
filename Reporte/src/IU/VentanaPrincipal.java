package IU;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import reporte.IReportBuilder;
import reporte.Reporte;
import reporte.ReportBuilderEstudiante;
import reporte.ReportBuilderMateria;
import reporte.ReportDirector;

public class VentanaPrincipal extends JFrame {

	public static final String GENERAR_REPORTE = "Generar Reporte";
	public static final String SALIR = "Salir";
	public static final String ESTUDIANTES = "Estudiantes";
	public static final String ASIGNATURAS = "Asignaturas";

	private JComboBox cmbTipoReporte;
	private JPanel pSearchCriteria;
	private JTable tablaReporte;
	private JTextArea taEncabezado;

	public VentanaPrincipal() throws Exception {
		super("Iterator Pattern - Example");

		// Create controls
		cmbTipoReporte = new JComboBox();

		tablaReporte = new JTable();
		taEncabezado = new JTextArea();

		// taSelectedCandidates.setMargin(new Insets(1,1,1,1));
		pSearchCriteria = new JPanel();

		cmbTipoReporte.addItem(VentanaPrincipal.ESTUDIANTES);
		cmbTipoReporte.addItem(VentanaPrincipal.ASIGNATURAS);

		// Create Labels
		JLabel lblCertificationType = new JLabel("Tipo de reporte:");
		JLabel lblSelectedCandidates = new JLabel("Reporte:");

		// Create the generarReporte button
		JButton btnGetGenerarReporte = new JButton(VentanaPrincipal.GENERAR_REPORTE);
		// btnGetSelectedCandidates.setMnemonic(VentanaPrincipal.VK_R);
		JButton btnSalir = new JButton(VentanaPrincipal.SALIR);
		btnSalir.setMnemonic(KeyEvent.VK_X);

		buttonHandler vf = new buttonHandler(this);

		btnGetGenerarReporte.addActionListener(vf);
		btnSalir.addActionListener(vf);

		// For layout purposes, put the buttons in a separate panel
		JPanel buttonPanel = new JPanel();
		JPanel panel = new JPanel();
		
		tablaReporte.setEnabled(false);
		taEncabezado.setEditable(false);
		
		GridBagLayout gridbag2 = new GridBagLayout();
		panel.setLayout(gridbag2);
		panel.add(btnGetGenerarReporte);
		panel.add(btnSalir);

		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		gridbag2.setConstraints(btnGetGenerarReporte, gbc2);
		gbc2.gridx = 4;
		gbc2.gridy = 0;
		gridbag2.setConstraints(btnSalir, gbc2);

		// ****************************************************
		GridBagLayout gridbag = new GridBagLayout();
		buttonPanel.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();

		buttonPanel.add(lblCertificationType);
		buttonPanel.add(cmbTipoReporte);
		buttonPanel.add(lblSelectedCandidates);
		buttonPanel.add(taEncabezado);
		buttonPanel.add(tablaReporte);
		buttonPanel.add(panel);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.right = 5;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(lblCertificationType, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gridbag.setConstraints(cmbTipoReporte, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gridbag.setConstraints(lblSelectedCandidates, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gridbag.setConstraints(tablaReporte, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gridbag.setConstraints(taEncabezado, gbc);

		gbc.insets.left = 3;
		gbc.insets.right = 2;
		gbc.insets.top = 40;
		gbc.gridx = 1;
		gbc.gridy = 6;
		gridbag.setConstraints(panel, gbc);

		// ****************************************************
		// Add the buttons and the log to the frame
		Container contentPane = getContentPane();
		contentPane.add(buttonPanel, BorderLayout.CENTER);
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
			SwingUtilities.updateComponentTreeUI(VentanaPrincipal.this);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public String getTipoReporte() {
		return (String) cmbTipoReporte.getSelectedItem();
	}

	public void setSelectedReporte(DefaultTableModel dataModel) {
		tablaReporte.setModel(dataModel);
	}

	public void setEncabezado(String encabezado) {
		taEncabezado.setText(encabezado);
	}

}

class buttonHandler implements ActionListener {

	VentanaPrincipal manager;

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(VentanaPrincipal.SALIR)) {
			System.exit(0);
		}
		if (e.getActionCommand().equals(VentanaPrincipal.GENERAR_REPORTE)) {
			String selection = manager.getTipoReporte();

			if (selection.equals("Estudiantes")) {
				IReportBuilder builder = new ReportBuilderEstudiante("src/archivos/estudiantes.properties");
				ReportDirector reportDirector = new ReportDirector(builder);
				reportDirector.buildReport();
				Reporte report = reportDirector.getReport();
				manager.setSelectedReporte(report.getModelo());
				manager.setEncabezado(report.getTitulo() + ".   Fecha: " + report.getFecha());

			} else {
				IReportBuilder builder1 = new ReportBuilderMateria("src/archivos/materias.properties");
				ReportDirector reportDirector1 = new ReportDirector(builder1);
				reportDirector1.buildReport();
				Reporte report1 = reportDirector1.getReport();
				manager.setSelectedReporte(report1.getModelo());
				manager.setEncabezado(report1.getTitulo() + ".   Fecha: " + report1.getFecha());
			}
		}
	}

	public buttonHandler() {
	}

	public buttonHandler(VentanaPrincipal inmanager) {
		manager = inmanager;
	}

}
