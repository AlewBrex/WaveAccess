package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room
{
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "number", nullable = false, columnDefinition = "INT")
    private Integer number;

    @Column(name = "size", nullable = false, columnDefinition = "INT")
    private Integer size;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Set<Presentation> presentations;
}