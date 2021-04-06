
public class Produto {
   
    private Integer codigo;

    private String descricao;

    private double precoVenda;

    private double precoCusto;

    private double saldoEstoque;

    public void vender(double quantidadeVendida) { //não retorna nenhuma informação
        saldoEstoque = saldoEstoque - quantidadeVendida;

    }

    public  void alterarPreco(double novoPrecoCusto) {
        precoCusto = novoPrecoCusto;
        precoVenda = precoCusto * 1.50;
    }


    public void setCodigo(Integer codigo) {
    this.codigo = codigo;
    }
    public Integer getCodigo() {
    return this.codigo;
    }

    public void setDescricao(String descricao) {
    this.descricao = descricao;
    }
    public String getDescricao() {
    return this.descricao;
    }

    public void setPrecoVenda(double precoVenda) {
    this.precoVenda = precoVenda;
    }
    public double getPrecoVenda() {
    return this.precoVenda;
    }

    public void setPrecoCusto(double precoCusto) {
    this.precoCusto = precoCusto;
    }
    public double getPrecoCusto() {
    return this.precoCusto;
    }

    public void setSaldoEstoque(double saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }
    public double getSaldoEstoque() {
        return this.saldoEstoque;
    }
}

