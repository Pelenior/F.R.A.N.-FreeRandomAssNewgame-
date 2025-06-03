package model;

public class Objeto {
	private String nombre="";
	private boolean isArmadura=false;

	public Objeto(String nombre) {
		this.nombre=nombre;
	}
	
	public Objeto(String nombre, boolean isArmadura) {
		this.nombre=nombre;
		this.isArmadura=isArmadura;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean getArmadura() {
		return isArmadura;
	}

	public void setArmadura(boolean isArmadura) {
		this.isArmadura = isArmadura;
	}


}
