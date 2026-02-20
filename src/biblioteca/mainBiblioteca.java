package biblioteca;
import biblioteca.Ecepciones.UsuarioInvalidoException;

import java.time.LocalDate;
import java.util.Scanner;
public class mainBiblioteca {
  public static void main(String[] args) {
    int opcion=0;
     Scanner in=new Scanner(System.in);
     do{
       System.out.println(

         "1. Registrar nuevo usuario  \n" +
           "2. Realizar préstamo de libro  \n" +
           "3. Devolver libro  \n" +
           "4. Consultar estado de usuario  \n" +
           "5. Mostrar préstamos activos  \n" +
           "6. Mostrar usuarios sancionados  \n" +
           "7. Actualizar sanciones \n" +
           "8. Salir ");
    }

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

       gb.registrarUsuario(usuariomM);


     }
       break;
     case 2:
       System.out.println(" introduce codigo libro ");
       String codigoLibro= in.nextLine();
       System.out.println(" introduce titulo libro");
       String tituloLibro= in.nextLine();
       System.out.println(" introduce codigo del socio");
       String numeroSocio=in.nextLine();
       Usuario socio=gb.buscarUsuario(numeroSocio);
      LocalDate fechaRegistro=LocalDate.now();

      gb.realizarPrestamo(codigoLibro,tituloLibro,socio,fechaRegistro);

       break;
     case 3:
       System.out.println(" introduce codigo libro ");
       String codigoLibro= in.nextLine();
       LocalDate fechaDevolucion=LocalDate.now();
       gb.devolverLibro(codigoLibro,fechaDevolucion);
       break;
     case 4:
       System.out.println(" introduce codigo del socio");
       String numeroSocio=in.nextLine();
       Usuario socio=gb.buscarUsuario(numeroSocio);
       socio.toString()+ socio.estaSancionado()
       break;
     case 5: gb.getPrestamos()
       break;
     case 6:
       for ( Usuario u:gb.getUsuarios()){
         if (u.estaSancionado()==true){ u.toSring;}
       }

       break;
     case 1:
       break;
     case 1:
       break;
   }

 }
  }
}
