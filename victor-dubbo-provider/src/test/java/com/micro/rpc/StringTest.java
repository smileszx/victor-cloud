package com.micro.rpc;

import org.junit.Test;

/**
 * @Description
 * 测试String相关
 * javap -verbose StringTest.class
 * StringBuffer 和 StringBuilder 二者都继承了 AbstractStringBuilder ，底层都是利用可修改的char数组(JDK 9 以后是 byte数组)。
 * @Author victor su
 * @Date 2019/10/26 23:08
 **/
public class StringTest {

    @Test
    public void testString () {
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s1 == s2);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s1.equals(s2));
    }
    @Test
    public void testStringBuffer () {
        // StringBuffer就是为了解决大量拼接字符串时产生很多中间对象问题而提供的一个类
        // 本质是一个线程安全的可修改的字符序列，把所有修改数据的方法都加上了synchronized。
        // 但是保证了线程安全是需要性能的代价的。
        StringBuffer buffer = new StringBuffer();
        buffer.append(1);
    }

    @Test
    public void testStringBuilder () {
        // 很多情况下我们的字符串拼接操作不需要线程安全，这时候StringBuilder登场
        // StringBuilder是JDK1.5发布的，它和StringBuffer本质上没什么区别，就是去掉了保证线程安全的那部分，减少了开销。
        StringBuilder builder = new StringBuilder();

        String b1 = 1 + 2 + "bug";
        System.out.println(b1);

        String b2 = "bug" + 3 + 4;
        System.out.println(b2);
    }
}
