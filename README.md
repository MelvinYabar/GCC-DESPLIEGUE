# Biblioteca API - Spring Boot

Aplicación REST sencilla para registrar y consultar libros recomendados. Está preparada para ejecutarse desde GitHub Codespaces y demostrarse con Postman, Insomnia u otro cliente REST.

Al abrir la URL principal de la aplicación se muestra un mensaje JSON de bienvenida con las rutas disponibles.

## ¿Qué cumple?

- Aplicación desarrollada con Spring Boot.
- Un método **GET** para consultar libros.
- Un método **POST** para registrar un libro.
- Cada objeto tiene cinco campos: `id`, `titulo`, `autor`, `genero` y `anioPublicacion`.
- Respuestas en formato JSON.
- Configuración para GitHub Codespaces.

> Los datos se almacenan temporalmente en memoria. Al reiniciar la aplicación se recuperan los dos libros iniciales.

## Ejecutar en GitHub Codespaces

1. Subir este proyecto a un repositorio de GitHub.
2. En GitHub, seleccionar **Code > Codespaces > Create codespace on main**.
3. Esperar a que Codespaces termine de preparar el entorno.
4. Abrir una terminal y ejecutar:

```bash
mvn spring-boot:run
```

5. Cuando aparezca `Started BibliotecaApiApplication`, abrir la pestaña **Ports**.
6. En el puerto `8080`, elegir **Port Visibility > Public** si se probará desde Postman o Insomnia instalado en la computadora.
7. Copiar la dirección generada por Codespaces. Se verá parecida a:

```text
https://nombre-del-codespace-8080.app.github.dev
```

### Usar la colección de Postman incluida

1. En Postman, seleccionar **Import**.
2. Importar el archivo `postman/Biblioteca-API.postman_collection.json`.
3. Abrir la colección **Biblioteca API** y cambiar su variable `baseUrl` por la dirección copiada de Codespaces, sin una barra `/` al final.
4. Ejecutar las solicitudes en el orden indicado: GET, POST y nuevamente GET.

## Probar el método GET

- Método: `GET`
- URL local: `http://localhost:8080/api/libros`
- URL en Codespaces: `https://TU-URL-8080.app.github.dev/api/libros`

Respuesta esperada (`200 OK`):

```json
[
  {
    "id": 1,
    "titulo": "El principito",
    "autor": "Antoine de Saint-Exupery",
    "genero": "Fabula",
    "anioPublicacion": 1943
  },
  {
    "id": 2,
    "titulo": "Cien anios de soledad",
    "autor": "Gabriel Garcia Marquez",
    "genero": "Novela",
    "anioPublicacion": 1967
  }
]
```

## Probar el método POST

- Método: `POST`
- URL local: `http://localhost:8080/api/libros`
- URL en Codespaces: `https://TU-URL-8080.app.github.dev/api/libros`
- Encabezado: `Content-Type: application/json`
- En Postman o Insomnia elegir **Body > JSON** y escribir:

```json
{
  "titulo": "1984",
  "autor": "George Orwell",
  "genero": "Distopia",
  "anioPublicacion": 1949
}
```

Respuesta esperada (`201 Created`):

```json
{
  "id": 3,
  "titulo": "1984",
  "autor": "George Orwell",
  "genero": "Distopia",
  "anioPublicacion": 1949
}
```

Después se puede repetir el GET para mostrar que el nuevo libro aparece en la lista.

## Explicación corta para la presentación

1. **Modelo `Libro`:** representa la información que procesa la aplicación. Tiene cinco campos.
2. **Controlador `LibroController`:** recibe las solicitudes en la ruta `/api/libros`.
3. **GET:** devuelve la lista completa de libros en formato JSON.
4. **POST:** recibe un libro en JSON, le asigna un `id`, lo agrega a la lista y devuelve el objeto creado.
5. **Códigos HTTP:** GET responde `200 OK` y POST responde `201 Created`.

## Ejecutar las pruebas automáticas

```bash
mvn test
```
