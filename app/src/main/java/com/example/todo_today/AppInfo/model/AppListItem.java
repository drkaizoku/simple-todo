package com.example.todo_today.AppInfo.model;

//this is a model class..
public class AppListItem {

    private String head;
    private String desc;

    public AppListItem(String head, String desc) {
        this.head = head;
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}
