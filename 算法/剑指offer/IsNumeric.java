package com.company;

public class IsNumeric {

    public static boolean isNumeric(String string) {
        if (string == null || string.length() < 1) {
            return false;
        }
        int index = 0;

        if (string.charAt(index) == '+' || string.charAt(index) == '-') {
            index++;
        }

        //已经到达字符串的末尾了
        if (index >= string.length()) {
            return false;
        }

        boolean numeric = true;

        index = scanDigits(string, index);
        //还没到字符串末尾
        if (index < string.length()) {
            //如果小数点
            if (string.charAt(index) == '.') {
                //移动到下一位置
                index++;
                index = scanDigits(string, index);

                //已经到字符末尾了
                if (index >= string.length()) {
                    numeric = true;
                }

                //还没到到字符串结束位置
                else if (index < string.length() && (string.charAt(index) == 'e' || string.charAt(index) == 'E')) {
                    numeric = isExponential(string, index);
                }else{
                    numeric = false;
                }
            }

            //如果有e标志
            else if (string.charAt(index) == 'e' || string.charAt(index) == 'E') {
                numeric = isExponential(string, index);
            }else{
                numeric = false;
            }
            return numeric;
        }
        //已经到了字符串的末尾了
        else{
            return true;
        }
    }

    private static boolean isExponential(String string, int index) {

        if (index >= string.length() || (string.charAt(index) != 'e' && string.charAt(index) != 'E')) {
            return false;
        }

        //移动到下一个要处理的位置
        index++;

        //到达字符串的末尾，就返回false
        if (index >= string.length()) {
            return false;
        }

        if (string.charAt(index) == '+' || string.charAt(index) == '-') {
            index++;
        }

        if (index >= string.length()) {
            return false;
        }

        index = scanDigits(string, index);

        //如果已经处理到数字的末尾就认为时正确的数字
        return index >= string.length();
    }

    private static int scanDigits(String string, int index) {
        while (index < string.length() && string.charAt(index) >= '0' && string.charAt(index) <= '9') {
            index++;
        }

        return index;
    }


    public static void main(String[] args) {
        System.out.println(isNumeric("100"));
        System.out.println(isNumeric("123e9"));
        System.out.println(isNumeric("-12e"));
    }
}
