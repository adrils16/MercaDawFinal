# Modelado

## Entidad relación

![EntidadRelacion](image(2).png)

## Esquema relacional

- Empleado (#ID,Nombre,Apellidos,Categoría,***Sede***)

    FK Sede on delete RESTRICT , on modify CASACDE

- Sede (#Ubicación)

- ProductoSede(***#EAN,#Ubicación***,Stock)

    SE CREA POR RELACION N:M

    FK EAN on delete CASACDE, on modify CASACDE

    FK Ubicación on delete CASACDE, on modify CASACDE

- Producto (#EAN ,Nombre,Marca, Precio , Descripción,Tipo,Altura,Peso,Anchura,IVA)

- Compra (#ID,FechaCompra,***IdCliente***)

    FK IDCLIENTE on delete CASACDE, on Modifify CASCADE

- ProductoCompra(***#EAN,#IDCompra***,cantidad)
  
    SE CREA POR RELACION N:M

    FK EAN on delete CASACDE, on modify CASACDE

    FK Ubicación on delete CASACDE, on modify CASACDE

- Cliente (#ID,Nombre,Apellidos,CodPostal,CorreoElec)
