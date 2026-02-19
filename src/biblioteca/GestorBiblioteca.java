package biblioteca;

import biblioteca.Ecepciones.LibroNoDisponibleException;
import biblioteca.Ecepciones.PrestamoInvalidoException;
import biblioteca.Ecepciones.UsuarioRepetidoException;
import biblioteca.Ecepciones.UsuarioSancionadoException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class GestorBiblioteca {
  private final int Max_USUARIOS = 50;
  private final int MAX_PRESTAMOS = 200;

  private int numeroUsuarios;
  private Usuario[] usuarios;

  private int numeroPrestamos;
  private Prestamo[] prestamos = new Prestamo[numeroPrestamos];

  public GestorBiblioteca() {
    numeroPrestamos = 0;
    numeroUsuarios = 0;
    Prestamo[] prestamos = new Prestamo[MAX_PRESTAMOS];
    Usuario[] usuarios = new Usuario[Max_USUARIOS];
  }

  public void registrarUsuario(Usuario u) throws UsuarioRepetidoException {
    for (int i = 0; i < usuarios.length; i++) {
      if (Objects.equals(u.getNumeroSocio(), usuarios[i].getNumeroSocio())) {
        throw new UsuarioRepetidoException("el usuario ya esta registrado");
      }
    }
    usuarios[numeroUsuarios] = u;
    numeroUsuarios++;

  }

  public Prestamo realizarPrestamo(String codigoLibro, String tituloLibro, Usuario socio, LocalDate fechaPrestamo) throws PrestamoInvalidoException,UsuarioSancionadoException,LibroNoDisponibleException {

      Prestamo p=new Prestamo(codigoLibro,tituloLibro,socio,fechaPrestamo);
      numeroPrestamos++;
      return p;
  }
  public boolean devolverLibro(String codigoLibro,
                               LocalDate fechaDevolucionReal,
                               Usuario esteUsuario) {

    for (int i = 0; i < prestamos.length; i++) {

      Prestamo p = prestamos[i];

      if (p != null &&
        p.getCodigoLibro().equalsIgnoreCase(codigoLibro) &&
        p.getFechaDevolucionReal() == null) {

        // Registrar devolución
        p.setFechaDevolucionReal(fechaDevolucionReal);

        // Comprobar retraso
        if (fechaDevolucionReal.isAfter(p.getFechaDevolucionPrevista())) {

          long diasRetraso = ChronoUnit.DAYS.between(
            p.getFechaDevolucionPrevista(),
            fechaDevolucionReal);

          esteUsuario.sancionar((int) diasRetraso);
        }

        return true;
      }
    }

    return false;
  }
  public Usuario buscarUsuario(String numeroSocio){
    for (int i = 0; i < usuarios.length; i++) {
   if (usuarios[i].getNumeroSocio().equals(numeroSocio)){
     return usuarios[i];}

  }
    return null;
}


  public Prestamo[] getPrestamos() {
    return prestamos;
  }

  public Usuario[] getUsuarios() {
    return usuarios;
  }

  @Override
  public String toString() {
    return usuarios.toString()+prestamos.toString();
  }
}
