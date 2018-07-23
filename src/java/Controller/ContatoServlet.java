package Controller;

import DAO.MensagemDAO;
import Model.Mensagem;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ContatoServlet extends HttpServlet {

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
       
        MensagemDAO m =new MensagemDAO();
        Mensagem ms=new Mensagem(); 
        
        String nome = request.getParameter("nome");
        String email=request.getParameter("email");
        String assunto=request.getParameter("assunto");
        String mensagem=request.getParameter("msg");
        HttpSession session = request.getSession();
        session.removeAttribute("alerta");
        
        Usuario usuario=(Usuario) session.getAttribute("usuario");
        
        if(usuario != null){
        ms.setAssunto(assunto);
        ms.setMensagem(mensagem);
        ms.setStatus("Nova");
        ms.setUsuario(usuario);
        usuario.setIdusuario(usuario.getIdusuario());
        m.create(ms);
       
        }
        else{
        ms.setNome(nome);
        ms.setEmail(email);
        ms.setAssunto(assunto);
        ms.setMensagem(mensagem);
        ms.setStatus("Nova");
        m.create(ms);
        
        }
        
      if(usuario !=null){
                session.setAttribute("alerta", "Sua mensagem foi enviada com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/logadomensagem.jsp");
                rd.forward(request, response);   
      } 
      else if(usuario==null){
                session.setAttribute("alerta", "Sua mensagem foi enviada com sucesso!");
                RequestDispatcher rd = request.getRequestDispatcher("/contato.jsp");
                rd.forward(request, response);
        }
        
        

  /*  @Override
    public String getServletInfo(){
        return "Contato Servlet";
    }// </editor-fold>

}*/
 }
}
