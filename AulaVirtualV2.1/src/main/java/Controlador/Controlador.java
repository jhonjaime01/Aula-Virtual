package Controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "Controlador", value = "/Controlador")
public class Controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Ingresando al servlet Controlador");

        String accion= request.getParameter("accion");
        String tipo_usuario = (String) request.getAttribute("tipo_usuario");

        switch (tipo_usuario){
            case "estudiante":
                request.getRequestDispatcher("/estudiante.html").forward(request,response);
                break;
            case "profesor":
                request.getRequestDispatcher("/profesor.html").forward(request,response);
                break;
            case "administrador":
                request.getRequestDispatcher("/administrador.html").forward(request,response);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
