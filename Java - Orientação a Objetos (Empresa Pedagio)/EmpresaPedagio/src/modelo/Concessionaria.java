package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Concessionaria implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String nome;
    private Set<Praca> pracas = new HashSet<>();
    private Double totalRecebido;

    public Concessionaria() {
        
    }
    public Concessionaria(Double totalRecebido) {
        this.totalRecebido = totalRecebido;

    }

    public Concessionaria(String nome, Double totalRecebido) {
        this.nome = nome;
        this.totalRecebido = totalRecebido;

    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Praca> getPracas() {
        return this.pracas;
    }

    public void setPracas(Set<Praca> pracas) {
        this.pracas = pracas;
    }

    public Double getTotalRecebido() {
        return this.totalRecebido;
    }

    public void setTotalRecebido(Double totalRecebido) {
        this.totalRecebido = totalRecebido;
    }

    public void adicionarPraca(Praca praca) {
        this.pracas.add(praca);
        this.totalRecebido = 0.0;
        for(Praca p : this.pracas) {
            this.totalRecebido = this.totalRecebido + p.getTotalRecebido();

        }


    }



}
