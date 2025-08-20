set ProjectPath=%~dp0
java -jar "%ProjectPath%Library\selenium-server-4.34.0.jar" node --selenium-manager true  --detect-drivers true --hub http://192.168.100.247:4444 --max-sessions 5
pause