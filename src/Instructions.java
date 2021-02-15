import javax.swing.*;
import java.awt.*;

public class Instructions extends JFrame {

    private JButton volver;
    private JTextArea Info;

    public Instructions() {
        setLayout(new BorderLayout());

        JPanel sur = new JPanel(new GridLayout(3, 1, 10, 10));

        Info = new JTextArea("Esto es un generador de contraseñas sirve para generar contraseñas aleatoriamente,\n" +
                "para que funcione el generador tienes que desplazar barra deslizadora," +
                " que pone 'Deslizame' y luego  \n" +
                "seleccionas una o varias opciones y pulsas el boton  generar contraseña ");

        add(sur);

        add(Info);

        setSize(600, 150);
        setVisible(true);
    }

    public static void main() {
        new Instructions();
    }
}