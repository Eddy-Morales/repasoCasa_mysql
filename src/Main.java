import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new form1().mainPanel); // Agrega el panel principal de Form1
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 480); // Establece el tamaño del frame
        frame.setPreferredSize(new Dimension(600, 480)); // Tamaño preferido
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.pack(); // Ajusta el tamaño del frame al contenido
        frame.setVisible(true); // Muestra la ventana
    }
}
