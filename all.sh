#!/bin/sh

# Groovyのパスは任意の位置に変更して使用してください
export GROOVY_HOME=$HOME/dev/groovy/groovy-2.2.1
export PATH=$PATH:$GROOVY_HOME/bin

CURRENT=$(cd $(dirname $0); pwd)

export CLASSPATH=$CURRENT/src/main/groovy:$CURRENT/lib/commons-cli-1.2.jar:$CURRENT/lib/guava-14.0.1.jar:$CURRENT/lib/velocity-1.7-dep.jar
env

# -t テーブル名
groovy  src/main/groovy/ermtool/Ermtool.groovy \
  -i input/test.erm \
  -o file
