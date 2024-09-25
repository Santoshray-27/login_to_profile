package com.example.login_to_profile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "chatterhub")
public class Login_form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String username;
    private String name;
    private String bio;
    private String gender;
    private String password;

    @Lob
    private byte[] profilepic;
    @Transient
    private String profilepicurl;

    // Getter - Setter
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public byte[] getProfilepic() {
        return profilepic;
    }
    public void setProfilepic(byte[] profilepic) {
        this.profilepic = profilepic;
    }
    public String getProfilepicurl() {
        return profilepicurl;
    }
    public void setProfilepicurl(String profilepicurl) {
        this.profilepicurl = profilepicurl;
    }

}
