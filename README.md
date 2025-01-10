import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/repaso3"; // Cambia 'repaso3' por tu base de datos
        String user = "root"; // Cambia esto si tu usuario es diferente
        String password = "Samuel2000"; // Cambia tu contraseña

        // ID del cliente que deseas consultar
        int clienteID = 1; // Cambia este valor según el cliente que quieras buscar

        // Consulta SQL para obtener la información del cliente
        String query = "SELECT * FROM clientes WHERE ClienteID = ?";

        // Usamos try-with-resources para gestionar los recursos
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Asignar el ID del cliente al parámetro de la consulta
            ps.setInt(1, clienteID);

            // Ejecutar la consulta
            ResultSet resultSet = ps.executeQuery();

            // Procesar los resultados
            if (resultSet.next()) {
                System.out.println("ClienteID: " + resultSet.getInt("ClienteID"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Apellidos: " + resultSet.getString("Apellidos"));
                System.out.println("FechaNacimiento: " + resultSet.getDate("FechaNacimiento"));
                System.out.println("Telefono: " + resultSet.getString("Telefono"));
                System.out.println("Correo: " + resultSet.getString("Correo"));
            } else {
                System.out.println("No se encontró un cliente con el ID: " + clienteID);
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar o consultar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
