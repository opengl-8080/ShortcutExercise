@echo off

set THIS_DIR=%~dp0
set THIS_DIR=%THIS_DIR:~,-1%
set SRC_DIR=%THIS_DIR%\src
set SCRIPT_FILE="%SRC_DIR%\Main.groovy"
set PRESET_DIR="%THIS_DIR%\preset"
set CLASSPATH=%SRC_DIR%

call groovy -Dpreset.dir=%PRESET_DIR% %SCRIPT_FILE%

