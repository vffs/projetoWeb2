package Model;

import java.util.List;

public class Carrinho {
    
    private Usuario usuario;
    private List<Item> itens;

    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public List<Item> getItens(){
        return itens;
    }
    
    public void setItens(List<Item> itens){
        this.itens = itens;
    }
    
    public void adicionarItem(Item item) 
    { 
       itens.add(item);
    }
    
    public void removerItem(Item item) 
    {
       itens.remove(item);      
    }

    public double getValorTotal(){
        double valor = 0;
        for (Item item : itens) {
            valor = valor + (item.getSubtotal());
        }
        return valor;
    }
    
    public String getTotalDeItens() {
    
        int totalDeItens = 0;
        
        for (int i = 0; i < this.itens.size(); i++) {
        
            totalDeItens = totalDeItens + itens.get(i).getQuantidade();
        }
        
        return Integer.toString(totalDeItens);
        
    }
       

}
