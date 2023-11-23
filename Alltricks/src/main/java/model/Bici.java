package model;

import java.io.Serializable;

public class Bici implements Serializable {
	private int id;
	private String foto;
	private int marca;
	private String nombremarca;
	private String descripcion;
	private float precio;
	private int fav;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getFav() {
		return fav;
	}

	public void setFav(int fav) {
		this.fav = fav;
	}

	@Override
	public String toString() {
		return "Bici [id=" + id + ", foto=" + foto + ", marca=" + marca + ", descripcion=" + descripcion + ", precio="
				+ precio + ", fav=" + fav + "]";
	}

	public String getNombremarca() {
		return nombremarca;
	}

	public void setNombremarca(String nombremarca) {
		this.nombremarca = nombremarca;
	}
}
