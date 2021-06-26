package com.example.consult;

public class model {

    String sid,sname,sprob,date,appoint;

    public model(String sid, String sname, String sprob, String date, String appoint) {
        this.sid = sid;
        this.sname = sname;
        this.sprob = sprob;
        this.date = date;
        this.appoint = appoint;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSprob() {
        return sprob;
    }

    public void setSprob(String sprob) {
        this.sprob = sprob;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAppoint() {
        return appoint;
    }

    public void setAppoint(String appoint) {
        this.appoint = appoint;
    }
}
