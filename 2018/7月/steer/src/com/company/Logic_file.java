package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Logic_file{
    Scanner input = new Scanner(System.in);

    //教练添加预约安排
    public void add_coach(String ID,String name,String start_Time,String end_Time,String car_num) throws IOException, ParseException {
        if(isDup(ID,start_Time,end_Time)) {
            String path = "/home/loooody/IdeaProjects/steer/src/com/file/coachInfo.txt";
            File file = new File(path);
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(file, true));
            bWriter.write(ID + "," + name + ",无," + start_Time + "," + end_Time + "," + car_num + "\n");
            System.out.println("添加预约安排成功！！！！");
            System.out.println("ID\t车牌号\t发起人\t预约人\t        开始时间\t         结束时间\t");
            System.out.println(ID + "\t" + car_num + "  \t" + name + "\t  无\t   " + start_Time + "\t " + end_Time + "\t\n");
            bWriter.close();
        }else{
            System.out.println("添加预约安排失败！！！！");
        }
    }


    //判断教练预约安排的ID与时间是否正确
    public boolean isDup(String ID,String start_Time,String end_Time) throws IOException, ParseException {
        Map<String,ReserInfo> map = getReserInfo();
        Set<String> keySet = map.keySet();
        long nh = 1000*60*60;//一小时的毫秒数
        Date start = strFormateDate(start_Time);
        Date end = strFormateDate(end_Time);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long hour = end.getTime() - start.getTime() / nh;
        for(String str : keySet) {
            Date start_time = strFormateDate(map.get(str).getStart_Time());
            Date end_time = strFormateDate(map.get(str).getEnd_Time());
            if (ID.equals(str)) {
                System.out.println("此ID已被使用！！！");
               return false;
            }else if(start.after(start_time) && start.before(end_time)){
                System.out.println("预约安排时间开始时间与已有安排冲突！！！！");
                return false;
            }else if(end.after(start_time) && end.before(end_time)){
                System.out.println("预约安排时间结束时间与已有安排冲突！！！！");
                return false;
            }else if(hour <= 1){
                System.out.println("时间差小于一小时！！！");
                return false;
            }
        }
        return true;
    }

    //将字符串转换为日期格式
    public Date strFormateDate(String str) throws ParseException {
        DateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = formate.parse(str);
        return date;
    }


    //从教练预约安排表中读取数据
    public Map<String,ReserInfo> getReserInfo() throws IOException {
        Map<String,ReserInfo> map = new HashMap<>();
        String path = "/home/loooody/IdeaProjects/steer/src/com/file/coachInfo.txt";
        File file = new File(path);
        BufferedReader bReader = new BufferedReader(new FileReader(file));
        String str = "";
        String[] value = new String[5];
        String pc[] = new String[6];
        while((str = bReader.readLine()) != null){
            pc = str.split(",");
            String key = pc[0];
            value[0] = pc[1];
            value[1] = pc[2];
            value[2] = pc[3];
            value[3] = pc[4];
            value[4] = pc[5];
            ReserInfo reserInfo = new ReserInfo(key,value[0],value[1],value[2],value[3],value[4]);
            map.put(key,reserInfo);
        }
        bReader.close();
        return map;
    }

    //根据姓名来查询其发布的预约安排
    public void query_Reser(String name) throws IOException {
        Map<String,ReserInfo> map = getReserInfo();
        Set<String> keySet = map.keySet();
        System.out.println("查询成功！！！");
        System.out.println("ID\t车牌号\t发起人\t预约人\t          开始时间\t           结束时间\t");
        for(String str : keySet){
            if(name.equals(map.get(str).getName_coach()) ){
                System.out.println(str+"\t"+map.get(str).getCar_num()+" \t"+map.get(str).getName_coach()+"\t  "+map.get(str).getName_stu()+"\t   "
                        +map.get(str).getStart_Time()+"\t\t "+map.get(str).getEnd_Time()+"\t");
            }else if(name.equals(map.get(str).getName_stu())){
                System.out.println(str+"\t"+map.get(str).getCar_num()+" \t"+map.get(str).getName_coach()+"\t  "+map.get(str).getName_stu()+"\t   "
                        +map.get(str).getStart_Time()+"\t\t "+map.get(str).getEnd_Time()+"\t");
            }
        }
    }

    //教练使用ID删除自己发布的预约安排
    public void delete_coach(String ID,String name) throws IOException {
        Map<String,ReserInfo> map = getReserInfo();
        Set<String> keySet = map.keySet();
        boolean flag = false;
        for(String str : keySet) {
            if (ID.equals(str)) {
                flag = true;
            }
        }
        if(flag) {
            if (name.equals(map.get(ID).getName_coach()) && (map.get(ID).getName_stu()).equals("无")) {
                map.remove(ID);
                System.out.println("删除成功！！！！");
            } else if (name.equals(map.get(ID).getName_coach()) && (map.get(ID).getName_stu()) != "无") {
                System.out.println("不能删除此预约安排，有学员已预约!!!!");
                System.out.println("ID\t车牌号\t发起人\t预约人\t        开始时间\t         结束时间\t");
                System.out.println(ID + "\t" + map.get(ID).getCar_num() + "  \t" + name + "\t  " + map.get(ID).getName_stu() + "\t   "
                        + map.get(ID).getStart_Time() + "\t " + map.get(ID).getEnd_Time() + "\t");
            }

        /*
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String key = it.next();
            System.out.println(it.next());
            System.out.println(map.get(key).getName_coach());
            if(ID.equals(key) && name.equals(map.get(key).getName_coach())
                    && map.get(key).getName_stu() != "无"){

            }
        }*/

        /*
        Set<String> keySet = map.keySet();
        for(String str : keySet){
            if(ID.equals(str) && name.equals(map.get(str).getName_coach())
                    && map.get(str).getName_stu() != "无"){
                map.remove(str);
            }
        }*/

            String path = "/home/loooody/IdeaProjects/steer/src/com/file/coachInfo.txt";
            File file = new File(path);
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
            Iterator<String> it = map.keySet().iterator();

            while (it.hasNext()) {
                String key = it.next();
                if (key != "") {
                    bWriter.write(key + "," + map.get(key).getName_coach() + "," + map.get(key).getName_stu()
                            + "," + map.get(key).getStart_Time() + "," + map.get(key).getEnd_Time()
                            + "," + map.get(key).getCar_num() + "\n");
                }
            }

            bWriter.close();
        }else {
            System.out.println("您输入的ID有误！！！！！");
        }
    }


    /**
     * 学员
     * 功能：增加，查询，删除
     */
    //查询所有已发布的安排
    public void query() throws IOException {
        Map<String,ReserInfo> map = getReserInfo();
        Set<String> keySet = map.keySet();
        System.out.println("查询成功！！！");
        System.out.println("ID\t车牌号\t发起人\t预约人\t        开始时间\t         结束时间\t");
        for(String str : keySet){
                System.out.println(str+"\t"+map.get(str).getCar_num()+"  \t"+map.get(str).getName_coach()+"\t  "+map.get(str).getName_stu()+"\t   "
                        +map.get(str).getStart_Time()+"\t "+map.get(str).getEnd_Time()+"\t");
        }
    }

    //学员添加预约安排
    public void add_students(String name) throws IOException {
        query();
        Map<String,ReserInfo> map = getReserInfo();
        Set<String> keySet = map.keySet();
        boolean flag = false;
        System.out.println("请输入您想预约的教练的预约ID:");
        String ID = input.nextLine();
        for(String str : keySet) {
            if (ID.equals(str) && map.get(ID).getName_stu().equals("无")) {
                map.get(ID).setName_stu(name);
                flag = true;
            }
        }
        if(flag) {
            String path = "/home/loooody/IdeaProjects/steer/src/com/file/coachInfo.txt";
            File file = new File(path);
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
            for (String str :keySet){
                bWriter.write(str + "," + map.get(str).getName_coach() + "," + map.get(str).getName_stu() + "," + map.get(str).getStart_Time()
                        + "," + map.get(str).getEnd_Time() + "," + map.get(str).getCar_num() + "\n");
            }
            System.out.println("添加预约安排成功！！！！");
            System.out.println("ID\t车牌号\t发起人\t预约人\t        开始时间\t         结束时间\t");
            System.out.println(ID + "\t" + map.get(ID).getCar_num() + "  \t" + map.get(ID).getName_coach()
                    + "\t  "+name+"\t   " + map.get(ID).getStart_Time() + "\t " + map.get(ID).getEnd_Time() + "\t\n");
            bWriter.close();
        }else {
            System.out.println("您输入的ID有误！！！！！");
        }

    }

    //学员使用ID删除自己发布的预约安排
    public void delete_students(String name) throws IOException {
        System.out.print("请输入要删除预约的ID：\n$");
        String ID = input.nextLine();
        Map<String,ReserInfo> map = getReserInfo();
        Set<String> keySet = map.keySet();
        boolean flag = false;
        for(String str : keySet) {
            if (ID.equals(str)) {
                flag = true;
            }
        }
        if(flag) {
            if (name.equals(map.get(ID).getName_stu()) ) {
                map.remove(ID);
                System.out.println("删除成功！！！！");
            } else if (name.equals(map.get(ID).getName_coach()) && (map.get(ID).getName_stu()) != "无") {
                System.out.println("不能删除此预约安排，有学员已预约!!!!");
                System.out.println("ID\t车牌号\t发起人\t预约人\t        开始时间\t         结束时间\t");
                System.out.println(ID + "\t" + map.get(ID).getCar_num() + "  \t" + name + "\t  " + map.get(ID).getName_stu() + "\t   "
                        + map.get(ID).getStart_Time() + "\t " + map.get(ID).getEnd_Time() + "\t");
            }

            String path = "/home/loooody/IdeaProjects/steer/src/com/file/coachInfo.txt";
            File file = new File(path);
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
            Iterator<String> it = map.keySet().iterator();

            while (it.hasNext()) {
                String key = it.next();
                if (key != "") {
                    bWriter.write(key + "," + map.get(key).getName_coach() + "," + map.get(key).getName_stu()
                            + "," + map.get(key).getStart_Time() + "," + map.get(key).getEnd_Time()
                            + "," + map.get(key).getCar_num() + "\n");
                }
            }

            bWriter.close();
        }else {
            System.out.println("您输入的ID有误！！！！！");
        }
    }



}
