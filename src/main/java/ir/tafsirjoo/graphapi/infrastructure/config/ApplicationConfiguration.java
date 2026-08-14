package ir.tafsirjoo.graphapi.infrastructure.config;

import ir.tafsirjoo.graphapi.application.verse.service.CreateVerseRelationService;
import ir.tafsirjoo.graphapi.domain.verse.repository.VerseRelationRepository;
import ir.tafsirjoo.graphapi.infrastructure.neo4j.repository.Neo4jVerseRelationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.Neo4jClient;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public VerseRelationRepository verseRelationRepository(
            Neo4jClient neo4jClient
    ) {
        return new Neo4jVerseRelationRepository(neo4jClient);
    }

    @Bean
    public CreateVerseRelationService createVerseRelationService(
            VerseRelationRepository repository
    ) {
        return new CreateVerseRelationService(repository);
    }
}