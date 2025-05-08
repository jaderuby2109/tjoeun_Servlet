@ECHO OFF

set /p port=port: 
echo Closing port %port%...
for /f "tokens=5" %%p in ('netstat -aon ^| find /i "listening" ^| find "%port%"') do taskkill /F /PID %%p

echo Port %port% closed successfully.

echo alohaclass.kr
timeout /t 5 /nobreak >nul
