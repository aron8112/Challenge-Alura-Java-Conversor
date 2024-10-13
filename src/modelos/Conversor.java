package modelos;

import httpControl.ApiResponse;
import httpControl.ExchangeRateAPI;
import users.Conversion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conversor {
  private Moneda monedaOrigen;
  private Moneda monedaDestino;
  private double monto;
  private Historial historial;
  ExchangeRateAPI api;


  // Constructor
  public Conversor() {
    this.monedaOrigen = null;
    this.monedaDestino = null;
    this.monto = 0;
    this.historial = new Historial();
    this.api = new ExchangeRateAPI();
  }


  // Getters y Setters
  public Moneda getMonedaOrigen() {
    return monedaOrigen;
  }

  public void setMonedaOrigen(Moneda monedaOrigen) {
    this.monedaOrigen = monedaOrigen;
  }

  public Moneda getMonedaDestino() {
    return monedaDestino;
  }

  public void setMonedaDestino(Moneda monedaDestino) {
    this.monedaDestino = monedaDestino;
  }

  public double getMonto() {
    return monto;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  // Método para mostrar los detalles de la conversión
  public void mostrarConversion() {
    if (monedaOrigen == null || monedaDestino == null || monto < 0) {
      System.out.println("Por favor, asegúrese de seleccionar las monedas y el monto correctamente.");
      return;
    }

    if (monedaOrigen != null && monedaDestino != null && monto > 0) {
      System.out.println("Obteniendo tasa de cambio entre " + monedaOrigen.getCodigo() + " y " + monedaDestino.getCodigo() + "...");

      // Crear una instancia de ExchangeRateAPI y obtener la tasa de cambio

      ApiResponse tasaCambio = api.obtenerTasaCambio(monedaOrigen.getCodigo(), monedaDestino.getCodigo(), getMonto());

      Conversion conversion = new Conversion(
          monedaOrigen.getNombre(),
          monedaDestino.getNombre(),
          monto, LocalDateTime.now()
      );
      conversion.setMontoConvertido(tasaCambio.conversion_result());
      conversion.setTasaDeCambio(tasaCambio.conversion_rate());
      System.out.println(conversion);

      historial.agregarConversion(conversion.conversionToJSON());
      historial.guardarNuevaConversion();
//      System.out.println(historial);

    } else {
      System.out.println("Por favor, asegúrese de seleccionar tanto la moneda de origen como la moneda de destino, e ingresar un monto válido.");
    }
  }
}
