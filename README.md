# NBA Jugadores API - Spring Boot

Aplicación REST sencilla para registrar y consultar jugadores de la NBA. Está preparada para ejecutarse desde GitHub Codespaces y demostrarse con Postman, Insomnia u otro cliente REST.

Al abrir la URL principal se muestra un mensaje JSON de bienvenida con las rutas disponibles.

## ¿Qué cumple?

- Aplicación desarrollada con Spring Boot.
- Un método **GET** para consultar jugadores.
- Un método **POST** para registrar un jugador.
- Cada objeto tiene cinco campos: `id`, `nombre`, `equipo`, `posicion` y `puntosPorPartido`.
- Respuestas en formato JSON.
- Configuración para GitHub Codespaces.

> Los datos se almacenan temporalmente en memoria. Al reiniciar la aplicación se recuperan los dos jugadores iniciales.

## Ejecutar en GitHub Codespaces

1. Abrir el repositorio en GitHub Codespaces.
2. Abrir una terminal y ejecutar:

```bash
mvn spring-boot:run
```

3. Cuando aparezca `Started NbaApiApplication`, abrir la pestaña **Ports**.
4. En el puerto `8080`, elegir **Port Visibility > Public** para probar desde Postman instalado en la computadora.
5. Copiar la dirección generada por Codespaces.

## Usar la colección de Postman

1. En Postman, seleccionar **Import**.
2. Importar `postman/NBA-Jugadores-API.postman_collection.json`.
3. Cambiar la variable `baseUrl` por la dirección de Codespaces, sin una barra `/` al final.
4. Ejecutar las solicitudes en este orden: GET, POST y nuevamente GET.

## Probar el método GET

- Método: `GET`
- URL local: `http://localhost:8080/api/jugadores`
- URL en Codespaces: `https://TU-URL-8080.app.github.dev/api/jugadores`

Respuesta esperada (`200 OK`):

```json
[
  {
    "id": 1,
    "nombre": "Michael Jordan",
    "equipo": "Chicago Bulls",
    "posicion": "Escolta",
    "puntosPorPartido": 30.1
  },
  {
    "id": 2,
    "nombre": "Kobe Bryant",
    "equipo": "Los Angeles Lakers",
    "posicion": "Escolta",
    "puntosPorPartido": 25.0
  }
]
```

## Probar el método POST

- Método: `POST`
- URL: `https://TU-URL-8080.app.github.dev/api/jugadores`
- Encabezado: `Content-Type: application/json`
- Body JSON:

```json
{
  "nombre": "LeBron James",
  "equipo": "Los Angeles Lakers",
  "posicion": "Alero",
  "puntosPorPartido": 27.1
}
```

Respuesta esperada (`201 Created`):

```json
{
  "id": 3,
  "nombre": "LeBron James",
  "equipo": "Los Angeles Lakers",
  "posicion": "Alero",
  "puntosPorPartido": 27.1
}
```

Después se repite el GET para mostrar que LeBron James aparece en la lista.

## Explicación corta para la presentación

1. **`NbaApiApplication`:** inicia la aplicación Spring Boot.
2. **Modelo `Jugador`:** representa los cinco datos que procesa la aplicación.
3. **`JugadorController`:** recibe las solicitudes en `/api/jugadores`.
4. **GET:** devuelve la lista completa de jugadores en formato JSON.
5. **POST:** recibe un jugador, le asigna un `id`, lo agrega a la lista y devuelve el objeto creado.
6. GET responde `200 OK` y POST responde `201 Created`.

## Ejecutar pruebas automáticas

```bash
mvn test
```
