package ir.tafsirjoo.graphapi.presentation.api.verse.dto;

import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;

import java.util.UUID;

public record CreateVerseRelationResponse(
        UUID id,
        String source,
        String target,
        String type
) {

    public static CreateVerseRelationResponse from(
            VerseRelation relation
    ) {
        return new CreateVerseRelationResponse(
                relation.id(),
                relation.source().toString(),
                relation.target().toString(),
                relation.type().name()
        );
    }
}