package visionServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




/**
 * Servlet implementation class vision
 */
@WebServlet("/vision")
@MultipartConfig
public class vision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vision() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB_INTĿ¼��
		�����������ʣ���֤�ļ���ȫ
		*/
		String savePath = dao.config.filepath1;
		File file = new File(savePath);
		//�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
		if(!file.exists() && !file.isDirectory()) {
			System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
			//����Ŀ¼
			file.mkdirs();
		}
		
		
		//��Ϣ��ʾ
		String message = "";
		String filepath= "";
	try {	
		 //ʹ��Apache�ļ��ϴ���������ļ��ϴ�����
		//1.����һ��DiskFileItemFactory����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2.����һ���ļ��ϴ�������
		ServletFileUpload upload = new ServletFileUpload(factory);
		//����ϴ��ļ�������������
		upload.setHeaderEncoding("UTF-8");
		//�ж��ύ�����������Ƿ����ϴ���������
		if(!ServletFileUpload.isMultipartContent(request)) {
			//���մ�ͳ��ʽ��ȡ����
			return ;
		}
		
		/*
		 * 4.ʹ��ServletFileUpload�������ϴ����ݣ�����������ص���һ��
		 * List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
		 * 
		 */
		
		// upload.setSizeMax(5000*1024);
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list) {
				//���fileItem�з�װ������ͨ�����������
				if(item.isFormField()) {
					String name = item.getFieldName();
					//�����ͨ����������ݵ�������������
					String value = item.getString("UTF-8");
					System.out.println(name+"="+value);
					
				}else {
					//���fileItem�з�װ�����ϴ��ļ�
					//�õ����ļ�����
					String filename = item.getName();
					System.out.println(filename);
					if(filename == null || filename.trim().equals("")) {
						request.setCharacterEncoding("gb2312");
						request.setAttribute("message", "�ļ�������Ϊ��");
						request.getRequestDispatcher("upload.jsp").forward(request, response);
					}
					
					//ע�⣬��ͬ������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·����
					
					//�����ȡ�����ϴ��ļ����ļ�����·������,ֻ�����ļ�������
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					String filename1 = filename.substring(0, filename.lastIndexOf("."));
					System.out.println(filename1);
					dao.config.filename = filename1;
					
					String lastfile = filename.substring(filename.lastIndexOf(".")+1);
					System.out.println("�ļ��ĺ�׺��ʱ:"+lastfile);
					if(lastfile.equals("las") || lastfile.equals("laz")) {
					
					//��ȡitem�е��ϴ��ļ���������
					System.out.println("�ļ���:"+filename);
					InputStream in = item.getInputStream();
					//����һ���ļ������
					FileOutputStream out = new FileOutputStream(savePath+"\\"+filename);
				//	System.out.println("����·��λ:"+savePath+"\\"+filename);
					filepath = savePath+"\\"+filename;
					System.out.println(filepath);
					dao.config.filepath = filepath;
				//	request.setAttribute("filepath", filepath);
					//����һ��������
					byte buffer[] = new byte[1024];
					//�ж��������е������Ƿ��Ѿ�����ı�־
					int len = 0;
					//ѭ�������������뵽�������У�(len = in.read(buffer))>0�ͱ�ʾin���滹������
					
					while((len = in.read(buffer)) >0 ) {
						//ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼����
						out.write(buffer,0,len);
						System.out.println("��������");
					}
					System.out.println("�ϴ��ɹ�");
					//�ر�������
					in.close();
					//�ر������
					out.close();
					//ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					item.delete();
					dao.config.flag = true;
					message = "�ļ��ϴ��ɹ�";
					request.setAttribute("message", "�ļ��ϴ��ɹ�");
					request.getRequestDispatcher("upload.jsp").forward(request, response);
					//����������
	//				startSer.startServer();
	
					
					
					
					}else {
						request.setCharacterEncoding("gb2312");
						request.setAttribute("message", "�ļ����ʹ���,������ѡ���ļ���las��laz)");
						request.getRequestDispatcher("upload.jsp").forward(request, response);
					}
				}
			}
		} catch (Exception e) {
			message = "�ļ��ϴ�ʧ��";
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
