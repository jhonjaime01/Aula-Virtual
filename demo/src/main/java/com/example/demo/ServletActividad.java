package com.example.demo;

import com.google.gson.Gson;
import logic.Activity;
import logic.Subject;
import persistence.DataBaseDaoImplements;
import persistence.ServiceActivities;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "ServletActividad", value = "/servlet-actividad")
public class ServletActividad extends HttpServlet {

    private DataBaseDaoImplements implement = new DataBaseDaoImplements();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        if (request.getParameter("op").equals("1")) {
            response.setContentType("text/json");
            List<Activity> actividades = implement.getActivities();
            String stAux = gson.toJson(actividades);
            try (
                    PrintWriter out = response.getWriter();
            ) {
                out.println(stAux);
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("op").equals("1")){
            response.setContentType("text/json");
            String actId = request.getParameter("actId");
            String tipoAct = request.getParameter("tipoAct");
            String nombreAct = request.getParameter("nombreAct");
            String descripcionAct = request.getParameter("descripcionAct");
            String ponderadoAct = request.getParameter("ponderadoAct");
            String fechaAct = request.getParameter("fechaAct");
            String calificacionAct = request.getParameter("calificacionAct");
            String idMateria = request.getParameter("idMateria");
            Activity a = new Activity(actId,tipoAct,nombreAct,descripcionAct,
                    ponderadoAct,fechaAct,calificacionAct,
                    idMateria);
            implement.addActivities(a);

            try( PrintWriter out = response.getWriter()){
                out.println( actId +" "+ tipoAct +" "+ nombreAct + " " +descripcionAct
                +" " + ponderadoAct + " " + fechaAct + " " + calificacionAct + " " + idMateria);
            }
        }
        if (request.getParameter("op").equals("2")){
            response.setContentType("text/json");
            String actId = request.getParameter("actId");
            implement.delete(actId);
        }

    }

    public void destroy() {
    }
}