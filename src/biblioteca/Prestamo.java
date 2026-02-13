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
  public void registrarDevolucion(LocalDate otraFecha){
    boolean  comparar =otraFecha.isBefore(fechaPrestamo);
    fechaDevolucionReal=otraFecha;

  }
 public int  calcularDiasRetraso(){
  return   (int)ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucionReal);

 }
   public boolean estaRetrasado() {
     return fechaDevolucionPrevista.isBefore(LocalDate.now());
   }

  @Override
  public String toString() {
    return
                          "codigoLibro: "+codigoLibro+
                           "Titulo :" +tituloLibro+
                            socio.getNumeroSocio() +socio+
                            "fechaPrestamo" +fechaPrestamo+
                             "fechaDevolucionPrevista: "+fechaDevolucionPrevista

    ;

  }

  public LocalDate getFechaDevolucionReal() {
    return fechaDevolucionReal;
  }
}


