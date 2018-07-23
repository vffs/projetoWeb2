
package Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Mensagem implements Serializable {

   @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="local_seq")
    private Long idmensagem;
    private static int quantidade;
    private String assunto;
    private String nome;
    private String email;
    private String mensagem;
    private String status;    
   
    @ManyToOne(cascade=CascadeType.MERGE)
    private Usuario usuario;

    
    public Long getIdmensagem() {
        return idmensagem;
    }

    
    public void setIdmensagem(Long idmensagem) {
        this.idmensagem = idmensagem;
    }

    
    public static int getQuantidade() {
        return quantidade;
    }

    
    public static void setQuantidade(int aQuantidade) {
        quantidade = aQuantidade;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getEmail() {
        return email;
    }

   
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getMensagem() {
        return mensagem;
    }

    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    
    public String getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idmensagem);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.mensagem);
        hash = 67 * hash + Objects.hashCode(this.status);
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
        final Mensagem other = (Mensagem) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.idmensagem, other.idmensagem)) {
            return false;
        }
        return true;
    }

    
    public void setStatus(String status) {
        this.status = status;
    }

   
    public Usuario getUsuario() {
        return usuario;
    }

   
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

       
}
