/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverProject.arbolEstacion;


/**
 *
 * @author esdras
 */
public class NodoEstacion {
    int balance;
	int rotacion, id, personas;
	NodoEstacion izquierda;
	NodoEstacion derecha;
	
	String  pass;
	
	public NodoEstacion() {
		balance =0;
		rotacion = 0;
		izquierda = null;
		derecha = null;
		pass = "";
                personas=0;
	}
	
	public void Cambiar_Balance(int balance){
		this.balance = balance;
	}
	
	public void Cambiar_Izquierda(NodoEstacion izquierda){
		this.izquierda = izquierda;
	}
	
	public void Cambiar_Derecha(NodoEstacion derecha){
		this.derecha = derecha;
	}
	
	public void Cambiar_id(int id){
		this.id = id;
	}
	
	public void Cambiar_Pass(String pass){
		this.pass = pass;
	}
        
	public void Cambiar_personas(int personas){
		this.personas = personas;
	}
}
