package ir.tafsirjoo.graphapi.application.verse.dto;

import ir.tafsirjoo.graphapi.domain.verse.model.RelationType;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseReference;

public record CreateVerseRelationCommand(
        VerseReference source,
        VerseReference target,
        RelationType type
) {
}