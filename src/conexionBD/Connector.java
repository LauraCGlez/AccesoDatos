package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {

    private Connection connection;

    public Connector() {
        try {
            String url = "jdbc:mysql://localhost:3306/Alumnos";
            String user = "laura";
            String password = "000103";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Conectado a la base de datos Alumnos");
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
    }

    public void consultarAlumnosMayoresDe(int edad) {
        try {
            String query = "SELECT nombre, escuela FROM Alumnos WHERE edad > ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, edad);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("Alumnos mayores de " + edad + " años:");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String escuela = rs.getString("escuela");
                System.out.println("Nombre: " + nombre + ", Escuela: " + escuela);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar alumnos: " + ex.getMessage());
        }
    }

    public void actualizarEdadAlumno(String nombreAlumno, int nuevaEdad) {
        try {
            String query = "UPDATE Alumnos SET edad = ? WHERE nombre = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, nuevaEdad);
            pstmt.setString(2, nombreAlumno);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Edad de " + nombreAlumno + " actualizada a " + nuevaEdad + " años.");
            } else {
                System.out.println("No se encontró el alumno " + nombreAlumno + " en la base de datos.");
            }

            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la edad: " + ex.getMessage());
        }
    }

    public void eliminarAlumnosPorEscuela(String escuela) {
        try {
            String query = "DELETE FROM Alumnos WHERE escuela = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, escuela);

            int rowsDeleted = pstmt.executeUpdate();

            System.out.println(rowsDeleted + " alumnos eliminados de la escuela '" + escuela + "'.");

            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar alumnos: " + ex.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }

}
