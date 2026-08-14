package ir.tafsirjoo.graphapi.domain.verse.model;
import java.util.Objects;
import java.util.UUID;

public class VerseRelation {

    private final UUID id;

    private final VerseReference source;

    private final VerseReference target;

    private final RelationType type;

    public VerseRelation(
            UUID id,
            VerseReference source,
            VerseReference target,
            RelationType type
    ) {
        this.id = Objects.requireNonNull(id);
        this.source = Objects.requireNonNull(source);
        this.target = Objects.requireNonNull(target);
        this.type = Objects.requireNonNull(type);


        if (source.equals(target)) {
            throw new IllegalArgumentException(
                    "Source and target verses cannot be the same"
            );
        }
    }

    public static VerseRelation create(
            VerseReference source,
            VerseReference target,
            RelationType type
    ) {
        return new VerseRelation(
                UUID.randomUUID(),
                source,
                target,
                type
        );
    }

    public static VerseRelation restore(
            UUID id,
            VerseReference source,
            VerseReference target,
            RelationType type
    ) {
        return new VerseRelation(
                id,
                source,
                target,
                type
        );
    }

    public UUID id() {
        return id;
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