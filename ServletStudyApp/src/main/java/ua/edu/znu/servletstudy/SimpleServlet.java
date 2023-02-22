
package ua.edu.znu.servletstudy;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet that returns a static Веб page.
 */

public class SimpleServlet extends HttpServlet {
    private String message;
    @Override
    public void init() {
        message = "Hello from the Simple Servlet!";
    }
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.printf("""
 <html>
<head>
<title>Simple Servlet</title>
</head>
 <body>
 <h2>Simple Servlet at %s</h2>
<br/>%s
</body>
</html>
""", request.getContextPath(), message);
        }
    }
    /**
     * Handles the HTTP GET
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
    /**
     * Handles the HTTP POST
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet that returns a static Веб page.";
    }
}