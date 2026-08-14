package ir.tafsirjoo.graphapi.domain.verse.model;

public record VerseReference(
        int surah,
        int verse
) {

    public VerseReference {
        if (surah < 1 || surah > 114) {
            throw new IllegalArgumentException("Surah must be between 1 and 114");
        }

        if (verse < 1) {
            throw new IllegalArgumentException("Verse must be greater than 0");
        }
    }

    @Override
    public String toString() {
        return surah + ":" + verse;
    }
}