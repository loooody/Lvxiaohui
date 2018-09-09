package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class fileCopy {
	
	public static void main(String[] args) throws IOException {
		File source = new File("D://file/file.txt");
		File target = new File("D://file/copy.txt");
		
	//	copy(source,target);
		
		System.out.println(countWordInFile(source,"new"));
	}
	
	/**
	 * 文件拷贝
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void copy(File source,File target) throws IOException {
		InputStream in = new FileInputStream(source);
		OutputStream out = new FileOutputStream(target);
		byte[] buffer = new byte[4096];
		int bytesToRead;
		while((bytesToRead = in.read(buffer)) != -1) {
			out.write(buffer, 0, bytesToRead);
		}
		System.out.println("复制完成");
	}
	
	/**
	 * 统计给定字符串在文件中出现的次数
	 * @throws IOException 
	 */
	public static int countWordInFile(File filename,String word) throws IOException {
		int count = 0;
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line = br.readLine()) != null) {
			int index = -1;
			while(line.length() > word.length() && (index = line.indexOf(word)) >= 0) {
				count++;
				line = line.substring(index + word.length());
			}
		}
		return count;
	}
}
