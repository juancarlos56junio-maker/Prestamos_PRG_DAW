package biblioteca;

import biblioteca.Ecepciones.UsuarioInvalidoException;

import java.time.LocalDate;

public class Usuario {
  private  String nombre;
  private String email;
  private String  numeroSocio;
  private LocalDate fechaRegistro;
  private boolean sancionado ;
  private LocalDate fechaFinSancion;
  public   Usuario (String nombre, String email, String  numeroSocio, LocalDate fechaRegistro) throws UsuarioInvalidoException {
    this.nombre=nombre;
    this.email=email;
    this.numeroSocio=numeroSocio;
    this.fechaRegistro=fechaRegistro;
  }
  public String getNumeroSocio() {
    return numeroSocio;
  }



  public void sancionar(int dias) {

    LocalDate inicioSancion = LocalDate.of(2021, 7, 7); // 7 julio 2021
    this.fechaFinSancion = inicioSancion.plusDays(dias);   // sanción de 5 días
  }
  public void levantarSancion() {
    this.fechaFinSancion = null;
  }
  public boolean estaSancionado(){
    return sancionado;
  }

  @Override
  public String toString() {
    return
                    "nombre: "+nombre +
                     "email: "+email +
                      "numeroSocio: " + numeroSocio +
                      "fecha registro: "+fechaRegistro+
                      "usuario correctamente registrado"+
                        "\n"+
                        "usuario creado correctamente"
    ;
  }
}
