package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Students {

    //用户登陆功能
    public void login(String name) throws IOException {
        int flag = 0;
        Scanner input = new Scanner(System.in);
        Logic_students logic_students = new Logic_students();

        do{
            System.out.println("\n-------欢迎使用驾校系统---------");
            System.out.println("欢迎您"+name +"用户\n您是学员，可以使用的功能为：");
            System.out.println("1.添加预约");
            System.out.println("2.查询预约");
            System.out.println("3.清除预约");
            System.out.println("0.退出");
            System.out.println("请根据功能输入相应的编号（0-3），当看到$即可输入:");
            System.out.print("请选择您要使用的功能：\n$");
            flag = input.nextInt();
            if(flag > 3 || flag < 0 ){
                System.out.println("输入错误，请重新输入：");
            }
            switch(flag){
                case 1:
                    logic_students.data_add(name);
                    break;
                case 2:
                    logic_students.data_query(name);
                    break;
                case 3:
                    logic_students.data_delete(name);
                    break;
                case 0:
                    System.out.println();
                    return ;
            }
        }while(flag != 0);
    }


}
