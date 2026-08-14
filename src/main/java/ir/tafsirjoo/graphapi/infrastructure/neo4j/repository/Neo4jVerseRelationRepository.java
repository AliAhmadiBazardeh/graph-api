package ir.tafsirjoo.graphapi.infrastructure.neo4j.repository;

import ir.tafsirjoo.graphapi.domain.verse.model.RelationType;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseReference;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;
import ir.tafsirjoo.graphapi.domain.verse.repository.VerseRelationRepository;

import java.util.List;
import java.util.Optional;

public class Neo4jVerseRelationRepository
        implements VerseRelationRepository {

    @Override
    public VerseRelation save(VerseRelation relation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<VerseRelation> find(
            VerseReference source,
            VerseReference target) {
        return Optional.empty();
    }

    @Override
    public List<VerseRelation> findOutgoing(
            VerseReference source
    ) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(
            VerseReference source,
            VerseReference target,
            RelationType type
    ) {
        throw new UnsupportedOperationException();
    }
}