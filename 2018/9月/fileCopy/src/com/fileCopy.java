package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class fileCopy {
	
	public static void main(String[] args) throws IOException {
		File source = new File("D://file/file.txt");
		File target = new File("D://file/copy.txt");
		
		copy(source,target);
	}
	
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
}
