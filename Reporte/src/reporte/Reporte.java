package reporte;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class Reporte {

	private String titulo;
	private String fecha;
	private int cantidad;
	private ArrayList contenido;
	private DefaultTableModel modelo;

	public String getTitulo() {
		return titulo;
	}

	public ArrayList getContenido() {
		return contenido;
	}

	public String getFecha() {
		return fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setContenido(ArrayList contenido) {
		this.contenido = contenido;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}
}
