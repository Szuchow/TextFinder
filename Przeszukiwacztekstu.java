
package przeszukiwacztekstu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author KB-J
 */
public class Przeszukiwacztekstu extends JFrame {
    
    public Przeszukiwacztekstu()
    {
        initComponents();
    }
    public void initComponents()
    {
        this.setTitle("Przeszukiwacz Tekstu");
        this.setBounds(300, 300, 300, 200);
        
        panelSzukania.add(znajdz);
        panelSzukania.add(szukany);
        panelSzukania.add(etykietaI);
        panelSzukania.add(zamien);
        panelSzukania.add(etykietaNa);
        panelSzukania.add(nowyTekst);
        
        // obszarTekstowy.selectAll();
        // obszarTekstowy.select(0,10);
        // obszarTekstowy.replaceSelection("lala");
        // obszarTekstowy.append("XDDDDDDD");
        //obszarTekstowy.select(obszarTekstowy.getText().indexOf("test"), WIDTH);
        
        znajdz.addActionListener(new znajdowanieHandler());
        zamien.addActionListener(new zamienianieHandler());
        this.getContentPane().add(obszarPrzewijania, BorderLayout.NORTH);
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(3);
    }
    private class zamienianieHandler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            
            if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())
            obszarTekstowy.replaceRange(nowyTekst.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd());
        }
     
}
    private class znajdowanieHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent ae) {
            
            poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText(), poczatekSzukanego+szukany.getText().length());
            
            System.out.println(poczatekSzukanego);
            
            if(poczatekSzukanego == -1){
            poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText());
        }
            
       
                
            
            if(poczatekSzukanego >= 0 && szukany.getText().length() > 0) {
                obszarTekstowy.requestFocus();
                obszarTekstowy.select(poczatekSzukanego, poczatekSzukanego + szukany.getText().length());
            }
            
        }
        private int poczatekSzukanego = 0;
    }

    private JTextArea obszarTekstowy = new JTextArea("To jest testowy tekst i testowym charakterze", 7, 10);
    private JScrollPane obszarPrzewijania = new JScrollPane(obszarTekstowy);
    
    private JPanel panelSzukania = new JPanel();
    private JButton znajdz = new JButton("Znajdź");
    private JLabel etykietaI = new JLabel("i");
    private JButton zamien = new JButton("Zamień");
    private JLabel etykietaNa = new JLabel("na");
    
    private JTextField nowyTekst = new JTextField(4);
    private JTextField szukany = new JTextField(4);
  
    public static void main(String[] args) {
        
        new Przeszukiwacztekstu().setVisible(true);
       
    }
    
}
