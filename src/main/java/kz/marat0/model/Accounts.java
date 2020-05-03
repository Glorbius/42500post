package kz.marat0.model;

import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "accountshelp", type = "peoples")
public class Accounts {

    private int id;
    private String name;
    private String surname;
    private int age;
    private long iin;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIin() {
        return iin;
    }

    public void setIin(long iin) {
        this.iin = iin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Accounts(int id, long iin, String name, String surname, int age, boolean status) {
        this.id = id;
        this.iin = iin;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.status = status;
    }

    public Accounts() {
    }
}
