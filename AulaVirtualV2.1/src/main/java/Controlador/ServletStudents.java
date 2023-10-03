package Controlador;

import Logic.NombreMateria;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import persistence.StudentDAO;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "ServletStudents", value = "/servlet-students")
public class ServletStudents extends HttpServlet {

    private StudentDAO stDAO;

    @Override
    public void init() throws ServletException {
        stDAO = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();

        List<NombreMateria> students = stDAO.listadoMaterias("jhon.salazar01");


        PrintWriter out = response.getWriter();
        out.println( gson.toJson( students));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
