package com.thoughtworks.university.Biblioteca;

public class User {
    private String name;
    private String email;
    private String phoneNo;
    private String libraryNo;
    private String phone;

    public User() {
    }
    public void setUser(String name, String email, String phoneNo, String libraryNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.libraryNo = libraryNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLibraryNo() {
        return libraryNo;
    }
}
