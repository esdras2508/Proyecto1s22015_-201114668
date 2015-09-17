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
public class ArbolChofer {

    private NodoChofer raiz, aux, busqueda, nuevaRaiz;
    private boolean rotacion = false;
    private boolean aumento = false;
    private boolean borrado = false;
    private boolean apuntado = false;
    private boolean apuntado2 = false;
    private boolean buscar = false;
    private int UltimaPos = 0;
    private boolean aceptada = false;

    public NodoChofer RetornarRaiz() {
        return raiz;
    }

    public boolean insertar(int id, String pass, NodoBus nodo) {
        NodoChofer verificar = insertarAVL(id, pass, nodo, raiz);
        if (verificar != null) {
            return true;
        } else {
            return false;
        }
    }

    private NodoChofer insertarAVL(int id, String pass, NodoBus bus, NodoChofer nuevo) {
        if (nuevo == null) {
            nuevo = new NodoChofer();
            if (raiz == null) {
                raiz = nuevo;
            }
            nuevo.Cambiar_id(id);
            nuevo.Cambiar_Pass(pass);
            nuevo.Cambiar_Balance(0);
            nuevo.Cambiar_lista(bus);
            return nuevo;
        } else {
            if (id < nuevo.id) {
                if (nuevo.izquierda == null) {
                    nuevo.balance--;
                    aumento = (nuevo.balance != 0);
                    nuevo.izquierda = insertarAVL(id, pass, bus, nuevo.izquierda);
                } else {
                    insertarAVL(id, pass, bus, nuevo.izquierda);
                    if (aumento) {
                        if (rotacion != true) {
                            nuevo.balance--;
                            aumento = (nuevo.balance != 0);
                        }
                    }
                    if (nuevaRaiz != null && nuevaRaiz.hashCode() != raiz.hashCode()) {
                        nuevo.izquierda = nuevaRaiz;
                        nuevaRaiz = null;
                        rotacion = false;
                    }
                    if (nuevo.balance < -1) {
                        if (nuevo.izquierda.balance > 0) {
                            if (raiz.hashCode() != nuevo.hashCode()) {
                                ID(nuevo);
                                aumento = false;
                                return null;
                            } else {
                                raiz = ID(nuevo);
                                aumento = false;
                                rotacion = false;
                                return null;
                            }
                        } else {
                            if (raiz.hashCode() != nuevo.hashCode()) {
                                II(nuevo);
                                aumento = false;
                                return null;
                            } else {
                                raiz = II(nuevo);
                                aumento = false;
                                rotacion = false;
                                return null;
                            }
                        }
                    }
                }
            } else {
                if (nuevo.derecha == null) {
                    nuevo.balance++;
                    aumento = (nuevo.balance != 0);
                    nuevo.derecha = insertarAVL(id, pass, bus, nuevo.derecha);
                } else {
                    insertarAVL(id, pass, bus, nuevo.derecha);
                    if (aumento) {
                        if (rotacion != true) {
                            nuevo.balance++;
                            aumento = (nuevo.balance != 0);
                        }
                    }
                    if (nuevaRaiz != null && nuevaRaiz.hashCode() != raiz.hashCode()) {
                        nuevo.derecha = nuevaRaiz;
                        nuevaRaiz = null;
                        rotacion = false;
                    }
                    if (nuevo.balance > 1) {
                        if (nuevo.derecha.balance < 0) {
                            if (raiz.hashCode() != nuevo.hashCode()) {
                                DI(nuevo);
                                aumento = false;
                                return null;
                            } else {
                                raiz = DI(nuevo);
                                aumento = false;
                                rotacion = false;
                                return null;
                            }
                        } else {
                            if (raiz.hashCode() != nuevo.hashCode()) {
                                DD(nuevo);
                                aumento = false;
                                return null;
                            } else {
                                raiz = DD(nuevo);
                                aumento = false;
                                rotacion = false;
                                return null;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //rotacion derecha derecha
    private NodoChofer DD(NodoChofer nodo) {
        rotacion = true;
        NodoChofer aux = nodo.derecha.izquierda;
        nodo.derecha.izquierda = nodo;
        if (aux == null) {
            if (nodo.izquierda != null) {
                nodo.derecha.balance--;
            }
            if (nodo.izquierda == null) {
                nodo.derecha.balance = 0;
            }
        } else {
            if (nodo.izquierda != null) {
                nodo.derecha.balance = 0;
            }
            if (nodo.izquierda == null) {
                nodo.derecha.balance--;
            }

        }

        NodoChofer aux2 = nodo.derecha;
        nodo.derecha = aux;
        if (aux == null) {
            if (nodo.izquierda != null) {
                nodo.balance--;
            }
            if (nodo.izquierda == null) {
                nodo.balance = 0;
            }
        } else {
            if (nodo.izquierda != null) {
                nodo.balance = 0;
            }
            if (nodo.izquierda == null) {
                nodo.balance++;
            }

            /*else{
             A.balance=1;
             }*/
        }

        nuevaRaiz = aux2;
        aux2.rotacion = 11;
        return aux2;

    }

    // rotaciones
    //rotacion izquierda izquierda
    private NodoChofer II(NodoChofer nuevo) {
        rotacion = true;
        NodoChofer aux = nuevo.izquierda.derecha;
        nuevo.izquierda.derecha = nuevo;
        if (aux == null) {
            if (nuevo.derecha != null) {
                nuevo.izquierda.balance++;
            }
            if (nuevo.derecha == null) {
                nuevo.izquierda.balance = 0;
            }
        } else {
            if (nuevo.derecha != null) {
                nuevo.izquierda.balance = 0;
            }
            if (nuevo.derecha == null) {
                nuevo.izquierda.balance++;
            }
        }

        NodoChofer aux2 = nuevo.izquierda;
        nuevo.izquierda = aux;
        if (aux == null) {
            if (nuevo.derecha != null) {
                nuevo.balance++;
            }
            if (nuevo.derecha == null) {
                nuevo.balance = 0;
            }
        } else {
            if (nuevo.derecha != null) {
                nuevo.balance = 0;
            }
            if (nuevo.derecha == null) {
                nuevo.balance--;
            }
        }
        nuevaRaiz = aux2;
        aux2.rotacion = 10;
        return aux2;
    }

    //rotacion izquierda derecha
    private NodoChofer ID(NodoChofer nodo) {
        nodo.izquierda = DD(nodo.izquierda);
        return II(nodo);
    }

    //rotacion derecha izquierda
    private NodoChofer DI(NodoChofer nodo) {
        nodo.derecha = II(nodo.derecha);
        return DD(nodo);
    }

    public NodoChofer Buscar(int id) {//buscar por ID
        return Buscar(id, raiz);
    }

    private NodoChofer Buscar(int id, NodoChofer A) {//busqueda interna por ID
        if (A != null) {
            if (id < A.id) {
                Buscar(id, A.izquierda);

            } else {
                if (id > A.id) {
                    Buscar(id, A.derecha);
                } else {
                    this.busqueda = A;
                }
            }
        } else {
            busqueda = null;
        }
        return busqueda;

    }//fin de buscar

    //inicio eliminar
    public void eliminar(int id) {
        eliminar(id, raiz);
    }

    private void eliminar(int id, NodoChofer A) {
        if (raiz.izquierda != null || raiz.derecha != null) {
            if (A != null) {
                if (A.id < id) {
                    eliminar(id, A.derecha);
                    if (nuevaRaiz != null && nuevaRaiz.hashCode() != raiz.hashCode()) {
                        A.izquierda = nuevaRaiz;
                        nuevaRaiz = null;
                    }
                    if (borrado == true) {
                        A.balance--;
                        rotarBorrado(A);
                        borrado = (A.balance == 0);
                    }
                    if (apuntado == true) {
                        A.derecha = aux;
                        apuntado = false;
                    }
                } else {
                    if (A.id > id) {
                        eliminar(id, A.izquierda);
                        if (nuevaRaiz != null && nuevaRaiz.hashCode() != raiz.hashCode()) {
                            A.izquierda = nuevaRaiz;
                            nuevaRaiz = null;
                        }
                        if (borrado == true) {
                            A.balance++;
                            rotarBorrado(A);
                            borrado = (A.balance == 0);
                        }
                        if (apuntado == true) {
                            A.izquierda = aux;
                            apuntado = false;
                        }
                    } else {
                        if (A.id == id) {
                            borrado = true;
                            apuntado = true;
                            if (A.izquierda == null) {
                                aux = A.derecha;
                            } else {
                                if (A.derecha == null) {
                                    aux = A.izquierda;
                                } else {
                                    aux = Reemplazar(A, A, true);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            raiz = null;
        }
    }

    private NodoChofer Aux2;

    private NodoChofer Reemplazar(NodoChofer A, NodoChofer buscado, boolean estado) {
        if (estado == true) {
            Reemplazar(A.izquierda, buscado, false);
            if (nuevaRaiz != null && nuevaRaiz.hashCode() != raiz.hashCode()) {
                A.izquierda = nuevaRaiz;
                nuevaRaiz = null;
            }
            if (buscado.hashCode() == raiz.hashCode()) {
                raiz = Aux2;
            }
            if (Aux2.hashCode() != buscado.izquierda.hashCode()) {
                Aux2.izquierda = buscado.izquierda;
                buscado.izquierda = null;
            } else {
                buscado.izquierda = null;
            }
            Aux2.derecha = buscado.derecha;
            buscado.derecha = null;
            if (borrado == true) {
                Aux2.balance++;
                rotarBorrado(Aux2);
                borrado = (Aux2.balance == 0);
            }
        } else {
            if (A.derecha == null) {
                Aux2 = A;
                borrado = true;
                apuntado2 = true;
            } else {
                Reemplazar(A.derecha, buscado, estado);
                if (nuevaRaiz != null && nuevaRaiz.hashCode() != raiz.hashCode()) {
                    A.derecha = nuevaRaiz;
                    nuevaRaiz = null;
                }
                if (apuntado2 == true) {
                    A.derecha = Aux2.izquierda;
                    apuntado2 = false;
                }
                if (borrado == true) {
                    A.balance--;
                    rotarBorrado(A);
                    borrado = (A.balance == 0);
                }
            }
        }
        //if(A.derecha!=null)Aux2=null;
        return Aux2;
    }

    private boolean rotarBorrado(NodoChofer A) {
        if (A.balance < -1) {
            if (A.izquierda.balance > 0) {
                if (raiz.hashCode() != A.hashCode()) {
                    ID(A);
                    borrado = false;
                    return true;
                } else {
                    raiz = ID(A);
                    borrado = false;
                    return true;
                }

            } else {
                if (raiz.hashCode() != A.hashCode()) {
                    II(A);
                    borrado = false;
                    return true;
                } else {
                    raiz = II(A);
                    borrado = false;
                    return true;
                }

            }
        } else {
            if (A.balance > 1) {
                if (A.derecha.balance < 0) {
                    if (raiz.hashCode() != A.hashCode()) {
                        DI(A);
                        borrado = false;
                        return true;
                    } else {
                        raiz = DI(A);
                        borrado = false;
                        return true;
                    }
                } else {
                    if (raiz.hashCode() != A.hashCode()) {
                        DD(A);
                        borrado = false;
                        return true;
                    } else {
                        raiz = DD(A);
                        aumento = false;
                        borrado = false;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
