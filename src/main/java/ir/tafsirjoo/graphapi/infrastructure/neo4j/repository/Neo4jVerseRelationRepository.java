package ir.tafsirjoo.graphapi.infrastructure.neo4j.repository;

import ir.tafsirjoo.graphapi.domain.verse.model.RelationType;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseReference;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;
import ir.tafsirjoo.graphapi.domain.verse.repository.VerseRelationRepository;
import org.springframework.data.neo4j.core.Neo4jClient;

import java.util.List;
import java.util.Optional;

public class Neo4jVerseRelationRepository
        implements VerseRelationRepository {

    private final Neo4jClient neo4jClient;

    public Neo4jVerseRelationRepository(Neo4jClient neo4jClient) {
        this.neo4jClient = neo4jClient;
    }

    @Override
    public VerseRelation save(VerseRelation relation) {

        String relationType = relation.type().name();

        String cypher = """
            MERGE (source:Verse {
                id: $sourceId
            })
            SET source.surah = $sourceSurah,
                source.number = $sourceNumber

            MERGE (target:Verse {
                id: $targetId
            })
            SET target.surah = $targetSurah,
                target.number = $targetNumber

            MERGE (source)-[:%s]->(target)
            """.formatted(relationType);

        neo4jClient.query(cypher)
                .bind(relation.source().toString())
                .to("sourceId")
                .bind(relation.source().surah())
                .to("sourceSurah")
                .bind(relation.source().verse())
                .to("sourceNumber")
                .bind(relation.target().toString())
                .to("targetId")
                .bind(relation.target().surah())
                .to("targetSurah")
                .bind(relation.target().verse())
                .to("targetNumber")
                .run();

        return relation;
    }

    @Override
    public Optional<VerseRelation> find(
            VerseReference source,
            VerseReference target) {
        throw new UnsupportedOperationException();
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