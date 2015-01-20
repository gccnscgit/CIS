#! /bin/bash

export CLASSPATH=/home/maximus/vSphere/CabrilloCLI/antlr/antlr-4.4-complete.jar

java -Xmx500M org.antlr.v4.Tool "$@"
