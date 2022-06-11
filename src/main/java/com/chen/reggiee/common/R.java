package com.chen.reggiee.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据


    //泛型方法 所有泛型方法声明都有《一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前》》（在下面例子中的 <T>）。
    //每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
    //类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
    //泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像 int、double、char 等）。
    public static <T> R<T> success(T object) {  //T为泛型可以是任意一个类型
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
