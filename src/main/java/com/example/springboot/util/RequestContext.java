package com.example.springboot.util;

import java.io.Serializable;

public class    RequestContext implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private String transactionId;
    private Integer customerId;
    private String forwardedIp;
    private String culture;
    private String sessionToken;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getForwardedIp() {
        return forwardedIp;
    }

    public void setForwardedIp(String forwardedIp) {
        this.forwardedIp = forwardedIp;
    }


    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }


    @Override
    public String toString() {
        return "RequestContext{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId=" + customerId +
                ", forwardedIp='" + forwardedIp + '\'' +
                ", sessionToken='" + sessionToken + '\'' +
                ", culture='" + culture + '\'' +
                '}';
    }
}
