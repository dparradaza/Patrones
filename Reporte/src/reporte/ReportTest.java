package reporte;

import IU.VentanaPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/*App client*/
public class ReportTest {

    public static void main(String[] args) throws Exception {

        VentanaPrincipal v = new VentanaPrincipal();
        JFrame frame = new VentanaPrincipal();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        frame.setSize(600, 500);
        frame.setVisible(true);

       
    }
}
