package com.mritech.jasperreport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USERS")
@Builder
public class Users {  //implements UserDetails
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String mobile;
    private String gender;
    private Integer age;
    private LocalDateTime dateOfBirth;
}
