package com.mappy.projectservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private Long id;
    private String name;
    private LocalDateTime uploadDate;
}
