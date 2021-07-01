#!/usr/bin/env bash
set -e

LB=
PW=


for i in {1..10}
do
  URL="$LB/rest/v2/caches/xsiteCache/$i"
  DATA="data-$i"
  curl -XPOST  -u developer:$PW -d $DATA $URL --insecure
done