package ir.tafsirjoo.graphapi.presentation.verse;

import ir.tafsirjoo.graphapi.application.verse.dto.CreateVerseRelationCommand;
import ir.tafsirjoo.graphapi.application.verse.service.CreateVerseRelationService;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseRelation;
import ir.tafsirjoo.graphapi.domain.verse.model.VerseReference;
import ir.tafsirjoo.graphapi.presentation.verse.dto.CreateVerseRelationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/verse-relations")
public class VerseRelationController {

    private final CreateVerseRelationService service;

    public VerseRelationController(
            CreateVerseRelationService service
    ) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(
            @Valid @RequestBody CreateVerseRelationRequest request
    ) {

        CreateVerseRelationCommand command =
                new CreateVerseRelationCommand(
                        new VerseReference(
                                request.source().surah(),
                                request.source().verse()
                        ),
                        new VerseReference(
                                request.target().surah(),
                                request.target().verse()
                        ),
                        request.type()
                );

        service.execute(command);
    }
}