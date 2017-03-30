@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  GeoBot startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and GEO_BOT_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\geoLearnBot-1.0.0-SNAPSHOT.jar;%APP_HOME%\lib\telegrambots-2.4.4.4.jar;%APP_HOME%\lib\gson-2.8.0.jar;%APP_HOME%\lib\json-path-2.2.0.jar;%APP_HOME%\lib\telegrambots-meta-2.4.4.4.jar;%APP_HOME%\lib\jackson-annotations-2.8.5.jar;%APP_HOME%\lib\jackson-databind-2.8.5.jar;%APP_HOME%\lib\jersey-media-json-jackson-2.25.jar;%APP_HOME%\lib\jersey-container-grizzly2-http-2.25.jar;%APP_HOME%\lib\jersey-server-2.25.jar;%APP_HOME%\lib\json-20160810.jar;%APP_HOME%\lib\httpclient-4.5.2.jar;%APP_HOME%\lib\httpmime-4.5.2.jar;%APP_HOME%\lib\commons-io-2.5.jar;%APP_HOME%\lib\json-smart-2.2.1.jar;%APP_HOME%\lib\slf4j-api-1.7.16.jar;%APP_HOME%\lib\guice-4.1.0.jar;%APP_HOME%\lib\jackson-core-2.8.5.jar;%APP_HOME%\lib\jersey-common-2.25.jar;%APP_HOME%\lib\jersey-entity-filtering-2.25.jar;%APP_HOME%\lib\jackson-jaxrs-base-2.8.4.jar;%APP_HOME%\lib\jackson-jaxrs-json-provider-2.8.4.jar;%APP_HOME%\lib\javax.inject-2.5.0-b30.jar;%APP_HOME%\lib\grizzly-http-server-2.3.28.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\jersey-client-2.25.jar;%APP_HOME%\lib\jersey-media-jaxb-2.25.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\hk2-api-2.5.0-b30.jar;%APP_HOME%\lib\hk2-locator-2.5.0-b30.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\httpcore-4.4.4.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.9.jar;%APP_HOME%\lib\accessors-smart-1.1.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\guava-19.0.jar;%APP_HOME%\lib\jersey-guava-2.25.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\jackson-module-jaxb-annotations-2.8.4.jar;%APP_HOME%\lib\grizzly-http-2.3.28.jar;%APP_HOME%\lib\hk2-utils-2.5.0-b30.jar;%APP_HOME%\lib\aopalliance-repackaged-2.5.0-b30.jar;%APP_HOME%\lib\javassist-3.20.0-GA.jar;%APP_HOME%\lib\asm-5.0.3.jar;%APP_HOME%\lib\grizzly-framework-2.3.28.jar

@rem Execute GeoBot
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GEO_BOT_OPTS%  -classpath "%CLASSPATH%" geoLearnBot.Main %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable GEO_BOT_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%GEO_BOT_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
