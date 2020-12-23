package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login", nullable = false, columnDefinition = "VARCHAR(255)")
    private String login;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_users", nullable = false, columnDefinition = "ENUM")
    private Set<Roles> roleUsers;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(255)")
    private String password;

    @Column(name = "e_mail", nullable = false, columnDefinition = "VARCHAR(255)")
    private String email;

    @Column(name = "surname", nullable = false, columnDefinition = "VARCHAR(255)")
    private String surname;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "patronymic", nullable = false, columnDefinition = "VARCHAR(255)")
    private String patronymic;

    @OneToMany(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Set<Presentation> presentations;

    public enum Roles
    {
        ADMIN,
        PRESENTER,
        LISTENER
    }
}