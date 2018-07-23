
package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastrarProduto extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastrarProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarProduto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vitrinePU");
        EntityManager manager = emfactory.createEntityManager();
        
        String nome=request.getParameter("nome");
        String preco=request.getParameter("preco");
        String desconto=request.getParameter("desconto");
        String img="img/"+request.getParameter("imagem"); 
        String descricao=request.getParameter("descricao");
        String descricaoCurta = request.getParameter("descricaoCurta");
        String quantidade=request.getParameter("quantidade");
        String quantidadeMinima = request.getParameter("quantidadeMinima");
        //out.println(quantidadeMinima);
        String cod=request.getParameter("codigo");
        String marca = request.getParameter("marca");
        String tipo = request.getParameter("tipo");
        
        Produto produto = new Produto();
        
        ProdutoDAO p = new ProdutoDAO();
        
        produto.setNome(nome);
        produto.setValorunit(preco);
        produto.setImagem(img);
        produto.setDescricao(descricao);
        produto.setDescricaoCurta(descricaoCurta);
        produto.setQuantidade(quantidade);
        produto.setQuantidadeMinima(quantidadeMinima);
        produto.setCodigo(cod);
        produto.setMarca(marca);
        produto.setTipo(tipo);
        produto.setDesconto(desconto);
        p.create(produto);
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/gerenciamento.jsp");
        rd.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
