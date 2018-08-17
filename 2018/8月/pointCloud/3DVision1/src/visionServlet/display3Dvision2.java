package visionServlet;

import java.awt.Desktop;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import dao.config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display3Dvision2
 */
@WebServlet("/display3Dvision2")
public class display3Dvision2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display3Dvision2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		PrintWriter out = response.getWriter();
		
		boolean flag = dao.config.flag;
		
//		out.println(dao.config.flag);
		
		//�鿴ȫ�ֱ���filename��ֵ
//		out.print("display:  "+dao.config.filename);
		
		String filename = dao.config.filename;
		
		if(flag) {
		System.out.print("��Ҫ��ʾ���ͼ");
		String url = "http://localhost:8000/" + dao.config.filesource + filename+"/pageName.html";
		URI uri;
		try {
			uri = new URI(url);
			Desktop.getDesktop().browse(uri);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.print("���������������ǻ���û��ʾ");
		}else {
			out.println("������˼��Ŀǰû����ת���ļ�");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
