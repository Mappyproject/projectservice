package com.mappy.projectservice.service;

import com.mappy.projectservice.models.Project;
import com.mappy.projectservice.repository.IProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private IProjectRepository mockProjectRepository;

    private ProjectService projectServiceUnderTest;

    @BeforeEach
    void setUp() {
        projectServiceUnderTest = new ProjectService(mockProjectRepository);
    }

    @Test
    void testSave() {
        // Setup
        final Project project = new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L),
                List.of(0L));
        final Project expectedResult = new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L),
                List.of(0L));

        // Configure IProjectRepository.save(...).
        final Project project1 = new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L),
                List.of(0L));
        when(mockProjectRepository.save(
                new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L), List.of(0L))))
                .thenReturn(project1);

        // Run the test
        final Project result = projectServiceUnderTest.save(project);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAll() {
        // Setup
        // Configure IProjectRepository.findAll(...).
        final Iterable<Project> projects = List.of(
                new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L), List.of(0L)));
        when(mockProjectRepository.findAll()).thenReturn(projects);

        // Run the test
        final Iterable<Project> result = projectServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetAll_IProjectRepositoryReturnsNoItems() {
        // Setup
        when(mockProjectRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final Iterable<Project> result = projectServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetById() {
        // Setup
        final Optional<Project> expectedResult = Optional.of(
                new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L), List.of(0L)));

        // Configure IProjectRepository.findById(...).
        final Optional<Project> project = Optional.of(
                new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L), List.of(0L)));
        when(mockProjectRepository.findById(0L)).thenReturn(project);

        // Run the test
        final Optional<Project> result = projectServiceUnderTest.getById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetById_IProjectRepositoryReturnsAbsent() {
        // Setup
        when(mockProjectRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final Optional<Project> result = projectServiceUnderTest.getById(0L);

        // Verify the results
        assertThat(result).isEmpty();
    }

    @Test
    void testUpdate() {
        // Setup
        final Project project = new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L),
                List.of(0L));
        final Project expectedResult = new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L),
                List.of(0L));

        // Configure IProjectRepository.save(...).
        final Project project1 = new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L),
                List.of(0L));
        when(mockProjectRepository.save(
                new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L), List.of(0L))))
                .thenReturn(project1);

        // Run the test
        final Project result = projectServiceUnderTest.update(project);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDelete() {
        // Setup
        final Project project = new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L),
                List.of(0L));

        // Run the test
        projectServiceUnderTest.delete(project);

        // Verify the results
        verify(mockProjectRepository).delete(
                new Project(0L, "name", LocalDateTime.of(2020, 1, 1, 0, 0, 0), List.of(0L), List.of(0L)));
    }
}
