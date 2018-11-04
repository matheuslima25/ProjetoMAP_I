package br.com.bingo.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewMain extends JFrame {

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ViewMain frame = new ViewMain();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public ViewMain() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 350);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    JPanel panel = new JPanel();
    contentPane.add(panel, BorderLayout.NORTH);
    
    JLabel logo = new JLabel("");
    logo.setIcon(new ImageIcon(ViewMain.class.getResource("/logo.png")));
    panel.add(logo);
    
    JPanel panel_1 = new JPanel();
    contentPane.add(panel_1, BorderLayout.SOUTH);
    
    JButton btn01 = new JButton("Vender Cartela");
    panel_1.add(btn01);
    
    JButton btn02 = new JButton("Sorteio");
    panel_1.add(btn02);
  }

}
