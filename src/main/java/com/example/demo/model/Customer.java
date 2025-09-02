package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name="customer_name",nullable = false)
        private String name;

        @Column(name="customer_surname", nullable = false)
        private String surname;

        @Column(name="customer_username",nullable = false,unique = true)
        private String username;


        @Column(name="customer_email",nullable = false,unique = true)
        private String email;

        @CreationTimestamp
        @Column(nullable = false,updatable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDateTime createdAt;

        @UpdateTimestamp
        @Column(nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDateTime updateAt;





}
