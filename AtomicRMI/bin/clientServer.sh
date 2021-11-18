#!/bin/bash

if [ -z $1 ]
then
	N_TRANS=10
else N_TRANS=$1
fi

if [ -z $2 ]
then
	N_OBJ=10
else
	N_OBJ=$2
fi

if [ -z $3 ]
then
	RW=50
else
	RW=$3
fi

if [ -z $4 ]
then
	N_MACH=1
else
	N_MACH=$4
fi

if [ -z $5 ]
then
	N_CLIENT=2
else
	N_CLIENT=$(expr $5 - 1)
fi

if [ -z $6 ]
then
	N_SERVER=2
else
	N_SERVER=$(expr $6 - 1)
fi

if [ -z $7 ]
then
	N_OBJETO_SERVER=10
else
	N_OBJETO_SERVER=$7
fi


for i in $(seq 0 1 $N_SERVER);
do
	java -cp "cglib.jar;." put/benchmark/ObjetoServer $i "$N_OBJETO_SERVER" &
done

for i in $(seq 0 1 $N_CLIENT);
do
	java -cp "cglib.jar;." put/benchmark/ObjetoClient "$N_TRANS" "$N_OBJ" "$RW" "$N_MACH" &
done