package com.example.Unfiled;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test_String {

    static class StringConcat {
        String s1;
        String s2;

        StringConcat(String str1, String str2) {
            s1 = str1;
            s2 = str2;
        }

        public String toString() {
            return s1 + s2;
        }
    }


    @Test
    public void StringEditorTester() {
        String original = "Hello123, My Name is Mark, 234I think you are my classmate?!!";
        System.out.println(removeNonLetters(original));
    }

    // 读程序练习：已知一个字符串，返回将字符串中的非字母字符都删除后的字符串
    public String removeNonLetters(String original) {
        StringBuffer aBuffer = new StringBuffer(original.length());
        char aCharacter;
        for (int i = 0; i < original.length(); i++) {
            aCharacter = original.charAt(i);
            if (Character.isLetter(aCharacter)) {
                aBuffer.append(aCharacter);
            }
        }
        return new String(aBuffer);
    }

    @Test
    public void CharacterDemo() {
        System.out.println(Character.isLowerCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isSpaceChar(' '));
        System.out.println(Character.isSpaceChar('x'));
    }

    @Test
    public void StringAddDemo() {
        String s1, s2, s3;

        s1 = new String("hello ");
        s2 = new String("world!");
        s3 = s1 + s2;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    @Test
    public void StringLenDemo() {
        String s1 = "Hello,Java!";
        String s2 = new String("你好,Java");
        int len1 = s1.length();
        int len2 = s2.length();
        System.out.println("字符串s1长度为" + len1);
        System.out.println("字符串s2长度为" + len2);

    }

    @Test
    public void StringBufferLenDemo() {
        StringBuffer s1 = new StringBuffer("Hello,Java!");
        System.out.println("长度：" + s1.length());
        System.out.println("容量：" + s1.capacity());
        s1.setLength(100);
        System.out.println("新长度：" + s1.length());
    }

    @Test
    public void StrEqualDemo1() {
        String s1 = "Java";
        String s2 = "Java";
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
    }

    @Test
    public void StrEqualDemo2() {
        String s1 = "Java";
        String s2;
        s2 = s1;
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
    }

    @Test
    public void StrEqualDemo3() {
        String s1 = "Java";
        String s2 = new String("Java");
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }

        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }
    }

    @Test
    public void StrEqualDemo4() {
        String s1 = "Java";
        String s2 = new String("Java");
        s2 = s2.intern();
        if (s1 == s2)
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        if (s1.equals(s2))
            System.out.println("s1 equals s2");
        else
            System.out.println("s1 not equals s2");
    }

    @Test
    public void StrConcatDemo() {
        String s1 = "Hello";
        String s2 = s1 + ",";
        String s3 = s2.concat(" Java");
        String s4 = new String(" ! ");
        String s5 = s3.concat(s4);
        System.out.println(" 连接而成的字符串是" + s5);
    }

    @Test
    public void StrCopyDemo() {
        String s1 = new String();
        char data[] = {'a', 'b', 'c', 'd', 'e', 'f'};
        s1 = String.copyValueOf(data);
        System.out.println(" s1=" + s1);
        s1 = String.copyValueOf(data, 2, 3);
        System.out.println(" s1=" + s1);
        s1.getChars(1, 2, data, 0);
        System.out.println(" data=" + String.copyValueOf(data));
        data = s1.toCharArray();
        System.out.println(" data=" + String.copyValueOf(data));
        String s2 = new String();
        String s3 = new String();
        s2 = s1.substring(0);
        System.out.println(" s2=" + s2);
        s3 = s1.substring(1, 2);
        System.out.println(" s3=" + s3);

    }

    @Test
    public void StrSearchDemo() {
        String s1 = "Javav";
        char c = s1.charAt(2);
        System.out.println("c=" + c);
        int i = s1.indexOf('a');
        System.out.println("fistchar=" + i);
        int j = s1.lastIndexOf('a');
        System.out.println("lastchar=" + j);
        i = s1.indexOf("av");
        System.out.println("fiststring=" + i);
        j = s1.lastIndexOf("av");
        System.out.println("laststring=" + j);
    }

    @Test
    public void StringConcatDemo() {
        StringConcat s = new StringConcat("cool", "java");
        System.out.println(s);
    }

    @Test
    public void StrtoInt() {
        String str = "123";
        int i = Integer.parseInt(str);
        System.out.println(i);
    }

    @Test
    public void StringBufferDemo() {
        StringBuffer s1 = new StringBuffer();
        s1.append("Hello,Java!");
        System.out.println("s1=" + s1);
        StringBuffer s2 = new StringBuffer(10);
        s2.insert(0, "Hello,Java!");
        System.out.println("s2=" + s2);
        StringBuffer s3 = new StringBuffer("Hello,Java!");
        System.out.println("s3=" + s3);
    }

    @Test
    public void StringBufferChange() {
        StringBuffer s1 = new StringBuffer("Hallo,Java!");
        s1.setCharAt(1, 'e');
        System.out.println(s1);
        s1.replace(1, 5, "i");
        System.out.println(s1);
        s1.delete(0, 3);
        System.out.println(s1);
        s1.deleteCharAt(4);
        System.out.println(s1);
    }

    @Test
    public void SimpleDateFormatDemo() {
        Date date = new Date();
        long longtime = date.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat format4 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format5 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format6 = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat format7 = new SimpleDateFormat("yyyy");

        System.out.println(format1.format(longtime));
        System.out.println(format2.format(longtime));
        System.out.println(format3.format(longtime));
        System.out.println(format4.format(longtime));
        System.out.println(format5.format(longtime));
        System.out.println(format6.format(longtime));
        System.out.println(format7.format(longtime));
    }

    @Test
    public void CalendarDemo() {
        System.out.println(" 日   一   二   三   四   五  六");
        Calendar rili = Calendar.getInstance();
        rili.set(2018, 3, 1);
        int xingqi = rili.get(Calendar.DAY_OF_WEEK) - 1;
        String a[] = new String[xingqi + 30];
        for (int i = 0; i < xingqi; i++) {
            a[i] = "**";
        }
        for (int i = xingqi, n = 1; i < xingqi + 30; i++) {
            if (n <= 9)
                a[i] = String.valueOf(n) + " ";
            else
                a[i] = String.valueOf(n);
            n++;
        }
        for (int i = 0; i < a.length; i++) {
            if (i % 7 == 0) {
                System.out.println("");
            }
            System.out.print(" " + a[i]);
        }
    }

    @Test
    public void DateFormatDemo() {
        Date date = new Date();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        DateFormat longDateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        DateFormat fullDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        System.out.println(shortDateFormat.format(date));
        System.out.println(mediumDateFormat.format(date));
        System.out.println(longDateFormat.format(date));
        System.out.println(fullDateFormat.format(date));
    }

    @Test
    public void IntInteger() {
        Integer num = 5; // 自动装箱操作
        int t = num; // 自动拆箱操作
        System.out.println(t * num);
    }

    @Test
    public void VectorDemo() {
        Vector<Number> vec = new Vector<Number>(3);
        System.out.println("旧的向量容量为：" + vec.capacity());
        vec.addElement(1);
        vec.addElement(2);
        vec.addElement(3);
        vec.addElement(2.78d);
        vec.addElement(2.78f);

        System.out.println("新的向量容量为:" + vec.capacity());
        System.out.println("向量大小为:" + vec.size());
        System.out.println("第一个元素为:" + (Integer) vec.firstElement());
        System.out.println("最后一个元素为:" + vec.lastElement());

        if (vec.contains(2)) {
            System.out.println("查找到值为2的元素");
        }
        vec.removeElementAt(1);
        if (!vec.contains(2)) {
            System.out.println("删除后没有发现值为2的元素");
        }
    }

    @Test
    public void ArrayListDemo() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) // 给数组增加10个Int元素
            list.add(i);
        list.remove(5);// 将第6个元素移除
        for (int i = 0; i < 3; i++) // 再增加3个元素
            list.add(i);
        Integer[] al = (Integer[]) list.toArray(new Integer[list.size()]);
        for (int i = 0; i < al.length; i++)
            System.out.print(al[i] + "  ");
    }

    @Test
    public void SortListDemo() {
        String[] arr = {"Now", "is", "the", "time", "for", "all", "good", "men", "to", "come", "to", "the", "aid",
                "of", "their", "country"};
        for (int j = 0; j < arr.length; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    String t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
            System.out.println(arr[j]);
        }
    }

    @Test
    public void IntegerTransleDemo() {
        int i = 10;
        Integer num = new Integer(i);
        int x = num.intValue();
        System.out.println("x=" + x);
    }

    @Test
    public void TokensDemo() {
        String s = "I am Geng.X.y,she is my girlfriend";
        StringTokenizer fenxi = new StringTokenizer(s, " ,");
        int number = fenxi.countTokens();
        while (fenxi.hasMoreTokens()) {
            String str = fenxi.nextToken();
            System.out.println(str);
            System.out.println("还剩" + fenxi.countTokens() + "个单词");
        }
        System.out.println("s 共有单词  " + number + "个");
    }

    @Test
    public void StringToBytes() {
        String str = "abcdefghijklmnopqrstuvwxyz";
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
    }

    @Test
    public void StringArray() {
        String str[] = new String[4];
        str[0] = "Amy";
        str[1] = "Dear";
        StringBuffer sb1 = new StringBuffer(str[0]);
        sb1.insert(0, str[1]);
        str[2] = new String(sb1);
        StringBuffer sb2 = new StringBuffer();
        sb2.append('D');
        sb2.append("Amy" + 74108206);
        sb2.insert(1, "ear");
        str[3] = new String(sb2);
        for (int i = 0; i < 4; i++) {
            System.out.println("str[" + i + "] =" + str[i]);
        }
    }

    @Test
    public void Other1() {
        String s01 = "luoyang huan ying ni.";
        String s02 = new String("mu dan hua cheng huan ying ni.");
        int len01 = s01.length();
        int len02 = s02.length();
        System.out.println("the length of s01 is:" + len01);
        System.out.println("the length of s02 is:" + len02);
        System.out.println("---------------------------");
        if (s01 == s02) {
            System.out.println("s01==s02");
        } else {
            System.out.println("s01!=s02");
        }
    }

    @Test
    public void Other2() {
        String s03 = "luoyang huan ying ni!";
        String s04 = new String("LUOYANG HUAN YING NI!");
        if (s03.equals(s04)) {
            System.out.println("s03 equals to s04");
        } else {
            System.out.println("s03 not equals to s04");
        }
        System.out.println("---------------------------");
        if (s03.equalsIgnoreCase(s04)) {
            System.out.println("s03 equals to s04");
        } else {
            System.out.println("s03 not equals to s04");
        }
        System.out.println("the ! index is : " + s03.indexOf('!'));
        System.out.println("城市名：" + s04.substring(0, 7));
        System.out.println("城市名：" + s03.toUpperCase());
        String s05 = "mudanhuacheng";
        System.out.println("城市名：" + s03.replace("luoyang", s05));
    }

    @Test
    public void Other3() {
        String s06 = "I am a student of haust,he is my classmate";
        StringTokenizer fenxi = new StringTokenizer(s06, " ,");
        int number = fenxi.countTokens();
        while (fenxi.hasMoreTokens()) {
            String str = fenxi.nextToken();
            System.out.println(str);
            System.out.println("还剩" + fenxi.countTokens() + "个单词");
        }
        System.out.println("s 共有单词  " + number + "个");
    }


    public void Other4() {
        int num1, num2, sum = 0;
        num1 = (int) (Math.random() * 10);
        num2 = (int) (Math.random() * 10);
        System.out.println(num1 + "+" + num2 + "=?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            sum = Integer.parseInt(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ((num1 + num2) == sum) {
            System.out.println("you are right! go on!");
        } else {
            System.out.println("I'm sorry to tell you,you are wrong!");
        }
    }

    @Test
    public void Other5() {
        String str1 = "Hello World";
        String str2 = "Hello World";

        String s1 = new String("Hello World");
        String s2 = new String("Hello World");

        System.out.println(str1.equals(str2));
        System.out.println(s1.equals(s2));

        System.out.println(str1.equals(s1));

        System.out.println(str1 == str2);
        System.out.println(s1 == s2);

        System.out.println(str1 == s1);

    }

    @Test
    public void Other6() {
        String name = "盖伦";
        int kill = 8;
        String title = "超神";
        String sentence = name + " 在进行了连续  " + kill + " 次击杀后，获得了 " + title + " 的称号 ";
        //直接使用+进行字符串连接，编码感觉会比较繁琐，并且维护性差，易读性差
        System.out.println(sentence);
        String sentenceFormat = "%s 在进行了连续 %d 次击杀后， 获得了 %s 的称号%n";
        //格式化输出，%s表示字符串，%d表示数字，%n表示换号
        System.out.printf(sentenceFormat, name, kill, title);
        System.out.format(sentenceFormat, name, kill, title);
        //format和printf能够达到一模一样的效果

        int year = 2020;
        System.out.format("%d%n", year);

        // 用%n或\n没差
        // 直接打印数字
        System.out.printf("%8d%n", year);

        // 用printf还是format没差
        // 总长度为8，默认右对齐
        System.out.printf("%-8d%n", year);

        // 总长度为8，默认左对齐
        System.out.printf("%08d%n", year);

        // 总长度为8，不够补0
        System.out.printf("%,8d%n", year * 10000);

        // 千位分隔符
        System.out.format("%.2f%n", Math.PI);
    }
}
