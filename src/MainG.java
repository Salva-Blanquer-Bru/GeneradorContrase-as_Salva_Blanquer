import javax.swing.*;
import java.awt.*;

public class MainG extends JFrame {

    public MainG() {
        super("Login");


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        JPanel Menu = new JPanel();
        Menu.setLayout(new GridLayout(3, 1, 5, 5));


        JPanel VerContrase�a = new JPanel();
        VerContrase�a.add(new JLabel("Contrase�a:"));
        VerContrase�a.add(new JLabel(), BorderLayout.CENTER);

        JPanel GenContrase�a = new JPanel();
        GenContrase�a.add(new JButton("Generar contrase�a"), BorderLayout.WEST);

        JPanel opciones = new JPanel();
        opciones.add(new Checkbox("MAYUSCULAS"));
        opciones.add(new Checkbox("minusculas"));
        opciones.add(new Checkbox("Numeros"));
        opciones.add(new Checkbox("Simbolos"));


        add(Menu);

        Menu.add(VerContrase�a);

        Menu.add(opciones);

        Menu.add(GenContrase�a);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainG();

    }
}

