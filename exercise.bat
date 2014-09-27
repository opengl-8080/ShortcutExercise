@echo off

set THIS_DIR=%~dp0
set SRC_DIR=%THIS_DIR%src
set CLASSPATH=%SRC_DIR%

call groovy %SRC_DIR%\Main.groovy
