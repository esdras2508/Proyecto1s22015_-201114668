/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverProject.clases;

import com.serverProject.arbolChofer.ArbolChofer;
import com.serverProject.arbolChofer.NodoChofer;
import com.serverProject.arbolEstacion.NodoEstacion;
import com.serverProject.arbolEstacion.arbolEstacion;
import javax.ws.rs.*;
import com.serverProject.arbolUsr.*;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author esdras
 */
@Stateless
@Path("/services")
public class Principal {

    arbolAVL nuevo;
    ArbolChofer chofer;
    arbolEstacion estacion;

    @GET
    @Path("/login/{usr}/{pass}")
    @Produces(MediaType.TEXT_PLAIN)
    public String usuario(@PathParam("usr") String usr, @PathParam("pass") String pass) {
        if (nuevo == null) {
            nuevo = new arbolAVL();
        }
        if (chofer == null) {
            chofer = new ArbolChofer();
        }
        if (estacion == null) {
            estacion = new arbolEstacion();
        }
        String respuesta = "";

        if (usr.equals("admin") && pass.equals("admin")) {
            System.out.println("Bienvenido ");
            respuesta = "Administrador";
        } else {
            nodoAVL busqueda = nuevo.Buscar(usr);
            if (busqueda != null) {
                if (busqueda.getCorreo().equals(usr) && busqueda.getPass().equals(pass)) {
                    respuesta = "Administrador";
                }
            } else {
                NodoChofer buscarChofer = chofer.Buscar(Integer.parseInt(usr));
                if (buscarChofer.getId() == Integer.parseInt(usr) && buscarChofer.getPass().equals(pass)) {
                    respuesta = "Chofer";
                } else {
                    NodoEstacion buscarEstacion = estacion.Buscar(Integer.parseInt(usr));
                    if (buscarEstacion.getId() == Integer.parseInt(usr) && buscarEstacion.getPass().equals(pass)) {
                        respuesta = "Estacion";
                    } else {
                        respuesta = "No existe";
                    }
                }
            }
        }
        return respuesta;

    }

    @GET
    @Path("/agregar/{usr}/{pass}")
    @Produces(MediaType.TEXT_PLAIN)
    public String nuevoUsr(@PathParam("usr") String usr, @PathParam("pass") String pass) {
        String respuesta;
        if (nuevo == null) {
            nuevo = new arbolAVL();
            if (nuevo.insertar(usr, pass)) {
                respuesta = "correcto";
            } else {
                respuesta = "incorrecto";
            }
        } else {
            if (nuevo.insertar(usr, pass) == true) {
                respuesta = "correcto";
            } else {
                respuesta = "incorrecto";
            }
        }
        return respuesta;
    }
}
