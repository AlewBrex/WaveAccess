package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule
{
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Column(name = "room_id", nullable = false, columnDefinition = "INT")
    private Room room;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Column(name = "presentation_id", nullable = false, columnDefinition = "INT")
    private Presentation presentation;

    @Column(name = "start", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime start;

    @Column(name = "end", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime end;
}