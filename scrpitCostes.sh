#!/bin/zsh
docker run --rm --volume $(pwd):/data --user $(id -u):$(id -g) pandoc/extra costes.md -o costes.pdf
