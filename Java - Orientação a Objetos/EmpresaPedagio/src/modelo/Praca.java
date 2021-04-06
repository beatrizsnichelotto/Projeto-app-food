package modelo;

import java.io.Serializable;
import java.util.Set;

import persistencia.Guarita;

public class Praca implements Serializable {
    

    private Concessionaria concessionaria;
    private String cidade;
    private Double totalRecebido;
    private Set<Guarita> guaritas;
    private Set<Tarifa> tarifas;
    
    public Concessionaria getConcessionaria() {
        return this.concessionaria;
    }

    public void setConcessionaria(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getTotalRecebido() {
        return this.totalRecebido;
    }

    public void setTotalRecebido(Double totalRecebido) {
        this.totalRecebido = totalRecebido;
    }

    public Set<Guarita> getGuaritas() {
        return this.guaritas;
    }

    public void setGuaritas(Set<Guarita> guaritas) {
        this.guaritas = guaritas;
    }

    public Set<Tarifa> getTarifas() {
        return this.tarifas;
    }

    public void setTarifas(Set<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }














}
