package biblioteca;

import java.time.*;

public class Prestamo {
  private  String codigoLibro;
  private  String tituloLibro;
  private Usuario socio;
  private LocalDate fechaPrestamo;
  private LocalDate fechaDevolucionPrevista;
  private LocalDate getFechaDevolucionreal;

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
   Period calculoD= P.between()
 }

}
