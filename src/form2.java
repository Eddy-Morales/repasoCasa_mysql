import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class form2 extends JFrame {
    private JLabel bienvenida;
    private JTable table1;
    private JPanel panelMain;

    public form2(String nombre, String apellido) {
        // Configuración del JFrame
        setTitle("Clientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Inicializar componentes
        panelMain = new JPanel(new BorderLayout());
        bienvenida = new JLabel("Bienvenido " + nombre + " " + apellido, SwingConstants.CENTER);
        table1 = new JTable();

        // Agregar componentes al panel principal
        panelMain.add(bienvenida, BorderLayout.NORTH);
        panelMain.add(new JScrollPane(table1), BorderLayout.CENTER);

        // Agregar panel principal al JFrame
        add(panelMain);

        // Llenar la tabla con datos de la base de datos
        cargarDatosEnTabla();

        // Hacer visible la ventana
        setVisible(true);
    }

    private void cargarDatosEnTabla() {
        String url = "jdbc:mysql://localhost:3306/repaso3"; // Cambia 'repaso3' por tu base de datos
        String user = "root"; // Cambia esto si tu usuario es diferente
        String password = "Samuel2000"; // Cambia tu contraseña

        // Consulta SQL para obtener todos los datos de la tabla clientes
        String query = "SELECT * FROM clientes";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            // Crear el modelo para la JTable
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ClienteID");
            model.addColumn("Nombre");
            model.addColumn("Apellidos");
            model.addColumn("FechaNacimiento");
            model.addColumn("Telefono");
            model.addColumn("Correo");

            // Llenar el modelo con los datos del ResultSet
            while (resultSet.next()) {
                Object[] fila = new Object[6];
                fila[0] = resultSet.getInt("ClienteID");
                fila[1] = resultSet.getString("Nombre");
                fila[2] = resultSet.getString("Apellidos");
                fila[3] = resultSet.getDate("FechaNacimiento");
                fila[4] = resultSet.getString("Telefono");
                fila[5] = resultSet.getString("Correo");
                model.addRow(fila);
            }

            // Asignar el modelo a la JTable
            table1.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectar o consultar la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

