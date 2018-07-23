
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Erros extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
private void ProcessError(HttpServletRequest request,
HttpServletResponse response) throws IOException, ServletException {
HttpSession session = request.getSession();
Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

if (servletName == null) {
servletName = "Unknown";
}
String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
if (requestUri == null) {
requestUri = "Unknown";
}
PrintWriter out = response.getWriter();
    if(500 != statusCode){
        RequestDispatcher rd = request.getRequestDispatcher("erro404.jsp");
        rd.forward(request, response);
      String usuario= (String) session.getAttribute("usuario");
       if(usuario!=null){
         String pessoa= (String) session.getAttribute("adm");
         String pessoa1= (String) session.getAttribute("def");
        
            if(pessoa1.equals("def")){
                RequestDispatcher r = request.getRequestDispatcher("WEB-INF/erro404logado.jsp");
            r.forward(request, response); 
             }
            if(pessoa.equals("adm")){
             RequestDispatcher r = request.getRequestDispatcher("WEB-INF/adm/erro404logadoadm.jsp");
            r.forward(request, response);
             }
        }
    }
    else {
       RequestDispatcher rd = request.getRequestDispatcher("erro500.jsp");
     rd.forward(request, response);
     String usuario= (String) session.getAttribute("usuario");
       
        if(usuario!=null){
         String pessoa= (String) session.getAttribute("adm");
         String pessoa1= (String) session.getAttribute("def");
        
            if(pessoa1.equals("def")){
                RequestDispatcher r = request.getRequestDispatcher("WEB-INF/erro500logado.jsp");
            r.forward(request, response); 
             }
            if(pessoa.equals("adm")){
             RequestDispatcher r= request.getRequestDispatcher("WEB-INF/adm/erro500logadoadm.jsp");
            r.forward(request, response);
             }
        }
       }
    }



    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
