package biblioteca;

import biblioteca.Ecepciones.UsuarioRepetidoException;

public class GestorBiblioteca {
 private final  int Max_USUARIOS=50;
  private final  int MaxPRESTAMOS=200;

 private int numeroUsuarios;
 private Usuario[]usuarios;

  private int  numeroPrestamos;
  private Prestamo[] prestamos =new Prestamo[numeroPrestamos];
  public GestorBiblioteca(){
   numeroPrestamos=0;
   numeroUsuarios=0;
   Prestamo[] prestamos =new Prestamo[MaxPRESTAMOS];
    Usuario[]usuarios=new  Usuario[Max_USUARIOS];
  }
  public  registrarUsuario() throws UsuarioRepetidoException {}
}
