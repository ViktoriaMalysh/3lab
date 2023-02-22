package ua.edu.znu.servletstudy;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

/**
 * Servlet that processes user login.
 */
@WebServlet(name = "AuthServlet",
        urlPatterns = {"/AuthServlet"})
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(printHtmlHead("Login"));
            out.println("""
                     <body>
                    <form action="AuthServlet" method="post">
                    <p>Username: <input type="text" name="username"/></p>
                    <p>Password: <input type="password" name="password"/></p>
                    <p><input type="submit" value="Login"/></p>
                    </form>
                    </body>
                    </html>
                    """);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try (PrintWriter out = response.getWriter()) {
            out.println(printHtmlHead("Authentication"));
            if (isAuthenticated(username, password)) {
                out.println("""
                         <body>
                        <h3>Hello
                        """
                        + username
                        + "!</h3>");

                Map paramMap = request.getParameterMap();
                Iterator iter = paramMap.entrySet().iterator();
                while (iter.hasNext()){

                    Map.Entry me = (Map.Entry) iter.next();
                    out.println((String)me.getKey() + ": " + ((String[]) me.getValue())[0]);
                }



            } else {
                out.println("""
                         <body>
                        <h3>Authentication failed!</h3>
                        """);
            }
            out.println("""
                     </body>
                    </html>
                    """);
        }
    }

    /**
     * Authenticates user.
     *
     * @param username username
     * @param password password
     * @return is user authenticated
     */
    private boolean isAuthenticated(String username, String password) {
        return "user".equalsIgnoreCase(username)
                && "pass".equalsIgnoreCase(password);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that processes user login.";
    }

    /**
     * The header of the HTML-pages.
     *
     * @param title HTML-page name
     * @return HTML-page header
     */
    private String printHtmlHead(String title) {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                <title>"""
                + title
                + """
                </title>
                </head>
                """;
    }
}
