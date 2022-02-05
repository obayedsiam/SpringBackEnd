package com.springrest.springrest.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "TvDetails")
public class TvDetails {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column (name = "mobile_number")
    private String mobileNumber;

    @Column (name = "serial_number")
    private String serialNumber;

    @Column (name = "call_status")
    private String callStatus;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column (name = "date_created")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public TvDetails() {
        super();
    }

    public TvDetails(String mobileNumber, String serialNumber, String callStatus, Date dateCreated) {
        this.mobileNumber = mobileNumber;
        this.serialNumber = serialNumber;
        this.callStatus = callStatus;
        this.date = dateCreated;
    }

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber=mobileNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String toString() {
        return "TvDetails {" +
                "id=" + id +
                "Mobile Number=" + mobileNumber +
                ", Serial Number='" + serialNumber + '\'' +
                ", Call Status='" + callStatus + '\'' +
                ", Date Created='" + date + '\'' +
                '}';
    }
}
