package Controller;

import DAO.ProdutoDAO;
import Model.Carrinho;
import Model.Item;
import Model.Produto;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarrinhoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Item> itens = new ArrayList<>();
        ProdutoDAO produtodao = new ProdutoDAO();
        List<Produto> produtos = produtodao.getProdutos();
        String codigo = (String) request.getParameter("codigo");
        Produto novoProduto;
        Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        if (session.getAttribute("carrinho") == null) {
            
            carrinho = new Carrinho();
            carrinho.setItens(itens);
            session.setAttribute("carrinho", carrinho);
            
        }

        for (int i = 0; i < produtos.size(); i++) {
            
           

            if (produtos.get(i).getCodigo().equals(codigo)) {
            
                novoProduto = produtos.get(i);    
                
                if (carrinho.getItens() == null) {
            
                    Item novoItem = new Item();
                    novoItem.setProduto(novoProduto);
                    carrinho.adicionarItem(novoItem);
                
                }
                
                else {
                
                    boolean produtoJaEmItem = false;
                    
                    for (int j = 0; j < carrinho.getItens().size(); j++) {
                        
                        if (carrinho.getItens().get(j).getProduto().equals(novoProduto)) {
                        
                            carrinho.getItens().get(j).incrementarQuantidade();
                            produtoJaEmItem = true;
                            break;
                        }
                        
                    }
                    
                    if (produtoJaEmItem == false) {
                        
                        Item novoItem = new Item();
                        novoItem.setProduto(novoProduto);
                        carrinho.adicionarItem(novoItem);
                    }
                }
            }
        }
             
        session.setAttribute("carrinho", carrinho);
        
        
        if (usuario != null) {
        

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/logado.jsp");
            rd.forward(request, response);

            
        }
        
        else {
            
 
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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