package org.lv.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController{

	@RequestMapping(value="{formName}")
	public String uploadForm(@PathVariable String formName) {
		//��̬��תҳ��
		return formName;
	}
	
	//�ϴ��ļ����Զ��󶨵�MultipartFile��
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception{
		System.out.println(description);
		//����ļ���Ϊ��,д���ϴ�·��
		if(!file.isEmpty()) {
			//�ϴ��ļ�·��
			String path = request.getServletContext().getRealPath("/images/");
			//�ϴ��ļ���
			String filename = file.getOriginalFilename();
			File filepath = new File(path,filename);
			//�ж�·���Ƿ���ڣ���������ھʹ���һ��
			if(! filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			
			//���ϴ��ļ����浽һ��Ŀ���ļ�����
			file.transferTo(new File(path + File.separator + filename));
			return "success";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,
			@ModelAttribute User user,
			Model model) throws Exception{
		System.out.println(user.getUsername());
		//����ļ���Ϊ��,д���ϴ�·��
		if(!user.getImage().isEmpty()) {
			//�ϴ��ļ�·��
			String path = request.getServletContext().getRealPath("/images/");
			//�ϴ��ļ���
			String filename = user.getImage().getOriginalFilename();
			File filepath = new File(path,filename);
			//�ж�·���Ƿ���ڣ���������ھʹ���һ��
			if(! filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			
			//���ϴ��ļ����浽һ��Ŀ���ļ�����
			user.getImage().transferTo(new File(path + File.separator + filename));
			return "userInfo";
		}else {
			return "error";
		}
	}
	
	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,
			@RequestParam("filename") String filename,
			Model model) throws Exception{
		//�����ļ�·��
		String path = request.getServletContext().getRealPath("/images/");
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		//������ʾ���ļ���,���������������
		String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		//֪ͨ�����һattachment���ط�ʽ��
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//201 HttpStatus.created
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
}
