package visao;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;


public class JCelula extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPeca jPeca;

    private int linha, coluna;

    public JCelula(int linha, int coluna) {
        this.setLinha(linha);
        this.setColuna(coluna);
    
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public JPeca getjPeca() {
        return jPeca;
    }

    public void setjPeca(JPeca jPeca) {
        this.jPeca = jPeca;
    }

    public JCelula(JPeca jPeca) {
        this.setjPeca(jPeca);
        this.setLinha(jPeca.getPeca().getLinha());
        this.setColuna(jPeca.getPeca().getColuna());
        this.add(jPeca);
        if  ((jPeca.getPeca() != null) && jPeca.getPeca().isSelecionada()) {
            this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        }      
    }
    
}
