package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "presentation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Presentation
{
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "theme",nullable = false, columnDefinition = "VARCHAR(255)")
    private String theme;

    @Column(name = "content",nullable = false, columnDefinition = "VARCHAR(255)")
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "user_id",nullable = false, columnDefinition = "VARCHAR(255)")
    private Set<User> users;

}