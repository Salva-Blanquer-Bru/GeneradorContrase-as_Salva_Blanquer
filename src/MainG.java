import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainG extends JFrame {
    public JButton BtnGenContrase�a;

    public JLabel contrase�a;
    public JSlider sliderContra;
    private JLabel textoSinOpcion;
    private Color darkGreen = new Color(95, 216, 137);

    Button ayuda;

    JRadioButton BtnMayus;
    JRadioButton Btnminus;
    JRadioButton BtnNums;
    JRadioButton BtnSimbs;

    JTextField numeroCaracter;
    JProgressBar pBar;

    private Boolean Mayus = false;
    private Boolean minus = false;
    private Boolean Nums = false;
    private Boolean Simbs = false;

    public MainG() {
        super("Generador De Contrase�as");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel titulo = new JPanel();
        titulo.add(new JLabel("GENERADOR DE CONTRASE�AS"), BorderLayout.CENTER);
        ayuda = (new Button("?"));
        ayuda.addActionListener(new Instruciones());

        JPanel general = new JPanel();
        general.setLayout(new GridLayout(3, 1, 10, 10));
        general.setBorder(new TitledBorder(""));
        general.setBackground(Color.blue);
        this.setResizable(false);

        JPanel VerContrase�a = new JPanel();
        VerContrase�a.setLayout(new GridLayout(1, 2, -50, 5));
        VerContrase�a.add(new JLabel("Contrase�a:"));

        contrase�a = (new JLabel(""));
        contrase�a.setBackground(Color.white);
        VerContrase�a.add(contrase�a);

        JPanel Menu = new JPanel();
        Menu.setLayout(new GridLayout(2, 2, 10, 10));

        Menu.setLayout(new GridLayout(1, 2, 10, 10));
        sliderContra = new JSlider(JSlider.HORIZONTAL, 0, 20, 5);
        sliderContra.setValue(0);
        Menu.add(numeroCaracter = new JTextField("00"), BorderLayout.SOUTH);
        sliderContra.addChangeListener(new seguridad());
        sliderContra.setBorder(new TitledBorder("Deslizame"));
        sliderContra.addChangeListener(new NumContra());
        sliderContra.setMajorTickSpacing(5);
        sliderContra.setPaintTicks(true);
        sliderContra.setPaintLabels(true);

        JPanel barraProgreso = new JPanel();
        barraProgreso.setLayout(new GridLayout(1, 1, 50, 10));
        pBar = new JProgressBar();
        pBar.setModel(sliderContra.getModel());

        JPanel opciones = new JPanel();
        opciones.setLayout(new GridLayout(4, 1, 5, 15));

        BtnMayus = new JRadioButton("Mayusculas");
        BtnMayus.addActionListener(new SeleccionaMayus());
        Btnminus = new JRadioButton("Minusculas");
        Btnminus.addActionListener(new Seleccionaminus());
        BtnNums = new JRadioButton("Numeros");
        BtnNums.addActionListener(new SeleccionaNums());
        BtnSimbs = new JRadioButton("Simbolos");
        BtnSimbs.addActionListener(new SeleccionaSimbs());


        BtnGenContrase�a = new JButton("Generar contrase�a");
        BtnGenContrase�a.addActionListener(new genContrase�a());

        add(titulo);
        titulo.add(ayuda);

        Menu.add(general);
        add(general);

        general.add(VerContrase�a);

        JPanel espacioBlanco = new JPanel();
        textoSinOpcion = new JLabel();
        espacioBlanco.add(textoSinOpcion);

        general.add(espacioBlanco);

        general.add(opciones);

        opciones.add(Btnminus);
        opciones.add(BtnMayus);
        opciones.add(BtnNums);
        opciones.add(BtnSimbs);


        general.add(sliderContra);

        barraProgreso.add(Menu);

        JPanel generarContraBtn = new JPanel();
        generarContraBtn.setLayout(new FlowLayout());
        generarContraBtn.add(BtnGenContrase�a);

        JPanel progressBar = new JPanel();
        progressBar.setLayout(new FlowLayout());
        progressBar.add(pBar);
        pBar.setSize(10, 10);

        general.add(generarContraBtn);
        general.add(progressBar);

        setSize(650, 550);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainG();


    }

    public class genContrase�a implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String letras = "";

            String letrasMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String letrasMinusculas = "abcdefghijklmnopqrstuvwxyz";
            String numeros = "0123456789";
            String simbolos = "!@#!$%&/()=?�@#*]}[{?<>)";

            if (Mayus == true) {
                letras += letrasMayusculas;
            }
            if (minus == true) {
                letras += letrasMinusculas;
            }
            if (Simbs == true) {
                letras += simbolos;
            }
            if (Nums == true) {
                letras += numeros;
            }

            int longitud = sliderContra.getValue();
            String temporal = "";

            StringSelection stringSelection = new StringSelection(contrase�a.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            Random random = new Random();

            for (int i = 0; i < longitud; i++) {
                try {
                    temporal += letras.charAt(random.nextInt(letras.length()));

                } catch (IllegalArgumentException ex) {

                    textoSinOpcion.setText("Selecione alguna opcion");
                    textoSinOpcion.setForeground(Color.red);
                }
            }
            contrase�a.setText(temporal);
        }

    }

    private class SeleccionaMayus implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (BtnMayus.isSelected() == true) {
                textoSinOpcion.setText("");
                Mayus = true;
            } else {
                Mayus = false;
            }
        }
    }

    private class Seleccionaminus implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Btnminus.isSelected() == true) {
                textoSinOpcion.setText("");
                minus = true;
            } else {
                minus = false;
            }
        }
    }

    private class SeleccionaNums implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (BtnNums.isSelected() == true) {
                textoSinOpcion.setText("");
                Nums = true;
            } else {
                Nums = false;
            }
        }
    }

    private class SeleccionaSimbs implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (BtnSimbs.isSelected() == true) {
                textoSinOpcion.setText("");
                Simbs = true;
            } else {
                Simbs = false;
            }
        }
    }

    private static class Instruciones implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Instructions.main();


        }


    }

    private class NumContra implements ChangeListener {


        @Override
        public void stateChanged(ChangeEvent e) {
            int NumberCharac = sliderContra.getValue();
            numeroCaracter.setText(Integer.toString(NumberCharac));
        }

    }

    private class seguridad implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int Cantidad = Integer.parseInt(numeroCaracter.getText());
            if (Cantidad < 5 && BtnMayus.isSelected() == false && Btnminus.isSelected() == true && BtnNums.isSelected() == false && BtnSimbs.isSelected() == false) {

                pBar.setForeground(Color.red);
                pBar.setBorder(new TitledBorder("Insegura"));


            }
            if (Cantidad >= 5 && Cantidad < 10 && BtnMayus.isSelected() == true && Btnminus.isSelected() == true && BtnNums.isSelected() == false && BtnSimbs.isSelected() == false) {

                pBar.setForeground(Color.orange);
                pBar.setBorder(new TitledBorder("Poco segura"));
            }

            if (Cantidad >= 10 && Cantidad < 20 && BtnMayus.isSelected() == true && Btnminus.isSelected() == true && BtnNums.isSelected() == true && BtnSimbs.isSelected() == false) {

                pBar.setForeground(darkGreen);
                pBar.setBorder(new TitledBorder("Segura"));
            }


            if (Cantidad == 20 && BtnMayus.isSelected() == true && Btnminus.isSelected() == true && BtnNums.isSelected() == true && BtnSimbs.isSelected() == true) {

                pBar.setForeground(Color.green);
                pBar.setBorder(new TitledBorder("Muy segura"));

            }
        }
    }

}





