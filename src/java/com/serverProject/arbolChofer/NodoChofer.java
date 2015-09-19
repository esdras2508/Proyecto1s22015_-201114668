/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverProject.arbolChofer;

/**
 *
 * @author esdras
 */
public class NodoChofer {

    int balance;
    int rotacion, id;

    NodoChofer izquierda;
    NodoChofer derecha;
    NodoBus lista;

    String pass;

    public NodoChofer() {
        balance = 0;
        rotacion = 0;
        izquierda = null;
        derecha = null;
        lista = null;
        pass = "";
        id = 0;

    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public void Cambiar_Balance(int balance) {
        this.balance = balance;
    }

    public void Cambiar_Izquierda(NodoChofer izquierda) {
        this.izquierda = izquierda;
    }

    public void Cambiar_Derecha(NodoChofer derecha) {
        this.derecha = derecha;
    }

    public void Cambiar_lista(NodoBus lista) {
        this.lista = lista;
    }

    public void Cambiar_id(int id) {
        this.id = id;
    }

    public void Cambiar_Pass(String pass) {
        this.pass = pass;
    }
}
