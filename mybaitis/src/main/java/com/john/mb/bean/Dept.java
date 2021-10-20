package com.john.mb.bean;

import java.io.Serializable;
import java.util.List;

public class Dept implements Serializable {
   Integer deptno;
   String deptname;
   String dloc;
   List<Emp> emps;

   public Integer getDeptno() {
      return deptno;
   }

   public void setDeptno(Integer deptno) {
      this.deptno = deptno;
   }

   public String getDeptname() {
      return deptname;
   }

   public void setDeptname(String deptname) {
      this.deptname = deptname;
   }

   public String getDloc() {
      return dloc;
   }

   public void setDloc(String dloc) {
      this.dloc = dloc;
   }

   public List<Emp> getEmps() {
      return emps;
   }

   public void setEmps(List<Emp> emps) {
      this.emps = emps;
   }

   @Override
   public String toString() {
      return "Dept{" +
              "deptno=" + deptno +
              ", deptname='" + deptname + '\'' +
              ", dloc='" + dloc + '\'' +
              ", emps=" + emps +
              '}';
   }
}
