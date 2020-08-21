@ECHO OFF
REM Doudizhu compile script
REM Yichen Li
cd ..
echo "Compiling..."
javac .\src\csci4963u20\project\doudizhu\*.java -d out
echo "Start running..."
java -classpath .\out csci4963u20.project.doudizhu.Application
pause
