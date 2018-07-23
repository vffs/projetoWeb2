
package Model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(referencedColumnName="idendereco")
@SequenceGenerator(name="local_seq", sequenceName="local_seq", allocationSize=1,initialValue=1)
public abstract class Usuario implements Serializable {

    

    private static long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="local_seq")
    @Id
    private Long idusuario;
    private String login;
    private String senha;
    private String email;
    private String tipo;
    private String acesso;
    private String nome;
    @OneToOne
    private Endereco endereco;  
    @OneToOne
    @JoinColumn(referencedColumnName = "idtelefone")        
    private Telefone telefone;
    private List<Mensagem> mensagems;
    @JoinColumn(referencedColumnName ="idusuario")
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

   
    public Long getIdusuario() {
        return idusuario;
    }

    
    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

  
    public String getLogin() {
        return login;
    }

    
    public void setLogin(String login) {
        this.login = login;
    }

    
    public String getSenha() {
        return senha;
    }

    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String getAcesso() {
        return acesso;
    }

   
    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.idusuario);
        hash = 47 * hash + Objects.hashCode(this.login);
        hash = 47 * hash + Objects.hashCode(this.senha);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + Objects.hashCode(this.acesso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.acesso, other.acesso)) {
            return false;
        }
        if (!Objects.equals(this.idusuario, other.idusuario)) {
            return false;
        }
        return true;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Mensagem> getMensagems() {
        return mensagems;
    }

    
    public void setMensagems(List<Mensagem> mensagems) {
        this.mensagems = mensagems;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

   
    public List<Compra> getCompras() {
        return compras;
    }

    
    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdUsuario(long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
