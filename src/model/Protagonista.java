package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import dao.DaoPersonajes;

public class Protagonista extends Personaje {
	
	private int suerte = 0;
	private boolean badOmen = false;
	private boolean haHuido = false;
	private ArrayList<Objeto> listaObjetos = new ArrayList<Objeto>();

	//constructor
	public Protagonista(String nombre, double vidaMax, double defensa, double fuerza, double velocidad, int idAscii, int suerte) throws SQLException {
		this.nombre = nombre;
		this.vidaMax = vidaMax;
		this.vida = vidaMax;
		this.defensa = defensa;
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		this.idAscii = idAscii;
		this.suerte = suerte;
		
		ataqueController.rellenarAtaques(this);
	}
	
	public Protagonista() {
		
	}

	public int getSuerte() {
		return suerte;
	}

	public void setSuerte(int suerte) {
		this.suerte = suerte;
	}

	public boolean getBadOmen() {
		return badOmen;
	}

	public void setBadOmen(boolean badOmen) {
		this.badOmen = badOmen;
	}
	
	public boolean getHaHuido()
	{
		return haHuido;
	}
	
	public void setHaHuido(boolean haHuido)
	{
		this.haHuido = haHuido;
	}

	public ArrayList<Objeto> getListaObjetos() {
		return listaObjetos;
	}

	
	public void insertProta(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii, Boolean karma) throws SQLException{
		DaoPersonajes daoPersonajes = new DaoPersonajes();
		daoPersonajes.insertProta( nombre,  vidaMax,  defensa,  fuerza,  velocidad,  idAscii,  karma);
	}
	
	public Protagonista getDataProta() throws SQLException{
		DaoPersonajes daoPersonajes = new DaoPersonajes();
		return daoPersonajes.getDataProta(this.nombre);
	}
	
	public void updateProta(String nombre, Double vidaMax, Double defensa, Double fuerza, Double velocidad, Integer idAscii, Boolean karma) throws SQLException{
		DaoPersonajes daoPersonajes = new DaoPersonajes();
		daoPersonajes.updateProta( nombre,  vidaMax,  defensa,  fuerza,  velocidad,  idAscii,  karma);
	}

	@Override
	public void atacar(Scanner sc, Personaje target)
	{
		ataqueController.seleccionarAtaqueProta(sc, this, target);
		
	}
	
	public int recorrerListaObjetos(String nombreObjeto) {
		int numeroTotalObjetos=0;
		
		for (int i=0; i<listaObjetos.size(); i++) {
			if(listaObjetos.get(i).getNombre().equals(nombreObjeto)) {
				numeroTotalObjetos++;
			}
		}
		
		return numeroTotalObjetos;
		
	}
	
	public String comprobarArmadura() {
	String armadura="";
	
	for (int i=0; i<listaObjetos.size(); i++) {
		if(listaObjetos.get(i).getArmadura()) {
			armadura=listaObjetos.get(i).getNombre();
		}
	}
		return armadura;
	}
	
	public void eliminarObjeto(String nombreObjetoEliminar) {
//		listaObjetos.removeIf(objeto -> objeto.getNombre().equals(nombreObjetoEliminar));
		for (int i=0; i<listaObjetos.size(); i++) {
			if(listaObjetos.get(i).getNombre().equals(nombreObjetoEliminar)) {
				listaObjetos.remove(i);
			}
		}
		
	}
	
	public void eliminarUnObjeto(String nombreObjeto)
	{
		boolean objetoEliminado = false;
		for (int i=0; i<listaObjetos.size(); i++) {
			if(!objetoEliminado)
			{
				if(listaObjetos.get(i).getNombre().equals(nombreObjeto)) {
					listaObjetos.remove(i);
					objetoEliminado = true;
				}
			}
			
		}
	}
	
	public void anadirObjeto(String nombreObjeto)
	{
		listaObjetos.add(new Objeto(nombreObjeto));
	}
	
	public void anadirArmadura(String nombreObjeto)
	{
		listaObjetos.add(new Objeto(nombreObjeto, true));
	}
}
