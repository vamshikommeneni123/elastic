package com.example.service.impl;

import com.example.dbhelper.DBHelper;
import com.example.pojo.Info;
import com.example.service.InfoService;

import java.util.List;
import java.util.UUID;

public class InfoServiceImpl implements InfoService {


    @Override
    public List<Info> findAll() {
        return null;
    }

    @Override
    public int insert(Info info) {
        return 0;
    }

    @Override
    public int jdbcInsert(Info info){
        String sql = "insert into t_info(id,topic, message,insert_date) values(?,?,?,now());";
        Object []values = {UUID.randomUUID ().toString ().replaceAll ("-",""),"zrh","12345"};
        int r = DBHelper.insert (sql,values);
        return r;
    }

}
