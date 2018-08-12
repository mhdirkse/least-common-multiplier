#!/bin/bash

HOST=https://credible-nation-130012.appspot.com
arg=$1

url="${HOST}/_ah/api/comGithubMhdirkseWestitLcm/v1/getLeastCommonMultiplier?maxDivisor=${arg}"
echo ${url}

curl \
  -H "Content-Type: application/json" \
  -X GET \
  "${url}"

