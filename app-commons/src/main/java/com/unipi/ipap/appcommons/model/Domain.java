package com.unipi.ipap.appcommons.model;

import java.util.List;

public class Domain {

    private String domain;
    private String createDate;
    private String updateDate;
    private String country;
    private Boolean isDead;
    private List<String> a = null;
    private List<String> ns = null;
    private Object cname;
    private List<Mx> mx = null;
    private List<String> txt = null;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(Boolean isDead) {
        this.isDead = isDead;
    }

    public List<String> getA() {
        return a;
    }

    public void setA(List<String> a) {
        this.a = a;
    }

    public List<String> getNs() {
        return ns;
    }

    public void setNs(List<String> ns) {
        this.ns = ns;
    }

    public Object getCname() {
        return cname;
    }

    public void setCname(Object cname) {
        this.cname = cname;
    }

    public List<Mx> getMx() {
        return mx;
    }

    public void setMx(List<Mx> mx) {
        this.mx = mx;
    }

    public List<String> getTxt() {
        return txt;
    }

    public void setTxt(List<String> txt) {
        this.txt = txt;
    }

}
