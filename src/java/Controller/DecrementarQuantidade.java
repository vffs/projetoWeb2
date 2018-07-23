/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Carrinho;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author proto
 */
public class DecrementarQuantidade extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DecrementarQuantidade</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DecrementarQuantidade at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String codigoProdutoDecrementado = request.getParameter("codigoProdutoDecrementado");
        Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");  
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        if (carrinho == null) {
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
        else {
        
            for (int i = 0; i < carrinho.getItens().size(); i++) {



                if (carrinho.getItens().get(i).getProduto().getCodigo().equals(codigoProdutoDecrementado) && carrinho.getItens().get(i).getQuantidade() > 0 ) {

                    carrinho.getItens().get(i).decrementarQuantidade();
                }
            }

            session.setAttribute("carrinho", carrinho);
            
            if (usuario == null) {

                RequestDispatcher rd = request.getRequestDispatcher("carrinho.jsp");
                rd.forward(request, response);
            
            }
            
            else {
                
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logadocarrinho.jsp");
                rd.forward(request, response);
            
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
