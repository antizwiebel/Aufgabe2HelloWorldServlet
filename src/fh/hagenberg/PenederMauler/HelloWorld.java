package fh.hagenberg.PenederMauler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Mark on 15.12.2016.
 */
@WebServlet (
    urlPatterns = {"/hello", "/world"},
        description = "a hello world servlet."
)
public class HelloWorld extends HttpServlet {
    private int noOfClicks=0;

    public void doGet(HttpServletRequest _request, HttpServletResponse _response)
    throws ServletException, IOException{
        noOfClicks++;
        _response.setContentType("text/html");

        PrintWriter out=_response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>HelloWorld</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1>");
        out.println("Number of Clicks:"+noOfClicks+"</H1><br>");
        Enumeration headerNames = _request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerNameKey = (String)headerNames.nextElement();
            out.println("<br><b>"+headerNameKey+"</b>");
            out.println("<br>"+_request.getHeader(headerNameKey));
        }

        out.println("</BODY>");
        out.println("</HTML>");

    }
}
