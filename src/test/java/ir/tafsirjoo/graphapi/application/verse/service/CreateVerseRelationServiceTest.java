package ir.tafsirjoo.graphapi.application.verse.service;

import ir.tafsirjoo.graphapi.application.verse.dto.CreateVerseRelationCommand;
import ir.tafsirjoo.graphapi.domain.verse.model.RelationType;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseReference;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;
import ir.tafsirjoo.graphapi.domain.verse.repository.VerseRelationRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;

class CreateVerseRelationServiceTest {

    @Test
    void should_create_and_save_verse_relation() {

        VerseRelationRepository repository =
                mock(VerseRelationRepository.class);

        CreateVerseRelationService service =
                new CreateVerseRelationService(repository);

        CreateVerseRelationCommand command =
                new CreateVerseRelationCommand(
                        new VerseReference(2, 255),
                        new VerseReference(2, 256),
                        RelationType.THEMATIC
                );

        VerseRelation savedRelation =
                VerseRelation.create(
                        command.source(),
                        command.target(),
                        command.type()
                );

        when(repository.save(any(VerseRelation.class)))
                .thenReturn(savedRelation);

        VerseRelation result =
                service.execute(command);

        assertNotNull(result.id());

        assertEquals(
                command.source(),
                result.source()
        );

        assertEquals(
                command.target(),
                result.target()
        );

        assertEquals(
                command.type(),
                result.type()
        );

        ArgumentCaptor<VerseRelation> captor =
                ArgumentCaptor.forClass(VerseRelation.class);

        verify(repository).save(captor.capture());

        VerseRelation captured =
                captor.getValue();

        assertNotNull(captured.id());

        assertEquals(
                command.source(),
                captured.source()
        );

        assertEquals(
                command.target(),
                captured.target()
        );

        assertEquals(
                command.type(),
                captured.type()
        );
    }
}