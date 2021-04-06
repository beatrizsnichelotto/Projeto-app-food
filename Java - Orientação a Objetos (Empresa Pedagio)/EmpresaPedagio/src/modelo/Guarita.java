package modelo;

import java.io.Serializable;

public class Guarita implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected int numero;
    protected int veiculos;
    protected Praca praca;
    protected Double valorRecebido;

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVeiculos() {
        return this.veiculos;
    }

    public void setVeiculos(int veiculos) {
        this.veiculos = veiculos;
    }

    public Praca getPraca() {
        return this.praca;
    }

    public void setPraca(Praca praca) {
        this.praca = praca;
    }

    public Double getValorRecebido() {
        return this.valorRecebido;
    }

    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }


}