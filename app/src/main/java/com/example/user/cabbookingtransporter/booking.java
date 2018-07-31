package com.example.user.cabbookingtransporter;

/**
 * Created by User on 15/07/2018.
 */

public class booking {
    private String name;
    private String from;
    private String to;
    private String pickup;
    private String no;
    private String phn,empid;
    private String type;
    private String designation;
    private String fromdate,todate,jobband;

    public String getName() {
        return name;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getPickup() {
        return pickup;
    }

    public String getNo() {
        return no;
    }

    public String getPhn() {
        return phn;
    }

    public String getType() {
        return type;
    }

    public String getDesignation() {
        return designation;
    }

    public String getFromdate() {
        return fromdate;
    }

    public String getTodate() {
        return todate;
    }
    public String getJobband() {
        return jobband;
    }

    public String getEmpid() {
        return empid;
    }

    public booking(String name, String from, String to, String pickup, String no,
                   String phn, String type, String designation, String fromdate, String todate, String jobband, String empid) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.pickup = pickup;
        this.no = no;
        this.phn = phn;
        this.type = type;
        this.designation = designation;
        this.fromdate = fromdate;

        this.todate = todate;
        this.jobband = jobband;
    }
    public booking()
    {

    }
}
