/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Agenda;
import modelo.Paciente;
import modelo.Secretario;

/**
 *
 * @author José Alcantara
 */
public class Registro {
        public boolean Agregar(Agenda agenda) {
            Date hora, fecha; 
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            fecha = agenda.getFecha();
            hora = agenda.getHora();
            String query = "INSERT INTO libro(titulo, autor, publicacion, precio, disponible) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, agenda.getTitulo());
            stmt.setString(2, agenda.getAutor());
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4, agenda.getPrecio());
            stmt.setBoolean(5, agenda.isDisponible());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar libro" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar libro" + e.getMessage());
            return false;
        }
    }
        
        public boolean Registrar(Secretario secretario) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();
            
            String query = "INSERT INTO secretario(rut, nombre, clave) VALUES (?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, secretario.getRut());
            stmt.setString(2, secretario.getNombre());
            stmt.setString(3, secretario.getClave());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar libro " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar libro " + e.getMessage());
            return false;
        }
    }
    public Secretario iniciarSesion(String rut) {
        Secretario user = new Secretario();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT rut, clave FROM secretario WHERE rut = BINARY ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, rut);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user.setRut(rs.getString("rut"));
                user.setClave(rs.getString("clave"));
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al encontrar usuario " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al encontrar usuario " + e.getMessage());
        }
        return user;
    }
        
        
    public boolean eliminar(int id_agenda) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM libro WHERE idlibro=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_agenda);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar libro" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar libro" + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Agenda agenda) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "UPDATE libro set titulo = ?, autor = ?, publicacion = ?, precio = ?, disponible = ? WHERE idlibro=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setDate(3, new java.sql.Date(libro.getPublicacion().getTime()));
            stmt.setInt(4, libro.getPrecio());
            stmt.setBoolean(5, libro.isDisponible());
            stmt.setInt(6, libro.getIdLibro());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar libro" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al actualizar libro" + e.getMessage());
            return false;
        }
    }

    public Libro buscarPorId(int idLibro) {
        Libro libro = new Libro();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT idlibro, titulo, autor, publicacion, precio, disponible FROM libro WHERE idlibro=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, idLibro);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                libro.setIdLibro(rs.getInt("idlibro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setPublicacion(rs.getDate("publicacion"));
                libro.setPrecio(rs.getInt("precio"));
                libro.setDisponible(rs.getBoolean("disponible"));

            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar libro por id" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar libro por id" + e.getMessage());
        }
        return libro;
    }

    public List<Libro> buscarTodos() {
        List<Libro> lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT , numerochasis, marca_id, tranmision, precio FROM vehiculo order by numerochasis";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("idlibro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setPublicacion(rs.getDate("publicacion"));
                libro.setPrecio(rs.getInt("precio"));
                libro.setDisponible(rs.getBoolean("disponible"));

                lista.add(libro);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar libros" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar libros" + e.getMessage());
        }
        return lista;
    }
}
