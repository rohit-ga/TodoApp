package com.todoapp.bean;

public class User {

    private int uid;
    private String userfname;
    private String userlname;
    private String usergender;
    private String usercontact;
    private String useremail;
    private String userpassword;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserfname() {
        return userfname;
    }

    public void setUserfname(String userfname) {
        this.userfname = userfname;
    }

    public String getUserlname() {
        return userlname;
    }

    public void setUserlname(String userlname) {
        this.userlname = userlname;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        this.usercontact = usercontact;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "User [uid=" + uid + ", userfname=" + userfname + ", userlname=" + userlname + ", usergender="
                + usergender + ", usercontact=" + usercontact + ", useremail=" + useremail + ", userpassword="
                + userpassword + "]";
    }

}
