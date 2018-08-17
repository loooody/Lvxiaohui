package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class startCMD {
	
	//÷¥––cmd√¸¡Ó
	public static String executedCmd(String command) throws IOException {
		System.out.println("Excute command:"+command);
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("cmd /c " + command);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(process.getInputStream(),"gb2312"));
		String msg = null;
		StringBuilder build = new StringBuilder();
		while((msg = br.readLine()) != null) {
			System.out.println(msg);
			build.append(msg);
		}
		return build.toString();
	}
}
