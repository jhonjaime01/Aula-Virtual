package Controlador;

import Logic.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.LoginDAO;

import java.io.IOException;


@WebServlet(name = "Validar", value = "/Validar")
public class Validar extends HttpServlet {
    LoginDAO lgDAO = new LoginDAO();
    Login lg = new Login();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion.equalsIgnoreCase("ingresar")) {
            String user = req.getParameter("txtuser");
            String pass = req.getParameter("txtpass");

            lg=lgDAO.validar(user,pass);
            if (lg.getUsuario() != null) {

                req.setAttribute("tipo_usuario", lg.getTipo_Persona());

                req.getRequestDispatcher("/Controlador").forward(req, resp);
            } else {
                req.getRequestDispatcher("/index.html").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/index.html").forward(req, resp);
        }
    }
}
