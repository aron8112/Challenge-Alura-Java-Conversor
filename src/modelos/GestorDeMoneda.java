package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorDeMoneda {
  private Map<String, List<Moneda>> monedasPorContinente;

  public GestorDeMoneda() {
    monedasPorContinente = new HashMap<>();
    inicializarMonedas();
  }

  private void inicializarMonedas() {
    // Monedas de África
    List<Moneda> monedasAfrica = new ArrayList<>();
    monedasAfrica.add(new Moneda("AOA", "Angolan Kwanza", "Angola"));
    monedasAfrica.add(new Moneda("BIF", "Burundian Franc", "Burundi"));
    monedasAfrica.add(new Moneda("CDF", "Congolese Franc", "Democratic Republic of the Congo"));
    monedasAfrica.add(new Moneda("DJF", "Djiboutian Franc", "Djibouti"));
    monedasAfrica.add(new Moneda("DZD", "Algerian Dinar", "Algeria"));
    monedasAfrica.add(new Moneda("EGP", "Egyptian Pound", "Egypt"));
    monedasAfrica.add(new Moneda("ETB", "Ethiopian Birr", "Ethiopia"));
    monedasAfrica.add(new Moneda("GHS", "Ghanaian Cedi", "Ghana"));
    monedasAfrica.add(new Moneda("KES", "Kenyan Shilling", "Kenya"));
    monedasAfrica.add(new Moneda("LSL", "Lesotho Loti", "Lesotho"));
    monedasAfrica.add(new Moneda("LYD", "Libyan Dinar", "Libya"));
    monedasAfrica.add(new Moneda("MAD", "Moroccan Dirham", "Morocco"));
    monedasAfrica.add(new Moneda("MGA", "Malagasy Ariary", "Madagascar"));
    monedasAfrica.add(new Moneda("MWK", "Malawian Kwacha", "Malawi"));
    monedasAfrica.add(new Moneda("MUR", "Mauritian Rupee", "Mauritius"));
    monedasAfrica.add(new Moneda("NGN", "Nigerian Naira", "Nigeria"));
    monedasAfrica.add(new Moneda("RWF", "Rwandan Franc", "Rwanda"));
    monedasAfrica.add(new Moneda("SCR", "Seychellois Rupee", "Seychelles"));
    monedasAfrica.add(new Moneda("SLE", "Sierra Leonean Leone", "Sierra Leone"));
    monedasAfrica.add(new Moneda("SOS", "Somali Shilling", "Somalia"));
    monedasAfrica.add(new Moneda("SZL", "Eswatini Lilangeni", "Eswatini"));
    monedasAfrica.add(new Moneda("TND", "Tunisian Dinar", "Tunisia"));
    monedasAfrica.add(new Moneda("XAF", "Central African CFA Franc", "CEMAC"));
    monedasAfrica.add(new Moneda("XOF", "West African CFA franc", "CFA"));
    monedasAfrica.add(new Moneda("ZAR", "South African Rand", "South Africa"));
    monedasAfrica.add(new Moneda("ZMW", "Zambian Kwacha", "Zambia"));
    monedasAfrica.add(new Moneda("ZWL", "Zimbabwean Dollar", "Zimbabwe"));

    monedasPorContinente.put("África", monedasAfrica);

    // Monedas de Asia
    List<Moneda> monedasAsia = new ArrayList<>();
    monedasAsia.add(new Moneda("AED", "UAE Dirham", "United Arab Emirates"));
    monedasAsia.add(new Moneda("AFN", "Afghan Afghani", "Afghanistan"));
    monedasAsia.add(new Moneda("AMD", "Armenian Dram", "Armenia"));
    monedasAsia.add(new Moneda("BDT", "Bangladeshi Taka", "Bangladesh"));
    monedasAsia.add(new Moneda("BHD", "Bahraini Dinar", "Bahrain"));
    monedasAsia.add(new Moneda("CNY", "Chinese Renminbi", "China"));
    monedasAsia.add(new Moneda("INR", "Indian Rupee", "India"));
    monedasAsia.add(new Moneda("IDR", "Indonesian Rupiah", "Indonesia"));
    monedasAsia.add(new Moneda("ILS", "Israeli New Shekel", "Israel"));
    monedasAsia.add(new Moneda("JPY", "Japanese Yen", "Japan"));
    monedasAsia.add(new Moneda("KWD", "Kuwaiti Dinar", "Kuwait"));
    monedasAsia.add(new Moneda("LKR", "Sri Lanka Rupee", "Sri Lanka"));
    monedasAsia.add(new Moneda("PKR", "Pakistani Rupee", "Pakistan"));
    monedasAsia.add(new Moneda("QAR", "Qatari Riyal", "Qatar"));
    monedasAsia.add(new Moneda("SAR", "Saudi Riyal", "Saudi Arabia"));
    monedasAsia.add(new Moneda("KRW", "South Korean Won", "South Korea"));
    monedasAsia.add(new Moneda("VND", "Vietnamese Đồng", "Vietnam"));

    monedasPorContinente.put("Asia", monedasAsia);

    // Monedas de Europa
    List<Moneda> monedasEuropa = new ArrayList<>();
    monedasEuropa.add(new Moneda("ALL", "Albanian Lek", "Albania"));
    monedasEuropa.add(new Moneda("BAM", "Bosnia and Herzegovina Mark", "Bosnia and Herzegovina"));
    monedasEuropa.add(new Moneda("BGN", "Bulgarian Lev", "Bulgaria"));
    monedasEuropa.add(new Moneda("CHF", "Swiss Franc", "Switzerland"));
    monedasEuropa.add(new Moneda("CZK", "Czech Koruna", "Czech Republic"));
    monedasEuropa.add(new Moneda("DKK", "Danish Krone", "Denmark"));
    monedasEuropa.add(new Moneda("EUR", "Euro", "European Union"));
    monedasEuropa.add(new Moneda("GBP", "Pound Sterling", "United Kingdom"));
    monedasEuropa.add(new Moneda("HUF", "Hungarian Forint", "Hungary"));
    monedasEuropa.add(new Moneda("PLN", "Polish Złoty", "Poland"));
    monedasEuropa.add(new Moneda("RUB", "Russian Ruble", "Russia"));
    monedasEuropa.add(new Moneda("SEK", "Swedish Krona", "Sweden"));

    monedasPorContinente.put("Europa", monedasEuropa);

    // Monedas de América
    List<Moneda> monedasAmerica = new ArrayList<>();
    monedasAmerica.add(new Moneda("ARS", "Argentine Peso", "Argentina"));
    monedasAmerica.add(new Moneda("BRL", "Brazilian Real", "Brazil"));
    monedasAmerica.add(new Moneda("CAD", "Canadian Dollar", "Canada"));
    monedasAmerica.add(new Moneda("CLP", "Chilean Peso", "Chile"));
    monedasAmerica.add(new Moneda("COP", "Colombian Peso", "Colombia"));
    monedasAmerica.add(new Moneda("MXN", "Mexican Peso", "Mexico"));
    monedasAmerica.add(new Moneda("USD", "United States Dollar", "United States"));
    monedasAmerica.add(new Moneda("UYU", "Uruguayan Peso", "Uruguay"));
    monedasAmerica.add(new Moneda("VES", "Venezuelan Bolívar Soberano", "Venezuela"));

    monedasPorContinente.put("América", monedasAmerica);

    // Monedas de Oceanía
    List<Moneda> monedasOceania = new ArrayList<>();
    monedasOceania.add(new Moneda("AUD", "Australian Dollar", "Australia"));
    monedasOceania.add(new Moneda("NZD", "New Zealand Dollar", "New Zealand"));
    monedasOceania.add(new Moneda("FJD", "Fiji Dollar", "Fiji"));

    monedasPorContinente.put("Oceanía", monedasOceania);
  }

  public List<Moneda> obtenerMonedasPorContinente(String continente) {
    return monedasPorContinente.getOrDefault(continente, new ArrayList<>());
  }

  public void mostrarMonedasDisponibles() {
    for (String continente : monedasPorContinente.keySet()) {
      System.out.println("Monedas de " + continente + ":");
      for (Moneda moneda : monedasPorContinente.get(continente)) {
        System.out.println(moneda);
      }
      System.out.println();
    }
  }
}
