package com.wgh.mvpframework.network.model;

/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/10
 * @description
 */
public class TestModel extends BaseModel {

    private String username;
    private String pwd;

    public TestModel(String username, String pwd) {
        this.username = username;
        this.pwd = pwd;
    }
}
