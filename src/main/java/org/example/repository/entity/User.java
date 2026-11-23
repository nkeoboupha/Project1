package org.example.repository.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="bank_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    @Column(nullable = false)
    private String userType;

    @ManyToMany
    @JoinTable(
            name="hasAccount",
            joinColumns = @JoinColumn(name="userId"),
            inverseJoinColumns = @JoinColumn(name="accountId")
    )
    private Set<Account> accounts = new HashSet<>();

    public User(){}

    public User(
            Integer userId,
            String username,
            String password,
            String fname,
            String lname,
            String userType
    ){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.userType = userType;
    }

    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getLname(){
        return lname;
    }
    public void setLname(String lname){
        this.lname = lname;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname){
        this.fname = fname;
    }
    public String getUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType = userType;
    }
    public Set<Account> getAccounts(){
        return accounts;
    }
    public void setAccounts(Set<Account> accounts){
        this.accounts = accounts;
    }
    public void registerAccount(Account account){
        accounts.add(account);
    }

}
