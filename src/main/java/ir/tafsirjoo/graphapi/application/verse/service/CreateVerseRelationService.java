package ir.tafsirjoo.graphapi.application.verse.service;

import ir.tafsirjoo.graphapi.application.verse.dto.CreateVerseRelationCommand;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;
import ir.tafsirjoo.graphapi.domain.verse.repository.VerseRelationRepository;

public class CreateVerseRelationService {

    private final VerseRelationRepository repository;

    public CreateVerseRelationService(
            VerseRelationRepository repository
    ) {
        this.repository = repository;
    }

    public VerseRelation execute(
            CreateVerseRelationCommand command
    ) {

        VerseRelation relation = new VerseRelation(
                command.source(),
                command.target(),
                command.type()
        );

        return repository.save(relation);
    }
}