package ir.tafsirjoo.graphapi.domain.verse.repository;

import ir.tafsirjoo.graphapi.domain.verse.model.RelationType;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseReference;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;

import java.util.List;
import java.util.Optional;

public interface VerseRelationRepository {

    VerseRelation save(VerseRelation relation);

    Optional<VerseRelation> find(
            VerseReference source,
            VerseReference target
    );

    List<VerseRelation> findOutgoing(VerseReference source);

    void delete(
            VerseReference source,
            VerseReference target,
            RelationType type
    );
}