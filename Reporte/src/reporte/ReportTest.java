package reporte;

import IU.VentanaPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/*App client*/
public class ReportTest {

    public static void main(String[] args) throws Exception {

        VentanaPrincipal v = new VentanaPrincipal();
        v.setVisible(true);
        JFrame frame = new VentanaPrincipal();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );

        //frame.pack();
        frame.setSize(600, 500);
        frame.setVisible(true);

        IReportBuilder builder = new ReportBuilderSE();
        ReportDirector reportDirector = new ReportDirector(builder);
        reportDirector.buildReport();
        Report report = reportDirector.getReport();
        //use report object as per business
        System.out.println(report.getReportTitle());
        System.out.println(report.getHeader());
        System.out.println(report.getPreface());
        System.out.println(report.getContent());
        System.out.println(report.getFooter());
        IReportBuilder builder1 = new ReportBuilderTEL();
        ReportDirector reportDirector1 = new ReportDirector(builder1);
        reportDirector1.buildReport();
        Report report1 = reportDirector1.getReport();
        //use report object as per business
        System.out.println(report1.getReportTitle());
        System.out.println(report1.getHeader());
        System.out.println(report1.getPreface());
        System.out.println(report1.getContent());
        System.out.println(report1.getFooter());
    }
}
