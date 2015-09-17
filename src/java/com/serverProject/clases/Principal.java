/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serverProject.clases;


import javax.ejb.Stateless;
import javax.ws.rs.*;
import com.serverProject.arbolUsr.*;

/**
 *
 * @author esdras
 */
@Stateless
@Path("/services")
public class Principal {
    
    arbolAVL nuevo;
    @GET
    @Path("{usr}/{pass}")
    public String usuario(@PathParam("usr") String usr,@PathParam("pass") String pass ){
        /*String usr = "hola";*/
        if(usr.equals("admin")){
            System.out.println("Bienvenido ");
            return "Bienvenido Admin";
        }else{
            System.out.println("Usuario no encontrado");
            return "no se a encontrado el usuario";
        }
      
    }
    
    @POST
    @Path("/agregar")
    public String nuevoUsr(@PathParam("usr") String usr, @PathParam("pass") String pass){
        String respuesta;
        if(nuevo == null){
            nuevo = new arbolAVL();
            if(nuevo.insertar(usr, pass)){
                respuesta = "Usuario ingresado correctamente";
            }else{
                respuesta = "El usuario no se a podido ingresar";
            }
        }else{
            if(nuevo.insertar(usr, pass)){
                respuesta = "Usuario ingresado correctamente";
            }else{
                respuesta = "El usuario no se a podido ingresar";
            }
        }
        return respuesta;
    }
}