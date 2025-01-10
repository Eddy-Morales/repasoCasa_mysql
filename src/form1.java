import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 {
    private JTextField textField_nombre;
    private JTextField textField_apellido;
    private JButton ingresar_btn;
    private JLabel titulo_lbl;
    private JLabel nombre_lbl;
    private JLabel apellido_lbl;
    public JPanel mainPanel;
    public JPanel panelMain;

    public form1() {

        // Acción del botón Ingresar
        ingresar_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos de texto
                String nombre = textField_nombre.getText();
                String apellido = textField_apellido.getText();

                // Abrir el form2 con los datos ingresados
                new form2(nombre, apellido);

                ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();

            }
        });
    }
}


