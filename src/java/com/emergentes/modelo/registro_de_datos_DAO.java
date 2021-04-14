
package com.emergentes.modelo;

import java.util.ArrayList;

public class registro_de_datos_DAO {
     private int correlativo;
    private ArrayList<registro_de_datos> registros;

    public registro_de_datos_DAO() {
        registros =new ArrayList<registro_de_datos>();
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public ArrayList<registro_de_datos> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<registro_de_datos> registros) {
        this.registros = registros;
    }
    public void insertar(registro_de_datos item){
        registros.add(item);
    }
    public void modificar(int id, registro_de_datos item){
        int pos = posicion(id);
        registros.set(pos, item);
    }
    public void eliminar(int id){
        int pos=posicion(id);
        registros.remove(pos);
    }
    public int posicion(int id){
        int i=-1;
        if(registros.size()>0){
            for(registro_de_datos item : registros){
                ++i;
                if(item.getId() == id){
                    break;
                }
            }
        }
        return i;
    } 
}
