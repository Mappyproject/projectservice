package com.mappy.projectservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime uploadDate;
    @ElementCollection
    private List<Long> tag_ids;
    @ElementCollection
    private List<Long> event_ids;

    public Project(String name, List<Long> tag_ids, List<Long> event_ids) {
        this.name = name;
        this.tag_ids = tag_ids;
        this.event_ids = event_ids;
    }
}
