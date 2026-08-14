package ir.tafsirjoo.graphapi.domain.verse.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VerseRelationTest {

    @Test
    void should_reject_relation_between_same_verse() {

        VerseReference verse =
                new VerseReference(2, 255);

        assertThrows(
                IllegalArgumentException.class,
                () -> new VerseRelation(
                        verse,
                        verse,
                        RelationType.THEMATIC
                )
        );
    }
}