
package Model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;


@Entity
@SequenceGenerator(name="local_seq", sequenceName="local_seq", allocationSize=1,initialValue=1)

public class Item implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="local_seq")
    private Long iditem;
    @Transient
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    private int quantidade = 1;
    private double subtotal;
    @OneToMany(mappedBy = "item")
    @JoinColumn(referencedColumnName = "iditem")
    private List<Produto> produtos;
    
    @ManyToOne(cascade=CascadeType.MERGE)
    private Compra compra;
    

    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    
    public Long getIditem() {
        return iditem;
    }

    
    public void setIditem(Long iditem) {
        this.iditem = iditem;
    }

    
    public int getQuantidade() {
        return quantidade;
    }

    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    public double getSubtotal() {
        
        double valorUnitario = Double.parseDouble(produto.getValorunit());
        
        return valorUnitario * quantidade;
    }

    
    public void setSubtotal(double subtotal) {
        this.subtotal = CalcularSubTotal();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.iditem);
        hash = 13 * hash + this.quantidade;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.subtotal) ^ (Double.doubleToLongBits(this.subtotal) >>> 32));
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
        final Item other = (Item) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.subtotal) != Double.doubleToLongBits(other.subtotal)) {
            return false;
        }
        if (!Objects.equals(this.iditem, other.iditem)) {
            return false;
        }
        return true;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

   
    public Compra getCompra() {
        return compra;
    }

   
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    public Double CalcularSubTotal(){
        Produto produto = new Produto();
        Double sub;
        sub = (Double.parseDouble(produto.getValorunit())-Double.parseDouble(produto.getDesconto()))*Double.parseDouble(produto.getQuantidade());
        return sub;
        
    }
    
    public void incrementarQuantidade() {
        quantidade++;
    }
    
    public void decrementarQuantidade() {
        quantidade--;
    }

    
}
