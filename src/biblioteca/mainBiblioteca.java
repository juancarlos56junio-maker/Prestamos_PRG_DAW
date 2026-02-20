package biblioteca;

import biblioteca.Ecepciones.PrestamoInvalidoException;
import biblioteca.Ecepciones.UsuarioInvalidoException;
import biblioteca.Ecepciones.UsuarioRepetidoException;
import biblioteca.Ecepciones.UsuarioSancionadoException;

import java.time.LocalDate;
import java.util.Scanner;

public class MainBiblioteca {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    GestorBiblioteca gb = new GestorBiblioteca();
    int opcion;

    do {
      System.out.println("\n1. Registrar nuevo usuario");
      System.out.println("2. Realizar préstamo de libro");
      System.out.println("3. Devolver libro");
      System.out.println("4. Consultar estado de usuario");
      System.out.println("5. Mostrar préstamos activos");
      System.out.println("6. Mostrar usuarios sancionados");
      System.out.println("7. Actualizar sanciones");
      System.out.println("8. Salir");

      opcion = Integer.parseInt(in.nextLine());

      try {

        switch (opcion) {

          case 1:
            System.out.println("Introduce nombre:");
            String nombre = in.nextLine();

            System.out.println("Introduce email:");
            String email = in.nextLine();

            System.out.println("Introduce número socio:");
            String numeroSocio = in.nextLine();

            Usuario usuario = new Usuario(
              nombre, email, numeroSocio, LocalDate.now());

            gb.registrarUsuario(usuario);
            break;

          case 2:
            System.out.println("Introduce código libro:");
            String codigoLibro = in.nextLine();

            System.out.println("Introduce título libro:");
            String tituloLibro = in.nextLine();

            System.out.println("Introduce número socio:");
            String socioId = in.nextLine();

            Usuario socio = gb.buscarUsuario(socioId);

            gb.realizarPrestamo(
              codigoLibro,
              tituloLibro,
              socio,
              LocalDate.now());

            break;

          case 3:
            System.out.println("Introduce código libro:");
            String codigo = in.nextLine();

            gb.devolverLibro(codigo, LocalDate.now());
            break;

          case 4:
            System.out.println("Introduce número socio:");
            String id = in.nextLine();

            Usuario u = gb.buscarUsuario(id);
            System.out.println(u);
            System.out.println("¿Sancionado? " + u.estaSancionado());
            break;

          case 5:
            System.out.println(gb.getPrestamos());
            break;

          case 6:
            System.out.println("Usuarios sancionados:");
            for (Usuario us : gb.getUsuarios()) {
              if (us.estaSancionado()) {
                System.out.println(us);
              }
            }
            break;

          case 7:
            for (Usuario us : gb.getUsuarios()) {
              if (us.getFechaFinSancion() != null &&
                !LocalDate.now().isBefore(us.getFechaFinSancion())) {
                us.levantarSancion();
              }
            }
            System.out.println("Sanciones actualizadas.");
            break;

          case 8:
            System.out.println("Saliendo...");
            break;

          default:
            System.out.println("Opción no válida.");
        }

      } catch (UsuarioInvalidoException e) {
        System.out.println("Usuario inválido: " + e.getMessage());

      } catch (UsuarioRepetidoException e) {
        System.out.println("Usuario ya registrado.");

      } catch (UsuarioSancionadoException e) {
        System.out.println("El usuario está sancionado.");

      } catch (PrestamoInvalidoException e) {
        System.out.println("Préstamo no válido.");

      } catch (Exception e) {
        System.out.println("Error inesperado: " + e.getMessage());
      }

    } while (opcion != 8);

    in.close();
  }
}

