set "home=F:\java"

cd %home%
cd javacomponentflow/processtask/trunk/processtask-api
call mvn install

cd %home%
cd javacomponent/organization/trunk
call mvn install

cd %home%
cd javacomponentflow/metadata/trunk
call mvn install

cd %home%
cd javacomponentflow/form/trunk
call mvn install

cd %home%
cd javacomponentflow/snaker/trunk
call mvn install

cd %home%
cd javacomponent/mvprocesstask/trunk
call mvn install

cd %home%
cd javacomponentflow/snakerext/trunk
call mvn install

cd %home%
cd javaplatform/publicservice/trunk
call mvn install

cd %home%
cd javaproject/macaovehicle/trunk
call mvn package

pause