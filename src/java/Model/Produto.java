
package Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name="local_seq", sequenceName="local_seq", allocationSize=1,initialValue=1)
public class Produto implements Serializable {
  
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="local_seq")
    private Long idproduto;
    private String descricao;
    private String descricaoCurta;
    private String tipo;
    private String marca;
    private String valorunit;
    private String nome;
    private String codigo;
    private String desconto;
    private String imagem;
    private String quantidade;
    private String quantidadeMinima;

    @ManyToOne(cascade=CascadeType.MERGE)
    private Item item;

 
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    
    public Long getIdproduto() {
        return idproduto;
    }

    
    public void setIdproduto(Long idproduto) {
        this.idproduto = idproduto;
    }

   
    public String getDescricao() {
        return descricao;
    }

    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public String getImagem() {
        return imagem;
    }

    
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    
   
    public Item getItem() {
        return item;
    }

    
    public void setItem(Item item) {
        this.item = item;
    }

    
    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    
    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

   
    public String getTipo() {
        return tipo;
    }

    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String getMarca() {
        return marca;
    }

    
    public void setMarca(String marca) {
        this.marca = marca;
    }

   
    public String getQuantidadeMinima() {
        return quantidadeMinima;
    }

   
    public void setQuantidadeMinima(String quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    
    public String getValorunit() {
        return valorunit;
    }

    public void setValorunit(String valorunit) {
        this.valorunit = valorunit;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.idproduto);
        hash = 13 * hash + Objects.hashCode(this.descricao);
        hash = 13 * hash + Objects.hashCode(this.descricaoCurta);
        hash = 13 * hash + Objects.hashCode(this.tipo);
        hash = 13 * hash + Objects.hashCode(this.marca);
        hash = 13 * hash + Objects.hashCode(this.valorunit);
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.codigo);
        hash = 13 * hash + Objects.hashCode(this.desconto);
        hash = 13 * hash + Objects.hashCode(this.imagem);
        hash = 13 * hash + Objects.hashCode(this.quantidade);
        hash = 13 * hash + Objects.hashCode(this.quantidadeMinima);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.descricaoCurta, other.descricaoCurta)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.valorunit, other.valorunit)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.desconto, other.desconto)) {
            return false;
        }
        if (!Objects.equals(this.imagem, other.imagem)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.quantidadeMinima, other.quantidadeMinima)) {
            return false;
        }
        if (!Objects.equals(this.idproduto, other.idproduto)) {
            return false;
        }
        return true;
    }

   
   
  
}
