package controle;

import java.lang.Runnable;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Color;

import modelo.Tabuleiro;
import visao.JTabuleiro;

public class ControlaTempo implements Runnable {

    
    private JTabuleiro jTabuleiro;

    private int tempoGasto = 0;

    private JProgressBar barraProgresso;

    public ControlaTempo(JProgressBar pbTempo) {
        super();
        this.barraProgresso = pbTempo;
    }

    public void setJtabuleiro(JTabuleiro  jTabuleiro) {
        this.jTabuleiro = jTabuleiro;

    }

    public void zeraCronometro() {
        this.tempoGasto = 0;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1);
                tempoGasto +=1;
                barraProgresso.setValue(tempoGasto);
                if (tempoGasto > 0 && tempoGasto < 5000) {
                    barraProgresso.setForeground(Color.GREEN);
                } else if (tempoGasto >= 5000 & tempoGasto < 8000) {
                    barraProgresso.setForeground(Color.YELLOW);
                } else if (tempoGasto >= 8000) {
                    barraProgresso.setForeground(Color.RED);
                }
                if (tempoGasto >= Tabuleiro.TEMPO_J0GADA) {
                    JOptionPane.showMessageDialog(null, "O jogador " + jTabuleiro.getTabuleiro().getVez() + " perdeu a vez");

                    if (jTabuleiro.getTabuleiro().getPecaSelecionada() != null) {
                        jTabuleiro.getTabuleiro().getPecaSelecionada().setSelecionada(false);
                        jTabuleiro.getTabuleiro().setPecaSelecionada(null);
                    }
                    jTabuleiro.getTabuleiro().inverteVez();
                    jTabuleiro.desenhaTabuleiro();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
        }
    }
    
}
