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
import modelo.Medico;
import modelo.Paciente;
import modelo.Secretario;

/**
 *
 * @author José Alcantara
 */
public class Registro {
        public boolean Agendamiento(Agenda agenda) {
            Date hora, fecha; 
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            fecha = agenda.getFecha();
            String query = "INSERT INTO Agenda(id, nom_paciente, nom_medico, rut_med, fecha, hora, secretario_rut, paciente_rut) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, agenda.getId());
            stmt.setString(2, agenda.getNom_paciente());
            stmt.setString(3, agenda.getNom_medico());
            stmt.setString(4, agenda.getRut_med());
            stmt.setDate(5, new java.sql.Date(fecha.getTime()));
            stmt.setString(6, agenda.getHora());
            stmt.setString(7, agenda.getSecretario_rut());
            stmt.setString(8, agenda.getPaciente_rut());


            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar agendamiento" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar Agendamiento" + e.getMessage());
            return false;
        }
    }
        public boolean agregarPaciente(Paciente paciente) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "INSERT INTO paciente (rut, nombre, edad, condicion, agenda_id) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, paciente.getRut());
            stmt.setString(2, paciente.getNombre());
            stmt.setInt(3, paciente.getEdad());
            stmt.setString(4, paciente.getCondicion());
            stmt.setInt(5, paciente.getAgenda_id());


            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al agregar paciente" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar paciente" + e.getMessage());
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
    
    public Medico encontrarMed(String nombreMedico) {
        Medico user = new Medico();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT rut FROM medico WHERE nombre = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nombreMedico);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user.setRut(rs.getString("rut"));
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al encontrar rut de medico " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al encontrar rut de medico " + e.getMessage());
        }
        return user;
    }        
    
    public int cantidadAgendas(){
        Agenda user = new Agenda();
        List ids = new ArrayList();
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT id FROM agenda";
            PreparedStatement stmt = cnx.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                ids.add(user.getId());
            }

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al encontrar rut de medico " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al encontrar rut de medico " + e.getMessage());
        }
        return ids.size();
    }
        
    public boolean eliminar(int id_agenda) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "DELETE FROM agenda WHERE id=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_agenda);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar agendamiento" + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al eliminar agendamiento" + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Agenda agenda) {
        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "UPDATE libro set titulo = ?, autor = ?, publicacion = ?, precio = ?, disponible = ? WHERE idlibro=?";
            PreparedStatement stmt = cnx.prepareStatement(query);

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

    public List<String> buscarMedicos(String condicion) {
        List<String> lista;
        lista = new ArrayList<>();

        try {
            Conexion conexion1 = new Conexion();
            Connection cnx = conexion1.obtenerConexion();

            String query = "SELECT nombre FROM  medico where especialidad = ? ";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, condicion);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String marca = rs.getString("nombre");
                lista.add(marca);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar medico " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al listar medico " + e.getMessage());
        }
        return lista;
    }
}
