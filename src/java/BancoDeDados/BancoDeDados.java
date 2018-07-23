package BancoDeDados;

import Model.Mensagem;
import Model.PessoaFisica;
import Model.PessoaJuridica;
import Model.Produto;
import Model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<PessoaFisica> pfs = new ArrayList<PessoaFisica>();
    private List<PessoaJuridica> pjs = new ArrayList<PessoaJuridica>();
    private List<Mensagem> mensagens = new ArrayList<Mensagem>();
    
    
    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<PessoaFisica> getPfs() {
        return pfs;
    }

    public List<PessoaJuridica> getPjs() {
        return pjs;
    }
    
    public BancoDeDados() {
    
/* PRODUTOS CADASTRADOS */

        Produto produto1 = new Produto();
        
        produto1.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto1.setValorunit("230.00");
        produto1.setNome("Processador A");
        produto1.setCodigo("1");
        produto1.setDesconto("0");
        produto1.setImagem("img/intel.jpg");
        
        Produto produto2 = new Produto();
        
        produto2.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto2.setValorunit("230.00");
        produto2.setNome("Processador B");
        produto2.setCodigo("2");
        produto2.setDesconto("0");
        produto2.setImagem("img/amd.jpg");
        
        Produto produto3 = new Produto();
        
        produto3.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto3.setValorunit("230.00");
        produto3.setNome("Placa Mãe A");
        produto3.setCodigo("3");
        produto3.setDesconto("0");
        produto3.setImagem("img/gigabyte.jpg");
        
        Produto produto4 = new Produto();
        
        produto4.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto4.setValorunit("230.00");
        produto4.setNome("Placa Mãe B");
        produto4.setCodigo("4");
        produto4.setDesconto("0");
        produto4.setImagem("img/asus.jpg");
        
        Produto produto5 = new Produto();
        
        produto5.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto5.setValorunit("230.00");
        produto5.setNome("Placa de Vídeo A");
        produto5.setCodigo("5");
        produto5.setDesconto("0");
        produto5.setImagem("img/nvidia.jpg");
        
        Produto produto6 = new Produto();
        
        produto6.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto6.setValorunit("230.00");
        produto6.setNome("Placa de Vídeo B");
        produto6.setCodigo("6");
        produto6.setDesconto("0");
        produto6.setImagem("img/geforce.jpg");
        
        Produto produto7 = new Produto();
        
        produto7.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto7.setValorunit("230.00");
        produto7.setNome("Memoria para Notebook");
        produto7.setCodigo("7");
        produto7.setDesconto("0");
        produto7.setImagem("img/Memoria-de-Notebook.jpg");
        
        Produto produto8 = new Produto();
        
        produto8.setDescricao("Lorem ipsum dolor sit amet, consectetur adipisicing elit.");
        produto8.setValorunit("230.00");
        produto8.setNome("Memoria Kingston");
        produto8.setCodigo("8");
        produto8.setDesconto("0");
        produto8.setImagem("img/prd_kingston.jpg");
        
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
        produtos.add(produto5);
        produtos.add(produto6);
        produtos.add(produto7);
        produtos.add(produto8);
    

       
/* USUARIOS DO SISTEMA */

/*Usuario usuario1 = new Usuario();
        
        usuario1.setId(1L);
        usuario1.setLogin("ze");
        usuario1.setSenha("1234");
        usuario1.setTipo("PF");
        usuarios.add(usuario1);
       
        Usuario usuario2 = new Usuario();
        
        usuario2.setId(2L);
        usuario2.setLogin("ford");
        usuario2.setSenha("1234");
        usuario2.setTipo("PJ");
        usuarios.add(usuario2);*/
        
/* PESSOAS FISICAS */

        /*PessoaFisica pf1 = new PessoaFisica();
        
        pf1.setIdusuario(1L);
        pf1.setNome("José Silva");
        pf1.setCpf("1234");    
        pf1.setAcesso("ADM");
        pf1.setUsuario(usuario1);
        pfs.add(pf1);*/
        
/* PESSOAS JURIDICAS */
        
        /*PessoaJuridica pj1 = new PessoaJuridica();
        
        pj1.setIdusuario(2L);
        pj1.setRazaoSocial("Ford S/A");
        pj1.setCnpj("1234");
        pj1.setUsuario(usuario2);
        pjs.add(pj1); */   
    }
    
    public void inserirProduto(Produto produto) {
        produtos.add(produto);
    }
    
    public void inserirUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void inserirPessoaFisica(PessoaFisica pessoaFisica) {
        pfs.add(pessoaFisica);
    }
    
    public void inserirPessoaJuridica(PessoaJuridica pessoaJuridica) {
        pjs.add(pessoaJuridica);
    }
}
