/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CompraDAO;
import DAO.ProdutoDAO;

import Model.Carrinho;
import Model.Compra;
import Model.Produto;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
public class FinalizarCompra extends HttpServlet {

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
            out.println("<title>Servlet FinalizarCompra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FinalizarCompra at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        HttpSession session = request.getSession();
        Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
        ProdutoDAO produtodao = new ProdutoDAO();
        Produto produto;
        int quantidadeARetirar;
        int quantidadeAnterior;
        String quantidadeResultado;
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        String status = "";

        if (usuario == null) {
        
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

        }
        
        else {
        
            CompraDAO compradao = new CompraDAO();
            Compra compra = new Compra();    

            double valorTotal = carrinho.getValorTotal();

            for (int i = 0; i < carrinho.getItens().size(); i++) {

                status = status + carrinho.getItens().get(i).getProduto().getNome() + ", qtd: " +  carrinho.getItens().get(i).getQuantidade()+ "; ";
            }

            Date data = new Date(System.currentTimeMillis());
            compra.setStatus(status);
            compra.setDatacompra(data);      
            compra.setValorTotal(valorTotal);
            compra.setUsuario(usuario);
            compradao.create(compra);

            for (int i = 0; i < carrinho.getItens().size();i++) {

                produto = carrinho.getItens().get(i).getProduto();
                quantidadeAnterior = Integer.parseInt(produto.getQuantidade());
                quantidadeARetirar = carrinho.getItens().get(i).getQuantidade();
                quantidadeResultado = Integer.toString(quantidadeAnterior - quantidadeARetirar);

                produto.setQuantidade(quantidadeResultado);
                produtodao.edit(produto);

            }

            carrinho = null;

            session.setAttribute("carrinho", carrinho);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logado.jsp");
            rd.forward(request, response);
        
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
