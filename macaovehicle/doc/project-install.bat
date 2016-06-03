set "home=G:/qcloud/java"

cd %home%
cd component/processtask/trunk/processtask-api
call mvn install

cd %home%
cd component/organization/trunk
call mvn install

cd %home%
cd component/metadata/trunk
call mvn install

cd %home%
cd component/form/trunk
call mvn install

cd %home%
cd component/snaker/trunk
call mvn install

cd %home%
cd component/mvprocesstask/trunk
call mvn install

cd %home%
cd component/snakerext/trunk
call mvn install

cd %home%
cd project/macaovehicle/trunk
call mvn package

pause