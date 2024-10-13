package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import users.Conversion;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Historial {
  private List<String> conversiones;

  // Constructor que recibe una lista de conversiones
  public Historial(List<String> conversiones) {
    if (conversiones != null) {
      this.conversiones = new ArrayList<>(conversiones);
    } else {
      this.conversiones = new ArrayList<>();
    }
  }

  // Constructor vacío
  public Historial() {
    this.conversiones = new ArrayList<>();
  }

  // Método para agregar una nueva conversión al historial
  public void agregarConversion(String conversion) {
    this.conversiones.add(conversion);
  }

  // Método para obtener todas las conversiones
  public List<String> obtenerConversiones() {
    return new ArrayList<>(conversiones); // Devolvemos una copia para evitar modificaciones externas
  }

  // Método para obtener el número total de conversiones
  public int obtenerNumeroDeConversiones() {
    return this.conversiones.size();
  }

  @Override
  public String toString() {
    return "Historial{" +
        "conversiones=" + conversiones +
        '}';
  }

  void guardarNuevaConversion(){
    Gson gson = new GsonBuilder().create();
    try {
      FileWriter archivar = new FileWriter("conversion.json", true);
      archivar.write(gson.toJson(conversiones));
      archivar.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

}
