#! /bin/bash

export CLASSPATH=./antlr/antlr-4.4-complete.jar
java -Xmx500M org.antlr.v4.Tool "$@"
