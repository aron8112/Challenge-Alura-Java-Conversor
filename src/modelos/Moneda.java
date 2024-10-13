package modelos;

public class Moneda {
  private String codigo;
  private String nombre;
  private String pais;

  public Moneda(String codigo, String nombre, String pais) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.pais = pais;
  }

  public String getCodigo() {
    return codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public String getPais() {
    return pais;
  }

  @Override
  public String toString() {
    return codigo + " - " + nombre + " - " + pais;
  }
}

