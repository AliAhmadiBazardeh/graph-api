package ir.tafsirjoo.graphapi.domain.verse.model;

import java.util.Objects;

public class VerseRelation {

    private final VerseReference source;

    private final VerseReference target;

    private final RelationType type;

    public VerseRelation(
            VerseReference source,
            VerseReference target,
            RelationType type
    ) {
        this.source = Objects.requireNonNull(source);
        this.target = Objects.requireNonNull(target);
        this.type = Objects.requireNonNull(type);
    }

    public VerseReference source() {
        return source;
    }

    public VerseReference target() {
        return target;
    }

    public RelationType type() {
        return type;
    }
}