package com.api_sanchez.api_todo_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 100)
        private String name;

        @Column(nullable = false, length = 250)
        private String password;

        public User(){}

        public User(Long id, String name){
                this.id = id;
                this.name = name;
        }

        public String getName() {
                return name;
        }


        public Long getId() {
                return id;
        }

        public void setId(Long id){
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
