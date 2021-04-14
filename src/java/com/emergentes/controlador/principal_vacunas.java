
package com.emergentes.controlador;

import com.emergentes.modelo.registro_de_datos;
import com.emergentes.modelo.registro_de_datos_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class principal_vacunas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        registro_de_datos_DAO gestor=(registro_de_datos_DAO) ses.getAttribute("gestor");
        if(gestor==null){
            registro_de_datos_DAO auxi=new registro_de_datos_DAO();
            ses.setAttribute("gestor", auxi);
        }
        String op=request.getParameter("op");
        if(op==null){
            op="";
        }
        if(op.trim().equals("")){
            response.sendRedirect("vista/listado.jsp");
        }
        if(op.trim().equals("nuevo")){
            ses=request.getSession();
            registro_de_datos obj=new registro_de_datos();
            obj.setId(gestor.getCorrelativo()+1);
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/nuevo.jsp").forward(request, response);
        }
        if(op.trim().equals("editar")){
            int pos=gestor.posicion(Integer.parseInt(request.getParameter("id")));
            registro_de_datos obj =gestor.getRegistros().get(pos);
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/editar.jsp").forward(request, response);
        }
        if(op.trim().equals("eliminar")){
            int pos=gestor.posicion(Integer.parseInt(request.getParameter("id")));
            gestor.getRegistros().remove(pos);
            response.sendRedirect("vista/listado.jsp");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses= request.getSession();
        registro_de_datos_DAO gestor =(registro_de_datos_DAO) ses.getAttribute("gestor");
        registro_de_datos obj =new registro_de_datos();
        gestor.setCorrelativo(gestor.getCorrelativo()+1);
        
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setNombre(request.getParameter("nombre"));
        obj.setPeso(Integer.parseDouble(request.getParameter("peso")));
        obj.setTalla(Integer.parseDouble(request.getParameter("talla")));
        obj.setVacuna(request.getParameter("vacuna"));
        
        String tipo = request.getParameter("tipo");
        
        if(tipo.equals("-1")){
            obj.setId(gestor.getCorrelativo());
            gestor.insertar(obj);
        } else{
            gestor.modificar(obj.getId(), obj);
        }
        response.sendRedirect("vista/listado.jsp");
    }

}
