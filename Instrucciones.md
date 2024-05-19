# Instrucciones

## Para hacer funcionar la Aplicación correctamente

### Scripts

Para que los scripts funcionen correctamente hay que darle permisos de ejecución, si no, estos no funcionarán y la aplicacion se cerrará al momento de ejecutar la acción que utilice estos mismos. Para darles permiso  de ejcucion, ejecutar el siguiente comando en la carpeta raiz del proyecto:

```bash
sudo chmod +x *.sh
```

### Carga de datos

En la raiz del proyecto encontrarás un archivo .sql donde están las creaciones de las tablas y las vistas, también están todos los inserts.
Para ejecutarlo hay que abrir la extension en VSCode de MariaDB y conectarse a la base de datos con el usuario root después de haber hecho `docker compose up`. Abrir una nueva **Query**, pegar el .sql y ejecutarlo
