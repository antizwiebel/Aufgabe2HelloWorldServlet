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
        _response.setContentType("text/html");

        PrintWriter out=_response.getWriter();
        EnvData pressure = null;
        try {

            EnvDataClientRMI envRmi = new EnvDataClientRMI();
            pressure = envRmi.getPressure();
        }catch(Exception _e) {
            System.out.println("Exception RMI getpressure");
            _e.printStackTrace();
        }


        /*EnvDataClientCpp envCpp = new EnvDataClientCpp();
        EnvData light = envCpp.requestEnvironmentData("light#");
        EnvData sound = envCpp.requestEnvironmentData("noise#");*/

        out.println("<HTML>");
        out.println("<HEAD><TITLE>HelloWorld</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H2>C++ Server Environment Data</H2>");
/*
        if (pressure==null){
            out.println("NULL");
        }
        */
        out.println("<table> " +
                "  <tr> " +
                "    <th>Timestamp</th> " +
                "    <th>Sensor</th> " +
                "    <th>Data</th> " +
                "  </tr> " +
                "  <tr> " +
                "    <td></td> " +
                "    <td></td> " +
                "    <td></td> " +
                "  </tr> " +
                "  <tr> " +
                "    <td></td> " +
                "    <td></td> " +
                "    <td></td> " +
                "  </tr> " +
                "</table>");

        out.println("<H2>RMI Server Environment Data</H2>");
        out.println("<table> " +
                "  <tr> " +
                "    <th>Timestamp</th> " +
                "    <th>Sensor</th> " +
                "    <th>Data</th> " +
                "  </tr> " +
                "  <tr> ");
        if (pressure!=null) {
            out.println("    <td>" + pressure.getTimeStamp().toString() + "</td> " +
                        "    <td>pressure</td> " +
                        "    <td>" + pressure.getmAirPressure() + "</td> ");
        }
        else{
            out.println("<td>Not Connected</td>" +
                         "<td></td>"+
                         "<td></td>");
        }
        out.println("  </tr> " +
                "</table>");
        out.println("<FORM> <INPUT TYPE=\"button\" onClick=\"history.go(0)\" VALUE=\"Refresh\"> </FORM>");
        out.println("</BODY>");
        out.println("</HTML>");
    }
}
