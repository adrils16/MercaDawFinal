## **6 - SCRIPT DE COPIA DE SEGURIDAD**

Abrimos terminal y creamos una carpeta donde se vayan a depositar los backup de la base de datos (Destino).

Creamos otra carpeta donde vamos a tener nuestro script que generara copias de seguridad y las exportara en formato zip con el nombre de backup y la fecha del mismo.


![alt text](/images/scriptcopia.png)


Damos permiso de ejecución con el comando chmod +x .


![alt text](/images/permisos.png)


Por ultimo ejecutamos el comando crontab -e y ponemos cada cuanto tiempo(minutos,hora,dia,mes y dia de la semana) queremos que se ejecute nuestro script.


![alt text](/images/crontab.png)

---

[INDEX](../../index.html)