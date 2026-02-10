package biblioteca;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Prestamo {
  private  String codigoLibro;
  private  String tituloLibro;
  private Usuario socio;
  private LocalDate fechaPrestamo;
  private LocalDate fechaDevolucionPrevista;
  private LocalDate fechaDevolucionReal;

  public Prestamo(String codigoLibro,String tituloLibro,Usuario socio,LocalDate fechaPrestamo){
    this.codigoLibro=codigoLibro;
    this.tituloLibro=tituloLibro;
    this.socio=socio;
    this.fechaPrestamo=fechaPrestamo;
    this.fechaDevolucionPrevista=fechaPrestamo.plusDays(14);
  }
  private void registrarDevolucion(LocalDate otraFecha){
   // tiene PrestamoInvalidoException.
    boolean  comparar =otraFecha.isBefore(fechaPrestamo);

  }
 private int  calcularDiasRetraso(){
  return   (int)ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucionReal);

 }
   private boolean estaRetrasado() {
     return fechaDevolucionPrevista.isBefore(LocalDate.now());
   }

  @Override
  public String toString() {
    System.out.println(
                          "codigoLibro: "+codigoLibro+
                           "Titulo :" +tituloLibro+
                            socio.getNumeroSocio() +socio+
                            "fechaPrestamo" +fechaPrestamo+
                             "fechaDevolucionPrevista: "+fechaDevolucionPrevista

    );

  }
}


