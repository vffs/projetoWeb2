package Controller;

import BancoDeDados.BancoDeDados;
import DAO.ProdutoDAO;
import Model.Produto;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InfoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProdutoDAO pdao = new ProdutoDAO();
        
        List<Produto> produtos;

            produtos = pdao.getProdutos();
      
        HttpSession session = request.getSession();
        Usuario usuario= (Usuario) session.getAttribute("usuario");
        String codigo = request.getParameter("codigo");
        
        Produto produto;
        
       
        
        for (Produto produto1 : produtos) {
            if (produto1.getCodigo().equals(codigo)) {
                produto = produto1;
                session.setAttribute("produto", produto);
            }
        }
        
        if(usuario !=null){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/infoprodutologado.jsp");
        rd.forward(request, response);
        }else{
        RequestDispatcher rd = request.getRequestDispatcher("/infoproduto.jsp");
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
