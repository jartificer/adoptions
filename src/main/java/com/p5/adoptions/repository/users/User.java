package com.p5.adoptions.repository.users;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    public Integer getId()
    {
        return id;
    }

    public User setId(Integer id)
    {
        this.id = id;
        return this;
    }

    public String getEmail()
    {
        return email;
    }

    public User setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    public User setPassword(String password)
    {
        this.password = password;
        return this;
    }
}
