/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IU;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author diego
 */
public class VentanaPrincipal extends JFrame {
public static final String nuevaLinea = "\n";
  public static final String GENERAR_REPORTE = "Generar Reporte";
  public static final String SALIR = "Salir";
  public static final String ESTUDIANTES = "Estudiantes";
  public static final String ASIGNATURAS = "Asignaturas";
  

  private JComboBox cmbTipoReporte;
  private JPanel pSearchCriteria;
  private JTextArea taReporte;

  public VentanaPrincipal() throws Exception {
    super("Iterator Pattern - Example");

    // Create controls
    cmbTipoReporte = new JComboBox();
    taReporte = new JTextArea(15, 20);
    //taSelectedCandidates.setMargin(new Insets(1,1,1,1));
    taReporte.setEditable(false);

    pSearchCriteria = new JPanel();

    cmbTipoReporte.addItem(VentanaPrincipal.ESTUDIANTES);
    cmbTipoReporte.addItem(VentanaPrincipal.ASIGNATURAS);
   

    //Create Labels
    JLabel lblCertificationType =
      new JLabel("Tipo de reporte:");
    JLabel lblSelectedCandidates = new JLabel("Reporte:");

    //Create the open button
    JButton btnGetSelectedCandidates =
      new JButton(VentanaPrincipal.GENERAR_REPORTE);
   // btnGetSelectedCandidates.setMnemonic(VentanaPrincipal.VK_R);
    JButton btnExit = new JButton(VentanaPrincipal.SALIR);
    btnExit.setMnemonic(KeyEvent.VK_X);

    buttonHandler vf = new buttonHandler(this);

    btnGetSelectedCandidates.addActionListener(vf);
    btnExit.addActionListener(vf);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    JPanel panel = new JPanel();

    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    panel.add(btnGetSelectedCandidates);
    panel.add(btnExit);

    GridBagConstraints gbc2 = new GridBagConstraints();
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(btnGetSelectedCandidates, gbc2);
    gbc2.gridx = 3;
    gbc2.gridy = 0;
    gridbag2.setConstraints(btnExit, gbc2);

    //****************************************************

    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblCertificationType);
    buttonPanel.add(cmbTipoReporte);
    buttonPanel.add(lblSelectedCandidates);
    buttonPanel.add(taReporte);
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
    gbc.gridy = 1;
    gridbag.setConstraints(taReporte, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;
    gbc.gridx = 1;
    gbc.gridy = 6;
    gridbag.setConstraints(panel, gbc);


    //****************************************************
    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();
    contentPane.add(buttonPanel, BorderLayout.CENTER);
    try {
      UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
        VentanaPrincipal.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }


  public String getCertificationType() {
    return (String) cmbTipoReporte.getSelectedItem();
  }
  public void setSelectedCandidates(String selectedCandidates) {
    taReporte.setText(selectedCandidates);
  }

}
class buttonHandler implements ActionListener {
  VentanaPrincipal manager;
  public void actionPerformed(ActionEvent e) {

    if (e.getActionCommand().equals(VentanaPrincipal.SALIR)) {
      System.exit(1);
    }
    if (e.getActionCommand().equals(VentanaPrincipal.GENERAR_REPORTE)) {
      String selection = manager.getCertificationType();
      //AllCandidates ac = new VentanaPrincipal();
      /*
      Iterator certCandidates =
        ac.getCertifiedCandidates(selection);
      String selectedCandidates =
        "Name --- Cert Type --- Location" + "\n" + 
          "--------------------------------------";

      while (certCandidates.hasNext()) {
        Candidate c = (Candidate) certCandidates.next();
        selectedCandidates = selectedCandidates + "\n" +
            c.getName() + " - " + c.getCertificationType() + 
              " - " + c.getLocation();
      }
      manager.setSelectedCandidates(selectedCandidates);*/
    }
  }
  public buttonHandler() {
  }
  public buttonHandler(VentanaPrincipal inmanager) {
    manager = inmanager;
  }

}

    
  