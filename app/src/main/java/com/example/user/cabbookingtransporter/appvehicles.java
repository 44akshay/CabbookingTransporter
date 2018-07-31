package com.example.user.cabbookingtransporter;

/**
 * Created by User on 28/07/2018.
 */

public class appvehicles {
    private String empid,carno,carname;

    public String getEmpid() {
        return empid;
    }

    public String getCarno() {
        return carno;
    }

    public String getCarname() {
        return carname;
    }

    public appvehicles(String empid, String carno, String carname) {
        this.empid = empid;
        this.carno = carno;
        this.carname = carname;

    }
}
