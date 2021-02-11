import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainG extends JFrame {
    public JButton GenContrase�a;
    public JLabel contrase�a;

    public MainG() {
        super("Generador De Contrase�as");


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        JPanel Menu = new JPanel();
        Menu.setLayout(new GridLayout(3, 1, 5, 5));
        Menu.add(new JLabel("Contrase�a:"));
        new JLabel("Contrase�a:");


        contrase�a = (new JLabel(""));
        // GenContrase�a.setLayout(new FlowLayout());
        GenContrase�a = new JButton("Generar contrase�a");
        GenContrase�a.addActionListener(new ListenerButton());
        // GenContrase�a.setSize(10,10);


        JPanel opciones = new JPanel();
        opciones.setLayout(new GridLayout(4, 1, 5, 5));
        opciones.add(new Checkbox("MAYUSCULAS"));
        opciones.add(new Checkbox("minusculas"));
        opciones.add(new Checkbox("Numeros"));
        opciones.add(new Checkbox("Simbolos"));

        JPanel LongitudContrase�a = new JPanel();
        JProgressBar progressBar = new JProgressBar();

        JSlider sliderContra;
        LongitudContrase�a.add(sliderContra = new JSlider(JSlider.HORIZONTAL, 0, 20, 5), BorderLayout.PAGE_START);
        JTextField NumContrase�a;
        sliderContra.setBorder(new TitledBorder("Deslizame"));
        progressBar.setModel(sliderContra.getModel());
        LongitudContrase�a.add(NumContrase�a = new JTextField("25"), BorderLayout.SOUTH);
        sliderContra.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int NumberCharac = sliderContra.getValue();
                NumContrase�a.setText(Integer.toString(NumberCharac));
            }
        });

        add(Menu);

        Menu.add(contrase�a);
        Menu.add(GenContrase�a);


        Menu.add(opciones);
//  Menu.add(GenContrase�a);
        Menu.add(LongitudContrase�a);
        JPanel pBar = new JPanel();
        pBar.setLayout(new FlowLayout());
        pBar.add(progressBar);
        progressBar.setSize(10, 10);
        Menu.add(pBar);

        setSize(600, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainG();
    }

    private class ListenerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            contrase�a.setText("prueba");
        }
    }


}

