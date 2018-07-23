/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Model.Endereco;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import Model.Telefone;
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
 * @author valeria
 */
public class ContaUsuario extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         UsuarioDAO usuariodao = new UsuarioDAO();
         PessoaFisica pf=new PessoaFisica();
        
        long idUsuario = Integer.parseInt(request.getParameter("idusuario"));
        Usuario usuarioSendoEditado = usuariodao.findUsuario(idUsuario);
        HttpSession session = request.getSession();
        session.setAttribute("idusuariosendoeditado", idUsuario);
        session.setAttribute("usuariosendoeditado", usuarioSendoEditado);
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/editarusuarioconta.jsp");
        rd.forward(request, response);
        
        
    }
   

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
           HttpSession session = request.getSession();
            Usuario usuario;
            long idUsuario = (long) session.getAttribute("idusuariosendoeditado");
            String tipousuario = request.getParameter("tipousuario");
        
            if (tipousuario.equals("PF")) {
            
                usuario = new PessoaFisica();
           
            }
        
            else {
            
                usuario = new PessoaJuridica();
            }
        
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String login=request.getParameter("user");
            String senha = request.getParameter("senha");
            String rua = request.getParameter("rua");
            String complemento = request.getParameter("comp");
            String cep = request.getParameter("cep");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String telefone = request.getParameter("fone");
            String celular = request.getParameter("cel");
            String tipo = request.getParameter("tipousuario");
        
            UsuarioDAO usuariodao = new UsuarioDAO();
            
            usuario.setIdusuario(idUsuario);
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setEmail(email);
            usuario.setTipo(tipo);
            
            Endereco endereco = new Endereco();
            Telefone telefoneAtributo = new Telefone();
            
            endereco.setBairro(bairro);
            endereco.setRua(rua);
            endereco.setComplemento(complemento);
            endereco.setCidade(cidade);
            endereco.setCep(cep);
            endereco.setEstado(estado);
            
            usuario.setEndereco(endereco);
            
            telefoneAtributo.setTelefone(telefone);
            telefoneAtributo.setCelular(celular);
            
            usuario.setTelefone(telefoneAtributo);
             
            
            usuariodao.edit(usuario);
       
        
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/editarusuarioconta.jsp");
        rd.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
