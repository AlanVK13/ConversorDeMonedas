# 💱 Conversor de Monedas - Proyecto Java

Este es un proyecto Java que implementa un conversor de divisas utilizando la API pública [ExchangeRate-API](https://www.exchangerate-api.com/).  
El objetivo es permitir a los usuarios convertir entre diferentes monedas de forma sencilla desde la consola, aprovechando herramientas modernas como `HttpClient`, `Gson` y manejo de archivos.

---

## 📌 Descripción del Proyecto

Este conversor permite al usuario seleccionar entre diferentes tipos de cambio (USD ⇄ MXN, USD ⇄ BRL, USD ⇄ COP, etc.) desde un **menú interactivo en consola**.  
El programa se conecta en tiempo real a una API para obtener las tasas actualizadas y realiza las conversiones solicitadas. Además, guarda los datos obtenidos en un archivo `.json`.

---

## ✅ Funcionalidades

- Menú interactivo con 6 conversiones disponibles y una opción de salida.
- Lectura y escritura de archivos `.json`.
- Conversión de divisas utilizando tasas en tiempo real.
- Integración con API REST usando `HttpClient`.
- Uso de la biblioteca `Gson` para deserializar JSON.
- Loop que permite realizar múltiples conversiones hasta que el usuario decida salir.

---

## 🚀 ¿Cómo usar este proyecto?

1. Clona este repositorio o descarga el código fuente.
2. Asegúrate de tener instalado **JDK 17 o superior**.
3. Agrega la biblioteca **Gson** al classpath del proyecto (si usas IntelliJ o Eclipse).
4. Obtén tu APIKEY desde [ExchangeRate-API](https://www.exchangerate-api.com/) y colócala en el archivo `Main.java`:
   ```java
 ---
 
## 🛠 Tecnologías utilizadas

Java 17 

HttpClient (para solicitudes HTTP)

Gson (para manejo de JSON)

Scanner (para entrada del usuario)

FileWriter (para guardar el JSON localmente)

API: https://www.exchangerate-api.com/

---

## ❓ ¿Dónde obtener ayuda?

Puedes consultar la documentación oficial de ExchangeRate-API.

Para problemas con la biblioteca Gson: https://github.com/google/gson

Para dudas relacionadas con la lógica del programa, puedes escribirme directamente.

---

## 👤 Autores

Nombre completo: Alan Valadez

Correo electrónico: alanvaladez665@gmail.com

LinkedIn: https://www.linkedin.com/in/alan-valadez-17074a216/

![image](https://github.com/user-attachments/assets/247edb04-520c-4c06-8979-6a4d0d9cb82b)



