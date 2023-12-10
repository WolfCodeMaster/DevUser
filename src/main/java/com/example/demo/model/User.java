package com.example.demo.model;

 
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APP_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String name;

    @Email(message = "El correo electrónico debe tener un formato válido")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message = "El correo electrónico no cumple con el formato requerido")
    private String email;

    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
    
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "last_login")
    private Date lastLogin;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "session_token")
    private String session_token;
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Phones> phones;
    
    
}
