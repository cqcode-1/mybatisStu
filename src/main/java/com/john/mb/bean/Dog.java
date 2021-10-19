package com.john.mb.bean;

public class Dog {

   Integer id;
   String name;
   Integer age;
   String gender;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   @Override
   public String toString() {
      return "Dog{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", age=" + age +
              ", gender='" + gender + '\'' +
              '}';
   }
}
