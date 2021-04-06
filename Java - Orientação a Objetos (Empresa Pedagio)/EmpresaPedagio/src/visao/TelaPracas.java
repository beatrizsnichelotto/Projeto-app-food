package visao;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaPracas extends JFrame {
    
/**
  *
 */

private static final long serialVersionUID = 1L;

    private static TelaPracas instancia;

private TelaPracas() {
    setTitle("Controle de Pracas");  
    setSize (350,180);
    JLabel lbTexto = new JLabel("Tela de Praças");
    getContentPane().add(lbTexto);
}
public static TelaPracas getInstancia() {
    if(instancia == null) {
       instancia = new TelaPracas();
    }
    return instancia;

    }
                    
}
