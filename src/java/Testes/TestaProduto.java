
package Testes;

import DAO.EnderecoDAO;
import DAO.PessoaFisicaDAO;
import DAO.PessoaJuridicaDAO;
import DAO.ProdutoDAO;
import DAO.TelefoneDAO;
import Model.Endereco;
import Model.Mensagem;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import Model.Produto;
import Model.Telefone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class TestaProduto {
    
    public static void main(String[] args) {
        /* EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vitrinePU");
       EntityManager manager = emfactory.createEntityManager(); 
       ProdutoDAO dao = new ProdutoDAO(emfactory);
       
        Produto produto = new Produto();
        produto.setNome("nome do produto 3");
        produto.setDescricao("produto de teste 3");
        produto.setCodigo("23");
        produto.setImagem("web/img/intel.jpg");
        produto.setLink("link da imagem");
        produto.setDesconto(10);
        produto.setValorunit(50);
        produto.setQuantidade(5);
        
        dao.create(produto);
        
        System.out.print("Salvo");*/
         EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("vitrinePU");
        EntityManager manager = emfactory.createEntityManager(); 
        
        PessoaFisica pf=new PessoaFisica();
        PessoaJuridica pj=new PessoaJuridica();
        Endereco end=new Endereco();
        Telefone tel=new Telefone();
        

        PessoaFisicaDAO jpa=new PessoaFisicaDAO();
        PessoaJuridicaDAO pjpa=new PessoaJuridicaDAO();
        EnderecoDAO jend=new EnderecoDAO();
        TelefoneDAO jtel=new TelefoneDAO();
        
     
        
        pf.setNome("joao augusto");
        pf.setCpf("333.333.333-33");
        pf.setEmail("joaoaugusto@gmail");
        pf.setLogin("joaoaugusto");
        pf.setSenha("123");
        pf.setTipo("PF");
        pf.setAcesso("ADM");
       
        pf.setTelefone(tel);
        pf.setEndereco(end);
        end.setRua("Rua da Alegria");
        end.setNumero(33);
        end.setComplemento("B");
        end.setBairro("Esperanca");
        end.setCidade("Recife");
        end.setEstado("Pernambuco");
        end.setCep("55555-55");
        tel.setTelefone("3333-4444");
        tel.setCelular("99999-0000");
        jtel.create(tel);
        jend.create(end);
        jpa.create(pf);
        
        
    }
}
