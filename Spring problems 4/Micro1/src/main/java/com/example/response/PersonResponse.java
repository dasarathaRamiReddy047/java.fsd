package com.example.response;

public class PersonResponse {
    
    private Integer Id;
    private String name;
    private Integer age;
    private String hobby;
    public Integer getPersonId() {
        return Id;
    }
    public void setPersonId(Integer personId) {
        this.Id = personId;
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
    public String getHobby() {
        return hobby;
    }
    public void setHobby(String result) {
        this.hobby = result;
    }
}


