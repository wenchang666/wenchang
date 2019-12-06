package com.xd.bean;

import java.io.Serializable;
import java.util.Date;

/**
@author wc
@create 2019-12-04-17:41
*/
public class Emp implements Serializable {
    private Integer empno;

    private String name;

    private Integer sal;

    private Date hiredate;

    private String job;

    private static final long serialVersionUID = 1L;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", empno=").append(empno);
        sb.append(", name=").append(name);
        sb.append(", sal=").append(sal);
        sb.append(", hiredate=").append(hiredate);
        sb.append(", job=").append(job);
        sb.append("]");
        return sb.toString();
    }
}