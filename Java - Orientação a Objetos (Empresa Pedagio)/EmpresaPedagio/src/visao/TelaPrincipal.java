package visao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private final JButton btConsultar;
    private final JButton btRelatorio = new JButton("Relatório");
    private final JButton btConfiguracoes = new JButton("Configurações");
    private final JLabel lbRodape = new JLabel("Aula 03 de Java");

    private final JButton btPracas = new JButton("Praças");
    private final JButton btTarifas = new JButton("Tarifas");
    private final JButton btCategorias = new JButton("Categorias");
    private final JButton btEncerrar = new JButton("Encerrar");

    private final JTextField tfValor = new JTextField(10);

    public TelaPrincipal() {
        btConsultar  = new JButton("Consultar");

        setTitle("Sistema de Gestão de Pedágios");
        setSize(400, 250);
        getContentPane().setLayout(new BorderLayout());
        final JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new GridLayout(1,3));
        painelSuperior.add(btConsultar);
        painelSuperior.add(btRelatorio);
        painelSuperior.add(btConfiguracoes);
        getContentPane().add(painelSuperior, BorderLayout.NORTH);
        getContentPane().add(lbRodape, BorderLayout.SOUTH);


        final JPanel painelDireita = new JPanel();
        painelDireita.setLayout(new GridLayout(4,1));
        painelDireita.add(btPracas);
        painelDireita.add(btTarifas);
        painelDireita.add(btCategorias);
        painelDireita.add(btEncerrar);

        getContentPane().add(painelDireita, BorderLayout.EAST);

       /* tbDados.setModel(new javax.swing.table.DefaultTableModel(
        new Object [] [] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},

        },

        new String[] {"Código", "Nome", "Valores"}

    )); */

        getContentPane().add(tfValor, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btEncerrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);               
            }

        });

        btPracas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    TelaPracas tPracas = TelaPracas.getInstancia();
                    tPracas.setVisible(true);       
            }

        });

        btTarifas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try{
               Integer numero = Integer.valueOf (tfValor.getText());
               Integer dobro = numero * 2;
               JOptionPane.showMessageDialog(null, "O valor é " + dobro);
             } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(null, "Apenas números são aceitos neste campo!");
                tfValor.requestFocus();
                tfValor.selectAll();
                }
            }
   });
}
}
