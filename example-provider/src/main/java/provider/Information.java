package provider;

import java.util.HashMap;
import java.util.Map;

// TODO - Lombok
public class Information {

    private Integer salary;
    private String name;
    private String nationality;
    private String skills;
    private Map<String, String> contact = new HashMap<String, String>();
    private String age;
    private String relatives;

    public void setSkills(String skills) { this.skills = skills; }

    public String getSkills() { return this.skills; }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getContact() {
        return contact;
    }

    public void setContact(Map<String, String> contact) {
        this.contact = contact;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    public String getRelatives() {
        return relatives;
    }

}
