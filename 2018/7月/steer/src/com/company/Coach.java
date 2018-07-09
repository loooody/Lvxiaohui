package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Coach {
    public void login_Coach(String name) throws IOException, ParseException {
        int flag = 0;
        Scanner input = new Scanner(System.in);
        Logic_coach logic_coach = new Logic_coach();

        do{
        System.out.println("\n-------欢迎使用驾校系统---------");
        System.out.println("欢迎您"+name +"用户\n您是教练，可以使用的功能为：");
        System.out.println("1.添加预约安排");
        System.out.println("2.查询预约安排");
        System.out.println("3.删除预约");
        System.out.println("0.退出");
        System.out.println("请根据功能输入相应的编号（0-3），当看到“￥即可输入:");
        System.out.print("请选择您要使用的功能：\n$");
        flag = input.nextInt();
        if(flag > 3 || flag < 0 ){
            System.out.println("输入错误，请重新输入：");
        }
        switch(flag){
            case 1:
                logic_coach.data_add(name);
                break;
            case 2:
                logic_coach.data_query(name);
                break;
            case 3:
                logic_coach.data_delete(name);
                break;
            case 0:
                System.out.println();
                return ;
        }
    }while(flag != 0);
}


}
