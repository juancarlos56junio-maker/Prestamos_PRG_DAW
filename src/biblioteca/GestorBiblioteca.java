package biblioteca;

import biblioteca.Ecepciones.LibroNoDisponibleException;
import biblioteca.Ecepciones.PrestamoInvalidoException;
import biblioteca.Ecepciones.UsuarioRepetidoException;
import biblioteca.Ecepciones.UsuarioSancionadoException;

import java.time.LocalDate;
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

  public void realizarPrestamo(String codigoLibro, String tituloLibro, Usuario socio, LocalDate fechaPrestamo) throws PrestamoInvalidoException,UsuarioSancionadoException,LibroNoDisponibleException {

      return Prestamo P=new Prestamo(codigoLibro,tituloLibro,socio,fechaPrestamo);
      numeroPrestamos++;
  }
public void devolverLibro(String codigoLibro,LocalDate fechaDevolucionPrevista,Usuario esteUsuario){
   for (int i;i< MAX_PRESTAMOS; i++){

     if (esteUsuario.estaSancionado=false)

   }
}


  public Prestamo[] getPrestamos() {
    return prestamos;
  }

  public Usuario[] getUsuarios() {
    return usuarios;
  }

}
