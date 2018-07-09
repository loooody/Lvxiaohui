package com.company;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Logic_login {
    Students students = new Students();
    Coach coach = new Coach();
    Scanner input = new Scanner(System.in);

    //用户登陆
    public void login() throws IOException, ParseException {
        System.out.println("\n------用户登陆------");
        System.out.print("请输入用户名：\n$");

        String name = input.nextLine();
        System.out.print("请输入用户密码：\n$");

        String password = input.nextLine();
        if(SignIn(name,password) == 1){
            coach.login_Coach(name);
        }
        else if(SignIn(name,password) == 0){
            students.login(name);
        }else {
            System.out.println("没有此用户！！！");
        }
    }

    //从保存用户信息的文件中读取用户信息
    public Map<String,User> getUser() throws IOException {
        Map<String, User> map = new HashMap<>();
        String path = "/home/loooody/IdeaProjects/steer/src/com/file/userInfo.txt";
        File file = new File(path);
        BufferedReader bReader = new BufferedReader(new FileReader(file));
        String str = "";
        String value[] = new String[2];
        while((str = bReader.readLine()) != null){
            String pc[] = str.split(",");
            String key = pc[0];
            value[0] = pc[1];
            value[1] = pc[2];
            User user = new User(key,value[0],value[1]);
            map.put(key,user);
        }
        bReader.close();
        return map;
    }

    //用户信息验证
    public int SignIn(String name,String password) throws IOException {
        int flag = -1;
        Map<String,User> map = getUser();
        Set<String > keySet = map.keySet();
        for(String str : keySet){
            if(name.equals(str) && password.equals(map.get(str).getUserPwd())
                    && (map.get(str).getGrade().equals("coach"))){
                System.out.println(map.get(str).getGrade());
                flag = 1;
            }else if(name.equals(str) && password.equals(map.get(str).getUserPwd())
                    && (map.get(str).getGrade().equals("students"))){
                flag = 0;
            }
        }
        return flag;
    }

    //用户信息注册
    public void SignUp() throws IOException {
        System.out.println("\n------用户注册------");
        System.out.print("请输入用户名：\n$");
        String name = input.nextLine();
        System.out.print("请输入用户密码：\n$");
        String password = input.nextLine();
        boolean flag = false;
        String grade = "";
        do {
            System.out.print("请选择您要注册的用户身份：(1-教练 0-学员）输入（1或0）：\n$");
            grade = input.nextLine();
            if(grade.equals("0") || grade.equals("1")){
                flag = true;
            }else{
                System.out.println("输入有误，请重新输入！！！");
            }
        }while(!flag);
        SignUp_write(name,password,grade);
    }

    //将用户注册信息写入用户帐号信息的文件中
    public void SignUp_write(String name,String pwd,String grade) throws IOException {
        String grade1 = "";
        if(grade.equals("1")){
            grade1 = "coach";
        }else if(grade.equals("0")){
            grade1 = "students";
        }
        if(Sign_Up(name,grade1)){
            System.out.println("已有此用户，不能注册，请使用其他用户名！！！\n");
            return ;
        }
        String path = "/home/loooody/IdeaProjects/steer/src/com/file/userInfo.txt";
        File file = new File(path);
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file,true));
        bWriter.write(name+","+pwd+","+grade1+"\n");
        System.out.println("注册成功！！！");
        System.out.println("帐号："+name+"  密码："+pwd+"  身份："+grade1);
        System.out.println();
        bWriter.close();
    }

    //用户信息验证
    public boolean Sign_Up(String name,String grade) throws IOException {
        boolean flag = false;
        Map<String,User> map = getUser();
        Set<String > keySet = map.keySet();
        for(String str : keySet){
            if(name.equals(str) && grade.equals(map.get(str).getGrade())){
                flag = true;
            }
        }
        return flag;
    }

    //这里负责文件的读写，逻辑方面都在这里面实现


    /**
     * 文件需要有大概三个
     * 1.负责储存用户，在登陆的时候用
     * 2.负责存储用户的预约情况
     * 3.教练发布的相关信息
     */

}
