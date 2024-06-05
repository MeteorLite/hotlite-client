#!/bin/bash

set -e -x

cd ../
git clone https://github.com/Ethan-Vann/EthanVannPlugins
cd EthanVannPlugins
chmod a+x ./gradlew
./gradlew build publishToMavenLocal
