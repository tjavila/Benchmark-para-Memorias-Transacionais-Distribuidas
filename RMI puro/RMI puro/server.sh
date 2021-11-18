#!/bin/bash

if [ -z $1 ]
then
	N_OBJ=10
else N_OBJ=$1
fi

if [ -z $2 ]
then
	N_MACH=0
else
	N_MACH=$(expr $2 - 1)
fi

for i in $(seq 0 1 $N_MACH);
do
	java ObjetoServer "$i" $N_OBJ &
done
