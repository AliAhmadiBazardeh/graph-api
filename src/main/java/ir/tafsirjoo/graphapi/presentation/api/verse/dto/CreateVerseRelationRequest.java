package ir.tafsirjoo.graphapi.presentation.verse.dto;

import ir.tafsirjoo.graphapi.domain.verse.model.RelationType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateVerseRelationRequest(

        @NotNull
        @Valid
        VerseRequest source,

        @NotNull
        @Valid
        VerseRequest target,

        @NotNull
        RelationType type
) {

    public record VerseRequest(

            @NotNull
            Integer surah,

            @NotNull
            Integer verse
    ) {
    }
}