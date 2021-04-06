package visao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JButton;

import controle.ControlaTempo;
import modelo.Tabuleiro;
import java.awt.BorderLayout;
import modelo.EnumCor;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class JXadrez extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private static JLabel lbVez;
    
    public Tabuleiro tabuleiro;

    private final JButton btReiniciarJogo;
    private final JButton btPassarVez;
    private final ControlaTempo controleTempo;
    private final JTabuleiro jTabuleiro;
    public static final JPanel painelCemiterio = new JPanel();

    public JProgressBar pbTempo;

    public JXadrez() {
        setTitle("Jogo de Xadrez");
        this.setLayout(new BorderLayout());
        pbTempo = new JProgressBar();
        pbTempo.setMinimum(0);
        pbTempo.setMaximum(10000);
        this.controleTempo = new ControlaTempo(pbTempo);
        this.tabuleiro = new Tabuleiro(controleTempo);
        this.jTabuleiro  = new JTabuleiro(tabuleiro);
        controleTempo.setJtabuleiro(jTabuleiro);
        this.add(jTabuleiro, BorderLayout.CENTER);
        
        
        final JPanel pnTopo = new JPanel();
        lbVez = new JLabel ("VEZ DE BRANCO");
        pnTopo.add(lbVez);
        this.add(pnTopo, BorderLayout.NORTH);

        final JPanel pnLateral = new JPanel();
        pnLateral.setLayout(new GridLayout(10,1));
        btReiniciarJogo= new JButton ("Reiniciar Jogo");

        btReiniciarJogo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ev) {
                reiniciaJogo();
            }
        });

    
        painelCemiterio.setLayout(new FlowLayout());
        this.add(painelCemiterio, BorderLayout.EAST);
        btPassarVez = new JButton("Passar a Vez");
        pnLateral.add(btReiniciarJogo);
        pnLateral.add(btPassarVez);

        this.add(pnLateral, BorderLayout.WEST);
        this.add(pbTempo, BorderLayout.SOUTH);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Thread threadTempo = new Thread(controleTempo);
        threadTempo.start();

        this.pack();
        this.setVisible(true);
    }

    private void reiniciaJogo() {
        controleTempo.zeraCronometro();
        this.tabuleiro = new Tabuleiro(controleTempo);
        this.jTabuleiro.setTabuleiro(this.tabuleiro);
        this.jTabuleiro.desenhaTabuleiro();
        setVez(tabuleiro.getVez());

    }

    public static void setVez(final EnumCor corVez) {
        lbVez.setText("VEZ DE: " + corVez);
    }

    public static void main(final String args[]) {
        new JXadrez(); 
     }

}