package ir.tafsirjoo.graphapi.infrastructure.neo4j.node;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Verse")
public class VerseNode {

    @Id
    private String id;

    private int surah;

    private int number;

    public VerseNode() {
    }

    public VerseNode(
            String id,
            int surah,
            int number
    ) {
        this.id = id;
        this.surah = surah;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public int getSurah() {
        return surah;
    }

    public int getNumber() {
        return number;
    }
}