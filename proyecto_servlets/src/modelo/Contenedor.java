package modelo;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * En esta clase guardaremos todos los datos que la persona que ocupe el sistema quiera ingresar, ademas contiene los metodos para mostrar 
 * estos datos o eliminarlos.
 * @author grupo 3 Fernando Cabrera, Jorge Navarrete, Karen Recabarren, Juvenal Colipi, Juan Lagos.
 *
 */
public class Contenedor  {
	private ArrayList<Asesoria> list1 = new ArrayList<Asesoria>();
	private ArrayList<Capacitacion> list2 = new ArrayList<Capacitacion>();
	Scanner letras = new Scanner(System.in);
	Scanner numeros = new Scanner(System.in); 
	String temp = "", temp2 = "";
	int tempin = 0, temp2in = 0;

	public Contenedor() {
		super();
	}
	/**
	 * Agrega los datos al array "list1" es decir, agrega un nuevo usuario.
	 * @param x son los distintos objetos que estaran alamacenados en el array: "list1"
	 */
	public void agregarusuario(Asesoria x) {
		list1.add(x);
	}
	/**
	 * Recorre las listas y muestra los datos de todos los usuarios registrados.
	 */
	public void desplegar() {
		temp="";
		for (Asesoria x : list1) {
			temp=x.getClass().getName();
			if ("sistema.Usuario".equals(temp)) {
				x.analizarUsuario();
			}
			if ("sistema.Cliente".equals(temp)) {
				System.out.println(x.mostrarusuario());				
			}
			if ("sistema.Profesional".equals(temp)) {
				System.out.println(x.mostrarusuario());
			}
			if ("sistema.Administrativo".equals(temp)) {
				System.out.println(x.mostrarusuario());
			}
		}
		if(temp=="") {System.out.println("Listado vacio");}
		
	}
	/**
	 * Elimina usuario contenido en la lista de acuerdo al rut ingresado.
	 */
	public void eliminarusuario() {
		do {	
			System.out.println("ingrese rut a eliminar");
			temp = letras.nextLine();
			tempin= Integer.parseInt(temp.substring(0, temp.length()-2));
		}while(temp.length()<9 || temp.length()>10);
		System.out.println("rut ingresado: "+temp);
		for(Asesoria x: list1) {			
			temp2= x.encontrarRun();
			temp2in= Integer.parseInt(temp2.substring(0, temp2.length()-2));
			
				if (tempin == temp2in) {
					list1.remove(x);
					System.out.println("Usuario encontrado y borrado");
					break;
				}	
		}
		if(tempin!=temp2in) {
			System.out.println("run no encontrado");
		}
	}
	/**
	 * Muestra una lista de usuarios de acuerdo al seleccionado, lista cliente, lista profesional o lista administrativo.  
	 */	
	public void tipousuario() {
		do {
		System.out.println("###########################* SUB MENU ELEGIR LISTA DE TIPO DE USUARIO *#############################");
		System.out.println("Seleccione una opcion (numero de cada renglon): "
						   +"\n1.**Cliente**"
						   +"\n2.**Profesional**"
						   +"\n3.**Administrativo**");
		System.out.println("##########################################################################");
		System.out.println("");		
		tempin = numeros.nextInt();
		}while(tempin < 1 || tempin > 3);
			switch (tempin) {
				case 1:
						System.out.println("***********LISTA DE CLIENTES******");
						for (Asesoria x : list1) {
							temp=x.getClass().getName();
							if ("sistema.Cliente".equals(temp)) {
								x.analizarUsuario();
							}
						}
						System.out.println("");
						break;
				case 2:
						System.out.println("***********LISTA DE PROFESIONAL******");
						for (Asesoria x : list1) {
							temp=x.getClass().getName();
							if ("sistema.Profesional".equals(temp)) {
								x.analizarUsuario();
							}
						}
						System.out.println("");
						break;
				case 3:
						System.out.println("***********LISTA DE ADMINSTRATIVO******");
						for (Asesoria x : list1) {
							temp=x.getClass().getName();
							if ("sistema.Administrativo".equals(temp)) {
								x.analizarUsuario();
							}
						}
						System.out.println("");
						break;
		}
	}
	/**
	 * Registra cada capacitacion y sus atributos. Agrega los datos al array "list2"  
	 * @param x son los distintos objetos que estaran almacenados en el array: "list2"
	 */
	public void agregarcapa(Capacitacion x) {
		list2.add(x);
	}
	/**
	 * Recorre las listas y muestra los datos contenidos.
	 */
	public void desplegarcapa() {
		for (Capacitacion x : list2) {
			System.out.println(x.mostrarDetalle());
		}
	}
	
}
