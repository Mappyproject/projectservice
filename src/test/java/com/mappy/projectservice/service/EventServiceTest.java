package com.mappy.projectservice.service;

import com.mappy.projectservice.models.Event;
import com.mappy.projectservice.repository.IEventRepository;
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
class EventServiceTest {

    @Mock
    private IEventRepository mockEventRepository;

    private EventService eventServiceUnderTest;

    @BeforeEach
    void setUp() {
        eventServiceUnderTest = new EventService(mockEventRepository);
    }

    @Test
    void testSave() {
        // Setup
        final Event event = new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        final Event expectedResult = new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0));

        // Configure IEventRepository.save(...).
        final Event event1 = new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(mockEventRepository.save(
                new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0)))).thenReturn(event1);

        // Run the test
        final Event result = eventServiceUnderTest.save(event);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAll() {
        // Setup
        // Configure IEventRepository.findAll(...).
        final Iterable<Event> events = List.of(
                new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0)));
        when(mockEventRepository.findAll()).thenReturn(events);

        // Run the test
        final Iterable<Event> result = eventServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetAll_IEventRepositoryReturnsNoItems() {
        // Setup
        when(mockEventRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final Iterable<Event> result = eventServiceUnderTest.getAll();

        // Verify the results
    }

    @Test
    void testGetById() {
        // Setup
        final Optional<Event> expectedResult = Optional.of(
                new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0)));

        // Configure IEventRepository.findById(...).
        final Optional<Event> event = Optional.of(
                new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0)));
        when(mockEventRepository.findById(0L)).thenReturn(event);

        // Run the test
        final Optional<Event> result = eventServiceUnderTest.getById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetById_IEventRepositoryReturnsAbsent() {
        // Setup
        when(mockEventRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final Optional<Event> result = eventServiceUnderTest.getById(0L);

        // Verify the results
        assertThat(result).isEmpty();
    }

    @Test
    void testUpdate() {
        // Setup
        final Event event = new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        final Event expectedResult = new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0));

        // Configure IEventRepository.save(...).
        final Event event1 = new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        when(mockEventRepository.save(
                new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0)))).thenReturn(event1);

        // Run the test
        final Event result = eventServiceUnderTest.update(event);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDelete() {
        // Setup
        final Event event = new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0));

        // Run the test
        eventServiceUnderTest.delete(event);

        // Verify the results
        verify(mockEventRepository).delete(new Event(0L, "name", "description", LocalDateTime.of(2020, 1, 1, 0, 0, 0)));
    }
}
