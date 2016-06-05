cd ..
cd ..
set "home=%cd%"

cd %home%
cd account/trunk
call mvn install

cd %home%
cd permission/trunk
call mvn install

cd %home%
cd admin/trunk
call mvn install

cd %home%
cd processtask/trunk/processtask-api
call mvn install

cd %home%
cd publicdata/trunk
call mvn install

cd %home%
cd publicservice/trunk
call mvn install

cd %home%
cd organization/trunk
call mvn install

cd %home%
cd metadata/trunk
call mvn install

cd %home%
cd form/trunk
call mvn install

cd %home%
cd snaker/trunk
call mvn install

cd %home%
cd mvprocesstask/trunk
call mvn install

cd %home%
cd snakerext/trunk
call mvn install

cd %home%
cd macaovehicle
call mvn package

pause