package fh.hagenberg.PenederMauler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.util.Enumeration;

/**
 * Created by Mark on 15.12.2016.
 */
@WebServlet (
        urlPatterns = {"/envservlet", "/environmentserviceservlet"},
        description = "a hello world servlet."
)
public class EnvironmentServiceServlet extends HttpServlet {
    private int noOfClicks=0;

    public void doGet(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException{

        PrintWriter out=_response.getWriter();

        EnvDataClientRMI envRmi = new EnvDataClientRMI();
        EnvData pressure = envRmi.getPressure();

        EnvDataClientCpp envCpp = new EnvDataClientCpp();
        EnvData light = envCpp.requestEnvironmentData("light");
        EnvData sound = envCpp.requestEnvironmentData("noise");
        if (pressure==null){
            out.println("NULL");
        }
        out.println("<HTML>");
        out.println("<HEAD><TITLE>HelloWorld</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H2>C++ Server Environment Data</H2>");
        out.println("<table>\n" +
                "  <tr>\n" +
                "    <th>Timestamp</th>\n" +
                "    <th>Sensor</th>\n" +
                "    <th>Data</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td></td>\n" +
                "    <td></td>\n" +
                "    <td></td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td></td>\n" +
                "    <td></td>\n" +
                "    <td></td>\n" +
                "  </tr>\n" +
                "</table>");

        out.println("<H2>RMI Server Environment Data</H2>");
        out.println("<table>\n" +
                "  <tr>\n" +
                "    <th>Timestamp</th>\n" +
                "    <th>Sensor</th>\n" +
                "    <th>Data</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td></td>\n" +
                "    <td></td>\n" +
                "    <td></td>\n" +
                "  </tr>\n" +
                "</table>");

        out.println("<FORM> <INPUT TYPE=\"button\" onClick=\"history.go(0)\" VALUE=\"Refresh\"> </FORM>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
