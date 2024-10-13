package users;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import httpControl.ApiResponse;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Conversion  implements Comparable<Conversion>{
  private String monedaOrigen;
  private String monedaDestino;
  private double montoConsultado;
  private double montoConvertido;
  private double tasaDeCambio;
  private LocalDateTime timestamp;

  public Conversion(String monedaOrigen, String monedaDestino, double montoConsultado, LocalDateTime timestamp) {
    this.monedaOrigen = monedaOrigen;
    this.monedaDestino = monedaDestino;
    this.montoConsultado = montoConsultado;
    this.timestamp = timestamp;  // Marca de tiempo automática
  }
  public Conversion(ApiResponse apiResponse){
    this.montoConvertido = montoConvertido;
    this.tasaDeCambio = tasaDeCambio;
  }

  public double getMontoConvertido() {
    return montoConvertido;
  }

  public void setMontoConvertido(double montoConvertido) {
    this.montoConvertido = montoConvertido;
  }

  public String getMonedaOrigen() {
    return monedaOrigen;
  }

  public String getMonedaDestino() {
    return monedaDestino;
  }

  public double getMontoConsultado() {
    return montoConsultado;
  }

  public void setTasaDeCambio(double tasaDeCambio) {
    this.tasaDeCambio = tasaDeCambio;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public String formatNumbers(double number){
    DecimalFormat df = new DecimalFormat("#,###.00");
    return df.format(number);
  }

  public String formatTimestamp() {
    DateTimeFormatter formatterAR = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("es", "AR"));
    return this.timestamp.format(formatterAR);
  }

  @Override
  public String toString() {
    return "Su consulta de cambio:\n - " + monedaOrigen + " a " + monedaDestino + "\n - Monto consultado: $" + formatNumbers(this.montoConsultado) + "\n - Tasa de cambio: "+ String.valueOf(this.tasaDeCambio) +".\n - Monto Convertido: $"+formatNumbers(this.montoConvertido)+". \n - Fecha: " + formatTimestamp();
  }

  @Override
  public int compareTo(Conversion o) {
    return 0;
  }

  public String conversionToJSON(){
    Gson gson = new Gson();
    Map<String, String> conversionMap = new LinkedHashMap<>();
    conversionMap.put("monedaOrigen", this.monedaOrigen);
    conversionMap.put("monedaDestino", this.monedaDestino);
    conversionMap.put("montoConsultado",  formatNumbers(this.montoConsultado));
    conversionMap.put("montoConvertido",  formatNumbers(this.montoConvertido));
    conversionMap.put("tasaDeCambio",  String.valueOf(this.tasaDeCambio));
    conversionMap.put("timestamp",  String.valueOf(this.timestamp));

    return gson.toJson(conversionMap);
  }
}
