package ir.tafsirjoo.graphapi.application.verse.service;

import ir.tafsirjoo.graphapi.application.verse.dto.CreateVerseRelationCommand;
import ir.tafsirjoo.graphapi.domain.verse.model.RelationType;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseReference;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;
import ir.tafsirjoo.graphapi.domain.verse.repository.VerseRelationRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
                new VerseRelation(
                        command.source(),
                        command.target(),
                        command.type()
                );

        when(repository.save(any(VerseRelation.class)))
                .thenReturn(savedRelation);

        VerseRelation result =
                service.execute(command);

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

        verify(repository).save(any(VerseRelation.class));
    }
}