package org.lv.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lv.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����������ʵ��handlerInterceptor�ӿ�
 * @author 31966
 *
 */
public class AuthorizationInterceptor implements HandlerInterceptor{
	//�����ء�/loginForm���͡�/login"����
	private static final String[] IGNORE_URI = {"/loginForm","/login"};
	
	/**
	 * �÷������������������֮��ִ�У���Ҫ����������������Դ
	 * �÷���Ҳֻ���ڵ�ǰIntercptro��preHandler�����ķ���ֵ��trueʱ��ִ��
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			Exception exception)
	throws Exception{
		System.out.println("AuthorizationInterceptor afterCompletion-->");
	}
	
	/**
	 * �÷�������COntroller�ķ�������֮��ִ�У������п��Զ�ModelAndview���в���
	 * �÷���Ҳֻ���ڵ�ǰInterceptor��preHandler�����ķ���ֵλtrueʱ�Ż�ִ��
	 */
	
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView mv)
	throws Exception{
		System.out.println("AuthorizationInterceptor afterCompletion-->");
	}
	
	/**
	 * prehandle����ʱ���д����������õģ��÷�������Controller����֮ǰ���е���
	 * �÷����ķ���ֵλtrue�������Ż��������ִ�У��÷����ķ���ֵλ����ɪ��ʱ����������ͽ�����
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
	throws Exception{
		System.out.println("AuthorizationInterceptor prehandler-->");
		//flag���������ж��û��Ƿ��¼��Ĭ��λfalse
		boolean flag = false;
		//��ȡ�����·�������ж�
		String servletPath = request.getServletPath();
		//�ж������Ƿ���Ҫ����
		for(String s : IGNORE_URI) {
			if(servletPath.contains(s)) {
				flag = true;
				break;
			}
		}
		//��������
		if(!flag) {
			//1.��ȡsession�е��û�
			User user = (User) request.getSession().getAttribute("user");
			//2.�ж��û��Ƿ��Ѿ���¼
			if(user == null) {
				//����û�û�õ�¼����������ʾ��Ϣ����ת����¼ҳ��
				System.out.println("��������");
				request.setAttribute("message", "���ȵ�¼�ٷ�����վ");
				request.getRequestDispatcher("loginForm").forward(request, response);
			}else {
				//����û��Ѿ���¼������֤ͨ��������
				System.out.println("��������");
				flag = true;
			}
		}
		return flag;
	}

	
}
