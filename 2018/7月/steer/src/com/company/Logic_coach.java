package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logic_coach extends Dada_change{
    Scanner input = new Scanner(System.in);
    Logic_file logic_file = new Logic_file();
    //教练添加预约
    public void data_add(String name) throws IOException, ParseException {
        print("1.添加预约安排\n");
        print("-------分隔符-----------\n");
        validate(name);
    }

    //教练查询预约情况
    public void data_query(String name) throws IOException {
        print("2.查询预约情况\n");
        print("-------分隔符-----------\n");
        try {
            logic_file.query_Reser(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //教练清除预约
    public void data_delete(String name) throws IOException {
        print("2.删除预约\n");
        print("-------分隔符-----------\n");
        logic_file.query_Reser(name);
        print("请输入要删除预约的ID：\n$");
        String ID = input.nextLine();
        try {
            logic_file.delete_coach(ID,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断输入的字符串是否满足时间格式 ： yyyy-MM-dd HH:mm:ss
     * @param patternString 需要验证的字符串
     * @return 合法返回 true ; 不合法返回false
     */
    public static boolean isTimeLegal(String patternString) {

        Pattern a=Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher b=a.matcher(patternString);
        if(b.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public void validate(String name) throws IOException, ParseException {
        String ID = "";
        print("请输入开始时间:(格式:2018-07-03 14:00:00)\n$");
        do {
            String start_Time = input.nextLine();
            if (isTimeLegal(start_Time)) {
                print("请输入结束时间:(格式:2018-07-03 14:00:00)\n$");
                do {
                    String end_Time = input.nextLine();
                    if (isTimeLegal(end_Time)) {
                        print("请输入车牌号：\n$");
                        do {
                            String car_num = input.nextLine();
                        //    System.out.println(car_num);
                            if(car_num.equals("")) {
                                System.out.println("车牌号不能为空，请输入车牌号！！！");
                            }else {
                                print("请输入预约编号\n$");
                                do {
                                    ID = input.nextLine();
                       //             System.out.println(ID);
                                    if (ID.equals("")) {
                                        System.out.println("预约编号不能为空，请输入预约编号！！！");
                                    } else {
                                        logic_file.add_coach(ID, name, start_Time, end_Time, car_num);
                                    }
                                }while (ID.equals(""));
                            }
                        }while(ID.equals(""));
                    }else{
                        System.out.println("时间输入格式有误，请重新输入！！！");
                    }
                }while(ID.equals(""));
            }else{
                System.out.println("时间输入格式有误，请重新输入！！！");
            }
        }while(ID.equals(""));
    }



    public void print(String str){
        System.out.print(str);
    }

}
