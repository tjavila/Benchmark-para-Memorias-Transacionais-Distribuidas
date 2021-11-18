#!/bin/bash

echo $N_TRANS

if [ -z $1 ]
then
	N_TRANS=100
else N_TRANS=$1
fi

echo $N_OBJ

if [ -z $2 ]
then
	N_OBJ=100
else
	N_OBJ=$2
fi

echo $RW 

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

echo $N_CLIENT


if [ -z $6 ]
then
	N_SERVER=2
else
	N_SERVER=$(expr $6 - 1)
fi

echo $N_SERVER

echo $N_OBJETO_SERVER

if [ -z $7 ]
then
	N_OBJETO_SERVER=10
else
	N_OBJETO_SERVER=$7
fi

echo $N_ITER

if [ -z $8 ]
then
	N_ITER=100
else
	N_ITER=$(expr $8 - 1)
fi

if [ -z $9 ]
then
	N_REP=10
else
	N_REP=$(expr $9 - 1)
fi

for i in $(seq 0 1 $N_SERVER);
do
	java -cp "cglib.jar;." put/benchmark/ObjetoServer $i $N_OBJETO_SERVER &
done

for i in $(seq 0 1 $N_CLIENT);
do
	java -cp "cglib.jar;." put/benchmark/ObjetoClient $N_TRANS $N_OBJ $RW $N_MACH $N_ITER $N_REP &
done