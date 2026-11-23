package org.example.repository.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(nullable = false)
    private String status;

    @ManyToMany(mappedBy="accounts")
    private Set<User> users = new HashSet<>();

    public Account(){}

    public Account(Integer accountId, String status){
        this.accountId = accountId;
        this.status = status;
    }

    public Integer getAccountId(){
        return accountId;
    }
    public void setAccountId(Integer accountId){
        this.accountId = accountId;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public Set<User> getUsers(){
        return users;
    }
    public void setUsers(Set<User> users){
        this.users = users;
    }
}
