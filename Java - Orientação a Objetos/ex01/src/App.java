import javax.swing.JOptionPane;

public class App  {
  


 public static void main(String[] args) {

    Produto produto01 = new Produto();
    produto01.setCodigo(1);
    produto01.setDescricao("Fone de ouvido");
    produto01.setPrecoVenda(80.00); 
    produto01.setPrecoCusto(40.00);
    produto01.setSaldoEstoque(5);

    Produto produto02 = new Produto();
    produto02.setCodigo(5);
    produto02.setDescricao("Mouse");
    produto02.setPrecoVenda(40.00);
    produto02.setPrecoCusto(20.00);
    produto02.setSaldoEstoque(1);

    JOptionPane.showMessageDialog(null, "O produto é " + produto01.getDescricao() + " - Saldo: " + produto01.getSaldoEstoque());

    JOptionPane.showMessageDialog(null, "O produto é " + produto02.getDescricao() + " - Saldo: " + produto02.getSaldoEstoque());

    produto01.vender(1.0); // ENCAPSULAMENTO
    produto02.alterarPreco(100.0);

    JOptionPane.showMessageDialog(null,  produto01.getDescricao() + " - Saldo: " + produto01.getSaldoEstoque() + " - " + produto01.getPrecoVenda());
    
    JOptionPane.showMessageDialog(null,  produto01.getDescricao() + " - Saldo: " + produto02.getSaldoEstoque() + " - " + produto02.getPrecoVenda());

}

    }

    
 