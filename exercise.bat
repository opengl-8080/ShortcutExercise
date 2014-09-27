@echo off

set THIS_DIR=%~dp0
set THIS_DIR=%THIS_DIR:~,-1%
set SRC_DIR=%THIS_DIR%\src
set CLASSPATH=%SRC_DIR%

call groovy -Dpreset.dir="%THIS_DIR%" "%SRC_DIR%\Main.groovy"



