#!/bin/sh

cp "$1" tmp_"$1"

java RemoveComments "$1"

rm tmp_"$1"
