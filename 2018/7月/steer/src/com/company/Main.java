package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
	// write your code here
        String flag = "";
        Scanner input = new Scanner(System.in);
        Coach coach = new Coach();
        Students students = new Students();
        Logic_login logic = new Logic_login();

        do{
            System.out.println("-------欢迎使用驾校系统---------");
            System.out.println("1.用户注册");
            System.out.println("2.用户登陆");
            System.out.println("0.退出");
            System.out.println("请根据功能输入相应的编号（0-2），当看到“￥即可输入:");
            System.out.print("请选择您要使用的功能：\n$");
            flag = input.nextLine();
            if(flag.equals("1") || flag.equals("2")|| flag.equals("0") ){
                switch(flag){
                    case "1":
                        logic.SignUp();
                        break;
                    case "2":
                        logic.login();
                        break;
                    case "0":
                        System.exit(0);
                }
            }else{
                System.out.println("输入错误，请重新输入：\n");
            }

        }while(flag != "0");
    }
}
