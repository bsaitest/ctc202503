echo "start build"
npm run build
echo "build finished."
echo "remove the last build"
echo cd C:\ctc\PG\ctc202503\demo\src\main\resources\static
echo del /Q *.*
echo for /d %i in (*) do rd /s /q "%i"

echo "copy files to tomcat"
2.copy the dist's files into tomcat/webapps

xcopy C:\ctc\PG\ctc202503\demo\UI\dist\* C:\ctc\PG\ctc202503\demo\src\main\resources\static /E /H /C /I

echo "build finished."
