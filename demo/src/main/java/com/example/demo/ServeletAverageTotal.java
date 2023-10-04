package com.example.demo;


import com.google.gson.Gson;
import logic.Activity;
import logic.Average;
import logic.Subject;
import logic.averageTotal;
import persistence.DataBaseDaoAverage;
import persistence.DataBaseDaoAverageTotal;
import persistence.DataBaseDaoImplements;
import persistence.ServiceActivities;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;

@WebServlet(name = "ServeletAverageTotal", value = "/servlet-average-Total")
public class ServeletAverageTotal extends HttpServlet {

    private DataBaseDaoAverageTotal dataBaseDaoAverageTotal = new DataBaseDaoAverageTotal();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        response.setContentType("application/json");
        List<averageTotal> actividades = dataBaseDaoAverageTotal.getAverage();

        PrintWriter out = response.getWriter();


        String json = gson.toJson(actividades);

        out.println(json);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    public void destroy() {
    }
}
