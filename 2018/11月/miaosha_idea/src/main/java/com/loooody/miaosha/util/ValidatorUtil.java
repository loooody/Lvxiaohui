package com.loooody.miaosha.util;

import org.thymeleaf.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    public static boolean isMobile(String string) {
        if (StringUtils.isEmpty(string)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(string);
        return m.matches();

    }

    public static void main(String[] args) {
        System.out.println(isMobile("13112341234"));
        System.out.println(isMobile("1311231231"));
    }
}
