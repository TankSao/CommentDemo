package com.example.administrator.commentdemo;

/**
 * Created by Administrator on 2018/8/9.
 */

public class Comment {
    private String content;
    private String fromId,toId;
    private String fromName,toName;
    private String tag;
    public Comment(String fromId,String fromName,String toId,String toName,String content){
        this.fromId = fromId;
        this.fromName = fromName;
        this.toId = toId;
        this.toName = toName;
        this.content = content;
        this.tag = "false";
    }
    public Comment(String fromId,String fromName,String toId,String toName,String content,String tag){
        this.fromId = fromId;
        this.fromName = fromName;
        this.toId = toId;
        this.toName = toName;
        this.content = content;
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }

    public void setContent(String content,String tag) {
        this.tag = tag;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}
