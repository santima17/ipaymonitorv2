package com.iwtg.ipaymonitor.datalayer.model;
// Generated 11/04/2018 12:27:58 AM by Hibernate Tools 4.3.1



/**
 * Status generated by hbm2java
 */
public class Status  implements java.io.Serializable {


     private String code;
     private String name;

    public Status() {
    }

	
    public Status(String code) {
        this.code = code;
    }
    public Status(String code, String name) {
       this.code = code;
       this.name = name;
    }
   
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


