package Controller;

import DAO.PessoaFisicaDAO;
import DAO.PessoaJuridicaDAO;
import DAO.UsuarioDAO;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
 
        UsuarioDAO u = new UsuarioDAO();
        PessoaFisicaDAO pfs = new PessoaFisicaDAO();
        PessoaJuridicaDAO pjs = new PessoaJuridicaDAO();     
        String login = request.getParameter("usr");
        String senha = request.getParameter("psw");
        HttpSession session = request.getSession();
        session.removeAttribute("falhalogin");
            
        for (Usuario user : u.findUsuarioEntities()) {
                
            if(user.getLogin().equals(login) && user.getSenha().equals(senha)) {
                    
                session.setAttribute("usuario", user);
                    
                if (user.getTipo() != null){
                        
                    switch (user.getTipo()){
                        
                        case "PF":
                            
                            for (PessoaFisica pf : pfs.findPessoaFisicaEntities()) {
                                
                                if (Objects.equals(pf.getIdusuario(), user.getIdusuario())){
                                    
                                    session.setAttribute("usuario", pf);
                                    pf.getAcesso();
                                    
                                    if ("ADM".equals(pf.getAcesso())){
                                        
                                        session.setAttribute("adm",pf);  
                                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/gerenciamento.jsp");
                                        rd.forward(request, response);   
                                    }
                                    
                                    else {
                                        
                                        session.setAttribute("def",pf);   
                                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logado.jsp");
                                        rd.forward(request, response);   
                                    }
                                }
                            }   
                        
                            break;
                       
                        case "PJ":
                            
                            for (PessoaJuridica pj : pjs.findPessoaJuridicaEntities()) {
                                
                                if (Objects.equals(pj.getIdusuario(), user.getIdusuario())) {
                                    
                                    session.setAttribute("usuario", pj);
                                    pj.getAcesso();
                                    
                                    if ("ADM".equals(pj.getAcesso())){
                                    
                                        session.setAttribute("adm",pj);  
                                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/gerenciamento.jsp");
                                        rd.forward(request, response);   
                                    }
                                    
                                    else {
                                      
                                        session.setAttribute("def",pj);   
                                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logado.jsp");
                                        rd.forward(request, response);   
                                    }
                                    
                                }
                            }   
                            
                            break;
                        }
                }    
            }
        }
                
        if (session.getAttribute("usuario") == null) {
                    
            session.setAttribute("falhalogin", "Falha ao Efetuar Login!");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    
}
                


@Override
    public String getServletInfo() {
        return "loginServlet";
    }// </editor-fold>
    
     
}
