package visionServlet;

import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.startCMD;


@WebServlet("/display3Dvision")
public class display3Dvision extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    public display3Dvision() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
	//	String filename = request.getAttribute("filepath").toString();
		
		String filename = dao.config.filepath;
		
		String message = "";
		
		if(filename == "" || filename == null) {
			out.write("无转换文件");
		}else {
			
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH-mm");
		String time1 = sdf.format(date);
		String time2 = sdf1.format(date);
		String time = time1+"-"+time2;
		
		String path1 = filename;
		String path2 = dao.config.convertfile_path;
		String path3 = filename.substring(filename.lastIndexOf("\\")+1);
		String path4 = path2 + time;
		
		dao.config.filename = time;
		
		
		String command = dao.config.potreeconvert_disk + " && cd " + dao.config.potreeconvert_path + " && PotreeConverter.exe " + path1 + " -o " +
		path4 + " --generate-page pageName";
		
			startCMD.executedCmd(command);
			
			out.write("成功");
		}
					
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
