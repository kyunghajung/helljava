package main.java.model;

/**
 * Created by junghk on 2016. 7. 28..
 */
public class Member {

    private String id;
    private String pwd;

    public Member(){

    }

    public Member(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public Member(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
