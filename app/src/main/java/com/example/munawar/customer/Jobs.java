package com.example.munawar.customer;

public class Jobs {

    String jobname;
    String money;
    String man;


    public Jobs(){

    }

    public Jobs(String jobname, String money, String man) {
        this.jobname = jobname;
        this.money = money;
        this. man = man;

    }

    public String getJobname() {
        return jobname;
    }

    public String getMoney() {
        return money;
    }

    public String getMan() {
        return man;
    }

}
