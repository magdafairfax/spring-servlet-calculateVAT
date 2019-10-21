package com.vat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String height = request.getParameter("gross");
        String weight = request.getParameter("vatRate");

        try {
            double vat = calculateVAT(
                    Double.parseDouble(weight),
                    Double.parseDouble(height));

            request.setAttribute("vat", vat);
            response.setHeader("Test", "Success");
            response.setHeader("VAT", String.valueOf(vat));

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }

    private Double calculateVAT(Double gross, Double vatRate) {
        return gross / (1 + (1 / vatRate));
    }
}
