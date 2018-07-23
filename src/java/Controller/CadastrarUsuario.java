package Controller;

import DAO.EnderecoDAO;
import DAO.PessoaFisicaDAO;
import DAO.PessoaJuridicaDAO;
import DAO.TelefoneDAO;
import Model.Endereco;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import Model.Telefone;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            
            Endereco endereco = new Endereco();
            Telefone telefone = new Telefone();
            PessoaFisica pf = new PessoaFisica();
            PessoaJuridica pj = new PessoaJuridica();
            
            EnderecoDAO edao=new EnderecoDAO();
            TelefoneDAO tdao=new TelefoneDAO();
            PessoaFisicaDAO pfdao=new PessoaFisicaDAO();
            PessoaJuridicaDAO pjdao =new PessoaJuridicaDAO();  

            String nome = request.getParameter("nome");
            String acesso=request.getParameter("selecionar");
            String cpf = request.getParameter("cpf");
            String cnpj = request.getParameter("cnpj");
            String email = request.getParameter("email");
            String login = request.getParameter("user");
            String senha = request.getParameter("senha");
            String rua = request.getParameter("rua");
            String complemento = request.getParameter("comp");
            String cep = request.getParameter("cep");
            int numero = Integer.parseInt(request.getParameter("num"));
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String fone = request.getParameter("fone");
            String celular = request.getParameter("cel");
           
            if (cpf.isEmpty()) {
                pj.setNome(nome);
                pj.setCnpj(cnpj);
                pj.setEmail(email);
                pj.setLogin(login);
                pj.setSenha(senha);
                pj.setTipo("PJ");
                if("padrao".equals(acesso)){
                 pj.setAcesso("DEFAULT"); 
                }
                else if("adm".equals(acesso)){
                pj.setAcesso("ADM"); 
                }
                
               
                pj.setTelefone(telefone);
                pj.setEndereco(endereco);
                endereco.setRua(rua);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                endereco.setEstado(estado);
                endereco.setComplemento(complemento);
                endereco.setNumero(numero);
                endereco.setCep(cep);
                session.setAttribute("endereco",endereco );
                telefone.setTelefone(fone);
                telefone.setCelular(celular);
                session.setAttribute("telefone",telefone );
                edao.create(endereco);
                tdao.create(telefone); 
                session.setAttribute("usuario", pj);
                pjdao.create(pj);
                
            } 
            else{
                pf.setNome(nome);
                pf.setCpf(cpf);
                pf.setEmail(email);
                pf.setLogin(login);
                pf.setSenha(senha);
                pf.setTipo("PF");
                if("padrao".equals(acesso)){
                 pf.setAcesso("DEFAULT"); 
                }
                else if("adm".equals(acesso)){
                pf.setAcesso("ADM"); 
                }
                
               
                pf.setEndereco(endereco);
                pf.setTelefone(telefone);
                endereco.setRua(rua);
                endereco.setBairro(bairro);
                endereco.setCidade(cidade);
                endereco.setEstado(estado);
                endereco.setComplemento(complemento);
                endereco.setNumero(numero);
                endereco.setCep(cep);
                session.setAttribute("endereco",endereco );
                telefone.setTelefone(fone);
                telefone.setCelular(celular);
                session.setAttribute("telefone",telefone );
                edao.create(endereco);
                tdao.create(telefone); 
                session.setAttribute("usuario", pf);
                pfdao.create(pf);  
            }
            
           
           RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/exibirdados.jsp");
           rd.forward(request, response);
            
     
      
    }

   @Override
    public String getServletInfo() {
        return "Cadastro Servlet";
    }// </editor-fold>

}
