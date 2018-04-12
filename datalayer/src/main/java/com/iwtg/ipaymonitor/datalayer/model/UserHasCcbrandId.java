package com.iwtg.ipaymonitor.datalayer.model;
// Generated 11/04/2018 12:27:58 AM by Hibernate Tools 4.3.1



/**
 * UserHasCcbrandId generated by hbm2java
 */
public class UserHasCcbrandId  implements java.io.Serializable {


     private int userId;
     private String brandCode;

    public UserHasCcbrandId() {
    }

    public UserHasCcbrandId(int userId, String brandCode) {
       this.userId = userId;
       this.brandCode = brandCode;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getBrandCode() {
        return this.brandCode;
    }
    
    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserHasCcbrandId) ) return false;
		 UserHasCcbrandId castOther = ( UserHasCcbrandId ) other; 
         
		 return (this.getUserId()==castOther.getUserId())
 && ( (this.getBrandCode()==castOther.getBrandCode()) || ( this.getBrandCode()!=null && castOther.getBrandCode()!=null && this.getBrandCode().equals(castOther.getBrandCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getUserId();
         result = 37 * result + ( getBrandCode() == null ? 0 : this.getBrandCode().hashCode() );
         return result;
   }   


}

