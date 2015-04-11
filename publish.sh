#!/bin/bash

rm -rf public/site

cp -r groovytutorial/site public/


rsync --delete --progress -ave ssh public/ groovy-tutorial-site:/home/public/