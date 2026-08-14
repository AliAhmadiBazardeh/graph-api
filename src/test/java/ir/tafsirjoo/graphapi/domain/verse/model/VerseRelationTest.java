package ir.tafsirjoo.graphapi.domain.verse.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VerseRelationTest {

    @Test
    void should_reject_relation_between_same_verse() {

        VerseReference verse =
                new VerseReference(2, 255);

        assertThrows(
                IllegalArgumentException.class,
                () -> VerseRelation.create(
                        verse,
                        verse,
                        RelationType.THEMATIC
                )
        );
    }

    @Test
    void should_generate_id_when_relation_is_created() {

        VerseRelation relation =
                VerseRelation.create(
                        new VerseReference(2, 255),
                        new VerseReference(2, 256),
                        RelationType.THEMATIC
                );

        assertNotNull(relation.id());
    }
}