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
		得到上传文件的保存目录，将上传的文件存放于WEB_INT目录下
		不允许外界访问，保证文件安全
		*/
		String savePath = dao.config.filepath1;
		File file = new File(savePath);
		//判断上传文件的保存目录是否存在
		if(!file.exists() && !file.isDirectory()) {
			System.out.println(savePath+"目录不存在，需要创建");
			//创建目录
			file.mkdirs();
		}
		
		
		//消息提示
		String message = "";
		String filepath= "";
	try {	
		 //使用Apache文件上传组件处理文件上传步骤
		//1.创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2.创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		//判断提交上来的数据是否是上传表单的数据
		if(!ServletFileUpload.isMultipartContent(request)) {
			//按照传统方式获取数据
			return ;
		}
		
		/*
		 * 4.使用ServletFileUpload解析器上传数据，解析结果返回的是一个
		 * List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		 * 
		 */
		
		// upload.setSizeMax(5000*1024);
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list) {
				//如果fileItem中封装的是普通输入项的数据
				if(item.isFormField()) {
					String name = item.getFieldName();
					//解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					System.out.println(name+"="+value);
					
				}else {
					//如果fileItem中封装的是上传文件
					//得到的文件名称
					String filename = item.getName();
					System.out.println(filename);
					if(filename == null || filename.trim().equals("")) {
						request.setCharacterEncoding("gb2312");
						request.setAttribute("message", "文件名不能为空");
						request.getRequestDispatcher("upload.jsp").forward(request, response);
					}
					
					//注意，不同浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的
					
					//处理获取到的上传文件的文件名的路径部分,只保留文件名部分
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					String filename1 = filename.substring(0, filename.lastIndexOf("."));
					System.out.println(filename1);
					dao.config.filename = filename1;
					
					String lastfile = filename.substring(filename.lastIndexOf(".")+1);
					System.out.println("文件的后缀名时:"+lastfile);
					if(lastfile.equals("las") || lastfile.equals("laz")) {
					
					//获取item中的上传文件的输入流
					System.out.println("文件名:"+filename);
					InputStream in = item.getInputStream();
					//创建一个文件输出流
					FileOutputStream out = new FileOutputStream(savePath+"\\"+filename);
				//	System.out.println("保存路径位:"+savePath+"\\"+filename);
					filepath = savePath+"\\"+filename;
					System.out.println(filepath);
					dao.config.filepath = filepath;
				//	request.setAttribute("filepath", filepath);
					//创建一个缓冲区
					byte buffer[] = new byte[1024];
					//判断输入流中的数据是否已经读完的标志
					int len = 0;
					//循环将输入流读入到缓冲区中，(len = in.read(buffer))>0就表示in里面还有数据
					
					while((len = in.read(buffer)) >0 ) {
						//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录当中
						out.write(buffer,0,len);
						System.out.println("经过这里");
					}
					System.out.println("上传成功");
					//关闭输入流
					in.close();
					//关闭输出流
					out.close();
					//删除处理文件上传时生成的临时文件
					item.delete();
					dao.config.flag = true;
					message = "文件上传成功";
					request.setAttribute("message", "文件上传成功");
					request.getRequestDispatcher("upload.jsp").forward(request, response);
					//启动服务器
	//				startSer.startServer();
	
					
					
					
					}else {
						request.setCharacterEncoding("gb2312");
						request.setAttribute("message", "文件类型错误,请重新选择文件（las，laz)");
						request.getRequestDispatcher("upload.jsp").forward(request, response);
					}
				}
			}
		} catch (Exception e) {
			message = "文件上传失败";
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
