## **4 - INSTRUCCIONES**

### Instrucciones para el correcto funcionamiento de la aplicación.

#### **Scripts**

Para que los scripts funcionen correctamente hay que darle permisos de ejecución, si no, estos no funcionarán y la aplicación se cerrará al momento de ejecutar la acción que los utilice. Para darles permiso  de ejecución, ejecutar el siguiente comando en la carpeta raíz del proyecto:

```bash
sudo chmod +x *.sh
```

> Los script están codificados para la shell zsh, si se tiene una shell bash, fish o cualquier otra, se debe modificar el script para su correspondiente shell.

#### **Carga de datos**

En la carpeta sql del proyecto encontrarás un archivo .sql donde están las creaciones de las tablas y las vistas (SCRIPT_BASE_DE_DATOS), junto a todos los inserts.

Si no se cargan los datos al iniciar el contenedor, hay que abrir la extension en VSCode de MariaDB y conectarse a la base de datos con el usuario root, después de haber hecho `docker compose up`. Abrir una nueva **Query**, pegar el .sql y ejecutarlo.

#### Dar de alta Empleados y Productos desde ficheros.

Los ficheros .csv y .json (tanto de Productos como de Empleados)  se encuentran en la carpeta **/ficherosDarAlta** ubicada en la raíz del proyecto.

---

[INDEX](../../index.html)