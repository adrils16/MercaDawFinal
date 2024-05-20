#!/bin/zsh
#Modificar /zsh por la shell correspondiente

docker run --rm --volume $(pwd):/data --user $(id -u):$(id -g) pandoc/extra nomina.md -o nomina.pdf

rm nomina.md
