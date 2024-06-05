#!/bin/bash

cd ../
git clone https://github.com/Ethan-Vann/EthanVannPlugins
cd EthanVannPlugins
chmod a+x ./gradlew
./gradlew build publishToMavenLocal
