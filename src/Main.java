import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

class ExchangeResponse {
    String base_code;
    Map<String, Double> conversion_rates;
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String apiKey = "TU_API_KEY_AQUI"; // Agrega aquí tu clave de forma local
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";

        try {
            boolean continuar = true;

            while (continuar) {
                System.out.println("\n*******************************");
                System.out.println("    Menú de Conversión");
                System.out.println("*******************************");
                System.out.println("1) Dólar      => Peso mexicano");
                System.out.println("2) Peso mexicano => Dólar");
                System.out.println("3) Dólar      => Real brasileño");
                System.out.println("4) Real brasileño => Dólar");
                System.out.println("5) Dólar      => Peso colombiano");
                System.out.println("6) Peso colombiano => Dólar");
                System.out.println("7) Salir");
                System.out.print("\nElija una opción válida: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                String base = "";
                String destino = "";

                switch (opcion) {
                    case 1:
                        base = "USD";
                        destino = "MXN";
                        break;
                    case 2:
                        base = "MXN";
                        destino = "USD";
                        break;
                    case 3:
                        base = "USD";
                        destino = "BRL";
                        break;
                    case 4:
                        base = "BRL";
                        destino = "USD";
                        break;
                    case 5:
                        base = "USD";
                        destino = "COP";
                        break;
                    case 6:
                        base = "COP";
                        destino = "USD";
                        break;
                    case 7:
                        continuar = false;
                        System.out.println("\n Gracias por usar el conversor. ¡Hasta pronto!");
                        continue;
                    default:
                        System.out.println(" Opción no válida.");
                        continue;
                }

                // Construir URL con moneda base seleccionada
                String consultaUrl = url + base;

                // Solicitar a la API
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(consultaUrl))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Guardar JSON una sola vez si quieres (opcional)
                FileWriter writer = new FileWriter("tasa_exchange.json");
                writer.write(response.body());
                writer.close();

                Gson gson = new Gson();
                ExchangeResponse data = gson.fromJson(response.body(), ExchangeResponse.class);

                if (!data.conversion_rates.containsKey(destino)) {
                    System.out.println(" Moneda destino no encontrada en la API.");
                    continue;
                }

                double tasa = data.conversion_rates.get(destino);

                System.out.print("Ingrese el valor que deseas convertir: ");
                double cantidad = scanner.nextDouble();

                double convertido = cantidad * tasa;

                System.out.printf(" %.2f %s equivalen a %.2f %s\n",
                        cantidad, base, convertido, destino);
            }

        } catch (Exception e) {
            System.out.println(" Error al consultar la API: " + e.getMessage());
        }
    }
}
