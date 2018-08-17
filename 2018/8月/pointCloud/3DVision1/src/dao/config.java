package dao;

public class config {

	public static boolean flag = false;    //用于标识是否此时已有转换文件
	public static String filename = "";     //用于存储去后缀的文件名
	public static String filepath = "";    
	
	public static String filepath1 = "C:\\Users\\31966\\Desktop\\file";    //上传文件的路径
	
	public static String path_disk = "C: ";          //转换后文件存储的父路径所在盘
	public static String convertfile_path =			//转换后的文件存储的父路径
			"C:\\Users\\31966\\Desktop\\file\\converter\\";
			
	public static String filesource = "/converter/";   //需要访问的文件在xampp下的那个文件目录下，根目录则此处filesource=“”；
	
	public static String potreeconvert_disk = "C: ";     //PotreeConvert存储路径所在盘
	public static String potreeconvert_path=     //PotreeConvert存储路径
			"C:\\Users\\31966\\Desktop\\PotreeConverter_1.6_windows_x64";
	
	
}
