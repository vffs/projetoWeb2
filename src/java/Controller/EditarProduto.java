
package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
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
public class EditarProduto extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarProduto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProdutoDAO produtodao = new ProdutoDAO();
        long idProduto = Integer.parseInt(request.getParameter("idproduto"));
        Produto produtoSendoEditado = produtodao.findProduto(idProduto);
        HttpSession session = request.getSession();
        session.setAttribute("idprodutoeditado", idProduto);
        session.setAttribute("produtosendoeditado", produtoSendoEditado);

        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/editarproduto.jsp");
        rd.forward(request, response);
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Long idProduto = (Long) session.getAttribute("idprodutoeditado");
        Produto produto = new Produto();
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        String desconto = request.getParameter("desconto");
        String img ="img/"+ request.getParameter("imagem");
        String descricao = request.getParameter("descricao");
        String descricaocurta = request.getParameter("descricaocurta");
        String quantidade = request.getParameter("quantidade");
        String quantidadeMinima = request.getParameter("quantidadeMinima");
        String codigo = request.getParameter("codigo");
        String marca = request.getParameter("marca");
        String tipo = request.getParameter("tipo");
        
        ProdutoDAO p = new ProdutoDAO();
        
        produto.setIdproduto(idProduto);
        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setTipo(tipo);
        produto.setValorunit(preco);
        produto.setImagem(img);
        produto.setDescricao(descricao);
        produto.setDescricaoCurta(descricaocurta);
        produto.setQuantidade(quantidade);
        produto.setQuantidadeMinima(quantidadeMinima);
        produto.setCodigo(codigo);
        produto.setDesconto(desconto);
       
        p.edit(produto);
      
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/gerenciamento.jsp");
        rd.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
