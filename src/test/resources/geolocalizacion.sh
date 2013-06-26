#!/bin/bash


usage()
{
cat << EOF
uso: $0 opciones

Este script geolocaliza tiendas Movistar cargadas previamente en BBDD
Genera un fichero output.sql con los comandos SQL y un fichero running.log
que registra la actividad del script


OPCIONES:
   -h  Ayuda
   -p  [ROOFTOP|RANGE_INTERPOLATED|APPROXIMATE]    Precision maxima admitida (por defecto, RANGE_INTERPOLATED)
   -s  Recalcula latitud y longitud de todas las tiendas
   -m  Considera multiples posiciones por tienda. No recomendado
EOF
}


M=0
S=0
P=RANGE_INTERPOLATED

while getopts “hp:ms” OPTION
do
     case $OPTION in
         h)
             usage
             exit 1
             ;;
         M)
             M=1
             ;;
         s)
             S=1
             ;;
         p)
             P=$OPTARG
             ;;
         
         ?)
             usage
             exit
             ;;
     esac
done


argument=""
if [ $M -eq 1 ];then
	argument="$argument -m" 
fi

if [ $S -eq 1 ];then
	argument="$argument -s" 
fi

a="$argument -p $P" 

echo "Localizando tiendas con precision maxima $P ..."
echo "Generando ficheros output.sql y running.log ..."
java -Dhttp.proxyHost=127.0.0.1 -Dhttp.proxyPort=8118  -jar geolocalizacion-1.0.jar $argument com.prosodie.geolocalizacion.GeolocalizacionMain 1>output.sql 2> running.log
