package com.example.user.cabbookingtransporter;

/**
 * Created by User on 20/07/2018.
 */

public class cardetails {
    String carname,carno,empid;

    public String getCarname() {
        return carname;
    }

    public String getCarno() {
        return carno;
    }

    public String getEmpid() {
        return empid;
    }

    public cardetails(String carname, String carno, String empid) {
        this.carname = carname;
        this.carno = carno;
        this.empid = empid;

    }
}
