package biblioteca;
import biblioteca.Ecepciones.UsuarioInvalidoException;

import java.time.LocalDate;
import java.util.Scanner;
public class mainBiblioteca {
  public static void main(String[] args) {
    int opcion=0;
     Scanner in=new Scanner(System.in);
    System.out.println(
      "1. Registrar nuevo usuario  \n" +
      "2. Realizar préstamo de libro  \n" +
      "3. Devolver libro  \n" +
      "4. Consultar estado de usuario  \n" +
      "5. Mostrar préstamos activos  \n" +
      "6. Mostrar usuarios sancionados  \n" +
      "7. Actualizar sanciones \n" +
      "8. Salir ");
 try {
   GestorBiblioteca gb= new GestorBiblioteca();
   switch (opcion<8) {

     case 1:
       System.out.println(" introduce nombre");
        String nombre= in.nextLine();
       System.out.println("introduce email");
       String email= in.nextLine();
       System.out.println("introduce numero socio");
       String  numeroSocio=in.nextLine();
       LocalDate fechaRegistro=LocalDate.now();
       Usuario usuariomM =new Usuario( nombre,email,numeroSocio,fechaRegistro);
       GestorBiblioteca gb=new GestorBiblioteca();
       gb


     }
       break;
     case 2:
       gb.realizarPrestamo();

       break;
     case 3:
       break;
     case 1:
       break;
     case 1:
       break;
     case 1:
       break;
     case 1:
       break;
     case 1:
       break;
   }

 }
  }
}
