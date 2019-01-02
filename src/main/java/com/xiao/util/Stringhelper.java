package com.xiao.util;

public class Stringhelper {
    private Stringhelper(){}
    public  static  boolean  isNullOrEmpty(String str){
        if (null == str || "".equals(str)){
            return true;
        }else{
            return false;
        }
    }
}
