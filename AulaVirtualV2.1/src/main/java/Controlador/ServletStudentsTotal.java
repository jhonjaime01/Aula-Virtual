package Controlador;

import Logic.NombreMateria;
import Logic.Student;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.StudentDAO;
import persistence.estudiantesDAO;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "ServletStudentsTotal", value = "/servlet-students-Total")
public class ServletStudentsTotal extends HttpServlet {

    private estudiantesDAO stDAO;

    @Override
    public void init() throws ServletException {
        stDAO = new estudiantesDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        List<Student> totalEstudinates = stDAO.listadoMaterias();

        PrintWriter out = response.getWriter();
        out.println(gson.toJson(totalEstudinates));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
