package com.example.demo;

import com.google.gson.Gson;
import logic.Subject;
import persistence.DataBaseDaoImplements;
import persistence.ServiceActivities;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServletMateria", value = "/servlet-materia")
public class ServletMateria extends HttpServlet {

    private String message;


    private DataBaseDaoImplements implement = new DataBaseDaoImplements();


    /**
     * Método doGet para
     * ENVIAR AL HTML LOS DATOS DE LA BASE DE DATOS
     * @param request
     * @param response
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        if (request.getParameter("op").equals("1")) {
            response.setContentType("text/json");
            List<Subject> materias = implement.getSubjects();
            String stAux = gson.toJson(materias);
            try (
                    PrintWriter out = response.getWriter();
            ) {
                out.println(stAux);
            }
        }
        if (request.getParameter("op").equals("2")) {

        }
    }


    /**
     * Método doPost para
     * GUARDAR DATOS EN LA BASE DE DATOS
     * ELIMINAR DATOS DE LA BASE DE DATOS
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("op").equals("1")){
            response.setContentType("text/json");
            String subjId = request.getParameter("subjId");
            String nameSubj = request.getParameter("nameSubj");
            String notaFinalSubj = request.getParameter("notaFinalSubj");

            Subject s = new Subject(subjId,nameSubj,notaFinalSubj);
            implement.addSubjects(s);

            try( PrintWriter out = response.getWriter()){
                out.println( subjId +" "+ nameSubj +" "+ notaFinalSubj);
            }
        }
        if (request.getParameter("op").equals("2")){
            response.setContentType("text/json");
            String id = request.getParameter("subjId");
            implement.deleteSubject(id);
            implement.delete(id);
        }

    }

    public void destroy() {
    }
}