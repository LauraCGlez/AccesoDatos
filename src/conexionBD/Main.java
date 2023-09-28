package conexionBD;
public class Main {
    public static void main(String[] args) {

        Connector connector = new Connector();

        connector.consultarAlumnosMayoresDe(17);

        connector.actualizarEdadAlumno("Fabian", 20);

        connector.eliminarAlumnosPorEscuela("Conalep Texcoco");

        connector.cerrarConexion();
    }

}