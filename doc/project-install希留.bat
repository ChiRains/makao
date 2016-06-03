set "home=G:\qcloud_org\java"

cd %home%
cd componentflow/processtask/trunk/processtask-api
call mvn install

cd %home%
cd component/organization/trunk
call mvn install

cd %home%
cd componentflow/metadata/trunk
call mvn install

cd %home%
cd componentflow/form/trunk
call mvn install

cd %home%
cd componentflow/snaker/trunk
call mvn install

cd %home%
cd component/mvprocesstask/trunk
call mvn install

cd %home%
cd componentflow/snakerext/trunk
call mvn install

cd %home%
cd platform/publicdata/trunk
call mvn install

cd %home%
cd platform/publicservice/trunk
call mvn install

cd %home%
cd project/macaovehicle/trunk
call mvn package

pause