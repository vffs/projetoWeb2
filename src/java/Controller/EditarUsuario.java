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
import java.util.Objects;


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
public class EditarUsuario extends HttpServlet {

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
            out.println("<title>Servlet EditarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       
        
        UsuarioDAO usuariodao = new UsuarioDAO();
        
        long idUsuario = Integer.parseInt(request.getParameter("idusuario"));
        Usuario usuarioSendoEditado = usuariodao.findUsuario(idUsuario);
        HttpSession session = request.getSession();
        session.setAttribute("idusuariosendoeditado", idUsuario);
        session.setAttribute("usuariosendoeditado", usuarioSendoEditado);
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/editarusuario.jsp");
        rd.forward(request, response);
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
       
        
        
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/gerenciarusuarios.jsp");
        rd.forward(request, response);
       
        
        
        
        
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
