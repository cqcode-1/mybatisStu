package com.john.mb.bean;

import java.util.Date;

public class Emp {
   private Integer empno;
   private String ename;
   private String job;
   private String mgr;
   private Date hiredate;
   private double sal;
   private double comm;
   private String deptno;

   public Integer getEmpno() {
      return empno;
   }

   public void setEmpno(Integer empno) {
      this.empno = empno;
   }

   public String getEname() {
      return ename;
   }

   public void setEname(String ename) {
      this.ename = ename;
   }

   public String getJob() {
      return job;
   }

   public void setJob(String job) {
      this.job = job;
   }

   public String getMgr() {
      return mgr;
   }

   public void setMgr(String mgr) {
      this.mgr = mgr;
   }

   public Date getHiredate() {
      return hiredate;
   }

   public void setHiredate(Date hiredate) {
      this.hiredate = hiredate;
   }

   public double getSal() {
      return sal;
   }

   public void setSal(double sal) {
      this.sal = sal;
   }

   public double getComm() {
      return comm;
   }

   public void setComm(double comm) {
      this.comm = comm;
   }

   public String getDeptno() {
      return deptno;
   }

   public void setDeptno(String deptno) {
      this.deptno = deptno;
   }

   @Override
   public String toString() {
      return "Emp{" +
              "empno=" + empno +
              ", ename='" + ename + '\'' +
              ", job='" + job + '\'' +
              ", mgr='" + mgr + '\'' +
              ", hiredate=" + hiredate +
              ", sal=" + sal +
              ", comm=" + comm +
              ", deptno='" + deptno + '\'' +
              '}';
   }
}
