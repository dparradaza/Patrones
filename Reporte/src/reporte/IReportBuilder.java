package reporte;

public interface IReportBuilder {
	  public void buildPreface();
	  public void buildReportTitle();
	  public void buildHeader();
	  public void buildContent();
	  public void buildFooter();
	  public Report getReport();
}


