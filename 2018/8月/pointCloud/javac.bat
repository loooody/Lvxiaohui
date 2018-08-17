@echo java文件转换开始

@echo 此bat文件的目的是用于对java文件的编译，并不涉及到文件路径的修改
@echo 文件路径修改请在使用此bat文件之前完成

::在当前目录下建立转换后的文件存放位置
mkdir 3DVision

::文件的根目录地址

set "CURRENT_DIR=%cd%"

::cd "%CURRENT_DIR%"

cd 3DVision1

::在当前目录下建立转换后的文件存放位置
::mkdir 3DVision


::对整个javaweb项目进行编译
javac -d WebContent/WEB-INF/classes -classpath WebContent/WEB-INF/lib/servlet-api.jar;WebContent/WEB-INF/lib/commons-fileupload-1.3.3.jar -sourcepath src src/visionServlet/*.java

@echo java文件编译成功

::生成一个可部署到tomcat的文件夹
xcopy /S WebContent %CURRENT_DIR%/3DVision

@echo 文件生成成功，此时您可以将此目录下新生成的文件夹“3DVision”直接部署到tomcat/webapp下即可访问此网站

pause

