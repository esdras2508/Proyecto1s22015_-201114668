package com.serverProject.arbolUsr;

public class nodoAVL {

    int balance;
    int rotacion;
    nodoAVL izquierda;
    nodoAVL derecha;

    String correo, pass;

    public nodoAVL() {
        balance = 0;
        rotacion = 0;
        izquierda = null;
        derecha = null;
        correo = "";
        pass = "";
    }

    public String getCorreo() {
        return correo;
    }

    public String getPass() {
        return pass;
    }

    public void Cambiar_Balance(int balance) {
        this.balance = balance;
    }

    public void Cambiar_Izquierda(nodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    public void Cambiar_Derecha(nodoAVL derecha) {
        this.derecha = derecha;
    }

    public void Cambiar_Correo(String correo) {
        this.correo = correo;
    }

    public void Cambiar_Pass(String pass) {
        this.pass = pass;
    }

}
