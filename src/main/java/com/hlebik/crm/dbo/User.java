package com.hlebik.crm.dbo;

import com.hlebik.crm.enumerated.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name ="user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Role> roles;
}
