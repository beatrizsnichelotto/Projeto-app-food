package visao;

import modelo.Peca;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class JPeca extends JLabel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


private Peca peca;

public JPeca(Peca peca) {
    this.peca = peca;
    this.setIcon(new ImageIcon(peca.getImagem()));

 }

public Peca getPeca() {
     return this.peca;
 }
    
}
