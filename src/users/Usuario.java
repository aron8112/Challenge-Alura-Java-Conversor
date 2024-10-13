package users;

public class Usuario {
  private String nombre;
  private String email;

  public Usuario(String nombre, String email) {
    this.nombre = nombre;
    this.email = email;
  }

  public String getNombre() {
    return nombre;
  }

  public String getEmail() {
    return email;
  }

  public String getIdentificador() {
    // Si hay email disponible, se usa; sino se usa el nombre
    return email != null && !email.isEmpty() ? email : nombre;
  }
}
