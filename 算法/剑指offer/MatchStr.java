package com.company;

import java.util.Scanner;


/**
 * 递归实现
 *
 * 每次分别在str 和pattern中取一个字符进行匹配，如果匹配，则匹配下一个字符，否则，返回不匹配。
 *
 * 设匹配递归函数 match(str, pattern)。
 *
 * 如果模式匹配字符的下一个字符是‘*’:
 *
 * •如果pttern当前字符和str的当前字符匹配，：有以下三种可能情况
 *
 * （1）pttern当前字符能匹配 str 中的 0 个字符：match(str, pattern+2)
 *
 * （2）pttern当前字符能匹配 str 中的 1 个字符：match(str+1, pattern+2)
 *
 * （3）pttern当前字符能匹配 str 中的 多 个字符：match(str+1, pattern)
 *
 *  如果pttern当前字符和和str的当前字符不匹配
 *
 * pttern当前字符能匹配 str 中的 0 个字符：(str, pattern+2)
 *
 * 如果模式匹配字符的下一个字符不是‘*’，进行逐字符匹配。
 *
 * 对于 ‘.’ 的情况比较简单，’.’ 和一个字符匹配 match(str+1, pattern+1)
 *
 * 另外需要注意的是：空字符串”” 和 “.*” 是匹配的
 *
 * ---------------------
 *
 */
public class MatchStr {
    public boolean matchFunction(String input, String pattren) {
        if (input == null || pattren == null) {
            return false;
        }

        return matchCore(input, 0, pattren, 0);
    }

    private boolean matchCore(String input, int i, String pattren, int p) {

        //两个字符都到了结尾，说明匹配成功，返回true
        if (i >= input.length() && p >= pattren.length()) {
            return true;
        }

        //模式字符达到了结尾，说明匹配失败，返回false
        if (i != input.length() && p >= pattren.length()) {
            return false;
        }

        //模式字符没有结束
        if (p + 1 < pattren.length() && pattren.charAt(p + 1) == '*') {
            //匹配已经结束
            if (i >= input.length()) {
                return matchCore(input, i, pattren, p + 2);
            }
            else{
                //匹配还没有结束
                if (pattren.charAt(p) == input.charAt(i) || pattren.charAt(p) == '.') {
                    return
                            matchCore(input, i + 1, pattren, p + 2)
                            || matchCore(input, i + 1, pattren, p)
                            || matchCore(input, i, pattren, p + 2);
                }
                else{
                    return matchCore(input, i, pattren, p + 2);
                }
            }
        }

        if (i >= input.length()) {
            return false;
        }
        else{
            if (input.charAt(i) == pattren.charAt(p) || pattren.charAt(p) == '.') {
                return matchCore(input, i + 1, pattren, p + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个字符串：");
        String str1 = scanner.nextLine();
        System.out.println("请输入第二个字符串:");
        String str2 = scanner.nextLine();

        MatchStr match = new MatchStr();
        scanner.close();

        System.out.print("匹配的结果为:");
        System.out.println(match.matchFunction(str1, str2));
    }
}
