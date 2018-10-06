package com.ruiyi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruiyi.model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//HTMLDocument

public class JsonDemo {
    private List<Person> list;

    public static void main(String[] args) {
        JsonToObj();
    }

    static void ObjToJson() {
        Person person = new Person(1, "小云儿", 26);

        String json = JSON.toJSON(person).toString();
        System.out.println(json);
    }

    static void JsonToObj() {
        String json = "{\"name\":\"小云儿\",\"id\":1,\"age\":26}";
        Person person = JSON.parseObject(json, Person.class);
        System.out.println(person);

        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println(jsonObject.getClass().getName());
        System.out.println(jsonObject);
        System.out.println(jsonObject.getShort("id"));
        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.get("age"));


        Object obj = JSON.parse(json);
        System.out.println(obj.getClass().getName());
        System.out.println(obj);
        System.out.println((( JSONObject ) obj).getShort("id"));
        System.out.println((( JSONObject ) obj).getString("name"));
        System.out.println((( JSONObject ) obj).get("age"));
    }


    static void ListToJson() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person(2, "小明", 23));
        list.add(new Person(4, "小红", 14));
        list.add(new Person(6, "小雪", 43));
        list.add(new Person(8, "小云", 12));
        list.add(new Person(0, "小王", 23));
        list.add(new Person(1, "小胡", 38));
        list.add(new Person(3, "小周", 23));
        list.add(new Person(5, "小青", 20));
        list.add(new Person(7, "小马", 15));
        String json = JSON.toJSON(list).toString();
        System.out.println(json);
    }

    static void JsonToList() {
        String strJson = "[{\"name\":\"小明\",\"id\":2,\"age\":23},{\"name\":\"小红\",\"id\":4,\"age\":14},{\"name\":\"小雪\",\"id\":6,\"age\":43},{\"name\":\"小云\",\"id\":8,\"age\":12},{\"name\":\"小王\",\"id\":0,\"age\":23},{\"name\":\"小胡\",\"id\":1,\"age\":38},{\"name\":\"小周\",\"id\":3,\"age\":23},{\"name\":\"小青\",\"id\":5,\"age\":20},{\"name\":\"小马\",\"id\":7,\"age\":15}]";

        JSONArray jsonArray = ( JSONArray ) JSON.parse(strJson);
        Iterator iterator = jsonArray.iterator();
        System.out.println("1:*************************************************************");

        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.format("[%d] = %s\n", i, jsonArray.get(i));
        }

        System.out.println("2:*************************************************************");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("3:*************************************************************");

        List<Person> list = jsonArray.toJavaList(Person.class);
        for (Person person : list) {
            System.out.println(person);
        }

        System.out.println("4:*************************************************************");

        //Object[] toArray()
        //<T> T[] toArray(T[] a)
    }
}
