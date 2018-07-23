
package Model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;


@Entity
@SequenceGenerator(name="local_seq", sequenceName="local_seq", allocationSize=1,initialValue=1)

public class Compra implements Serializable {

     private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="local_seq")
    private Long idcompra;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datacompra;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date horacompra;
    private String status;
    private Double valorTotal;
    
    @OneToMany(mappedBy = "compra")
    @JoinColumn(referencedColumnName = "idcompra")
    private List<Item> items;
    @ManyToOne(cascade=CascadeType.MERGE)
    private Usuario usuario;
    
    
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
     public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    
    
    public Long getIdcompra() {
        return idcompra;
    }
    
        public void setIdcompra(Long idcompra) {
        this.idcompra = idcompra;
    }

    
    public Date getDatacompra() {
        return datacompra;
    }
    
     public void setDatacompra(Date datacompra) {
        this.datacompra = datacompra;
    }

    
    public Date getHoracompra() {
        return horacompra;
    }
    
     public void setHoracompra(Date horacompra) {
        this.horacompra = horacompra;
    }


    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Double getValorTotal() {
        return valorTotal;
    }
    
     public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idcompra);
        hash = 19 * hash + Objects.hashCode(this.datacompra);
        hash = 19 * hash + Objects.hashCode(this.horacompra);
        hash = 19 * hash + Objects.hashCode(this.status);
        hash = 19 * hash + Objects.hashCode(this.valorTotal);
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
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.idcompra, other.idcompra)) {
            return false;
        }
        if (!Objects.equals(this.datacompra, other.datacompra)) {
            return false;
        }
        if (!Objects.equals(this.horacompra, other.horacompra)) {
            return false;
        }
        if (!Objects.equals(this.valorTotal, other.valorTotal)) {
            return false;
        }
        return true;
    }

   
    public List<Item> getItems() {
        return items;
    }

    
    public void setItems(List<Item> items) {
        this.items = items;
    }

        public Usuario getUsuario() {
        return usuario;
    }

    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double CalcularTotal(){
        Item item =new Item();
        Double total=item.CalcularSubTotal();
        return total;
    }

    
}