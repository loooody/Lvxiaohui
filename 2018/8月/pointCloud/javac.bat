@echo java�ļ�ת����ʼ

@echo ��bat�ļ���Ŀ�������ڶ�java�ļ��ı��룬�����漰���ļ�·�����޸�
@echo �ļ�·���޸�����ʹ�ô�bat�ļ�֮ǰ���

::�ڵ�ǰĿ¼�½���ת������ļ����λ��
mkdir 3DVision

::�ļ��ĸ�Ŀ¼��ַ

set "CURRENT_DIR=%cd%"

::cd "%CURRENT_DIR%"

cd 3DVision1

::�ڵ�ǰĿ¼�½���ת������ļ����λ��
::mkdir 3DVision


::������javaweb��Ŀ���б���
javac -d WebContent/WEB-INF/classes -classpath WebContent/WEB-INF/lib/servlet-api.jar;WebContent/WEB-INF/lib/commons-fileupload-1.3.3.jar -sourcepath src src/visionServlet/*.java

@echo java�ļ�����ɹ�

::����һ���ɲ���tomcat���ļ���
xcopy /S WebContent %CURRENT_DIR%/3DVision

@echo �ļ����ɳɹ�����ʱ�����Խ���Ŀ¼�������ɵ��ļ��С�3DVision��ֱ�Ӳ���tomcat/webapp�¼��ɷ��ʴ���վ

pause

