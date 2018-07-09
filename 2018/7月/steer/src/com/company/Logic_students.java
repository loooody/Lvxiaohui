package com.company;

import java.io.IOException;

public class Logic_students extends Dada_change{
    Logic_file logic_file = new Logic_file();

    //学员查询预约
    public void data_add(String name) throws IOException {
        print("1.添加预约安排");
        print("-------分隔符-----------");
        logic_file.add_students(name);
    }

    //学员查询预约情况
    public void data_query(String name){
        print("2.查询预约情况\n");
        print("-------分隔符-----------\n");
        try {
            logic_file.query_Reser(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //学员清除预约
    public void data_delete(String name){
        print("2.删除预约\n");
        print("-------分隔符-----------\n");
        try {
            logic_file.query_Reser(name);
            logic_file.delete_students(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String str){
        System.out.println(str);
    }
}
