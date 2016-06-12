cd ..
cd ..
set "home=%cd%"

cd %home%
cd account/account-api
call mvn clean

cd %home%
cd account
call mvn clean

cd %home%
cd permission
call mvn clean

cd %home%
cd admin
call mvn clean

cd %home%
cd processtask/processtask-api
call mvn clean

cd %home%
cd publicdata
call mvn clean

cd %home%
cd publicservice
call mvn clean

cd %home%
cd file
call mvn clean

cd %home%
cd organization
call mvn clean

cd %home%
cd metadata
call mvn clean

cd %home%
cd form
call mvn clean

cd %home%
cd snaker
call mvn clean

cd %home%
cd mvprocesstask
call mvn clean

cd %home%
cd snakerext
call mvn clean

cd %home%
cd macaovehicle
call mvn clean
pause