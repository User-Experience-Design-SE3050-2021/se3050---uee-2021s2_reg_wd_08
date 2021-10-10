package com.example.loginregister;

public class RegisterHelper {
    String uid,mobile,email,password,fname,lname,nic;

    public RegisterHelper(String mobile, String email, String password, String fname, String lname, String nic) {
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
    }

    public RegisterHelper(String uid, String mobile, String email, String password, String fname, String lname, String nic) {
        this.uid = uid;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.nic = nic;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

}
