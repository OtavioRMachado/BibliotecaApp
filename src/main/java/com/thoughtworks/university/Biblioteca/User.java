package com.thoughtworks.university.Biblioteca;

public class User {
    private String name;
    private String email;
    private String phoneNo;
    private String libraryNo;

    public User(String name, String email, String phoneNo, String libraryNo) {
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
        return phoneNo;
    }

    public String getLibraryNo() {
        return libraryNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phoneNo = phone;
    }

    public void setLibraryNo(String libraryNo) {
        this.libraryNo = libraryNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        return String.format("User %s\nName: %s\nE-mail: %s\nPhone No: %s", libraryNo, name, email, phoneNo);
    }
=======
>>>>>>> abfa025a4c8e07a43fbd556d4dfa21ad46e1a990
}
