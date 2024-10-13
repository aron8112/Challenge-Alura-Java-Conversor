# Proyecto de Conversión de Monedas

Este repositorio contiene un proyecto Java que realiza la conversión de monedas utilizando la API [ExchangeRate-API](https://www.exchangerate-api.com/). A continuación, se describen los pasos necesarios para configurar el ambiente, crear el proyecto, consumir la API, analizar la respuesta JSON, filtrar las monedas y mostrar los resultados a los usuarios.

## 1. Creación del Proyecto

1. Iniciar un nuevo proyecto Java en el IDE seleccionado.
2. Configurar las dependencias necesarias, como bibliotecas para realizar peticiones HTTP (ej. `HttpURLConnection`, `HttpClient` o librerías externas como `OkHttp`).
3. Añadir las clases y métodos necesarios para la conversión de monedas y el consumo de la API.

## 2. Consumo de la API (ExchangeRate-API)

1. Registrar una cuenta en [ExchangeRate-API](https://www.exchangerate-api.com/) y obtener una clave de API.
2. Configurar el endpoint para obtener las tasas de cambio:
   Sustituir `YOUR-API-KEY` por la clave generada durante el registro.
3. Implementar el método para realizar la petición HTTP al endpoint `.../v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT` y recibir la respuesta en formato JSON.

## 3. Análisis de la Respuesta JSON

1. Parsear la respuesta JSON utilizando `Gson`.
2. Extraer las tasas de cambio y otras informaciones relevantes como la fecha de actualización y la moneda base.
3. Gestionar posibles errores en la respuesta, como tasas no disponibles o claves de API inválidas.

## 4. Filtro de Monedas

1. Implementar un filtro para que los usuarios puedan seleccionar entre 196 monedas de origen y destino.
2. Asegurarse de que solo se muestren las monedas soportadas por la API.
3. Ofrecer una lista de opciones predefinidas o permitir búsquedas dinámicas dentro del conjunto de monedas disponibles. 

## 5. Exhibición de Resultados a los Usuarios

El usuario podrá ver: monto consultado, convertido y la tasa de cambio. 
