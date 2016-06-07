cd ..
cd ..
set "home=%cd%"

cd %home%
cd account
call mvn install

cd %home%
cd permission
call mvn install

cd %home%
cd piratesship
call mvn install

cd %home%
cd admin
call mvn install

cd %home%
cd processtask/processtask-api
call mvn install

cd %home%
cd publicdata
call mvn install

cd %home%
cd publicservice
call mvn install

cd %home%
cd file
call mvn install

cd %home%
cd organization
call mvn install

cd %home%
cd metadata
call mvn install

cd %home%
cd form
call mvn install

cd %home%
cd snaker
call mvn install

cd %home%
cd mvprocesstask
call mvn install

cd %home%
cd snakerext
call mvn install

cd %home%
cd macaovehicle
call mvn package

pause