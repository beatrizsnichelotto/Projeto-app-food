package modelo;

import java.io.Serializable;

public class Tarifa implements Serializable {
    


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Categoria categoria;
    private Double valor;
    

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
