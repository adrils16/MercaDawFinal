#!/bin/zsh

mvn exec:java -Dexec.mainClass="es.tiernoparla.daw.mercadaw.CopiaSeguridad"

ORIGEN="backup/"
DESTINO="/home/rodri/CopiaSeguridadMercaDaw/"

DATE=$(date +%Y-%m-%d_%H-%M-%S)
FICHERO="backup_$DATE.zip"

zip -r "$DESTINO/$FICHERO" "$ORIGEN"

