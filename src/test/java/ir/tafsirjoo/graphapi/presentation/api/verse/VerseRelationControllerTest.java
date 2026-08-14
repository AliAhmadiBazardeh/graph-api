package ir.tafsirjoo.graphapi.presentation.api.verse;

import ir.tafsirjoo.graphapi.application.verse.service.CreateVerseRelationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VerseRelationController.class)
class VerseRelationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CreateVerseRelationService service;

    @Test
    void should_create_verse_relation() throws Exception {

        mockMvc.perform(
                post("/api/v1/verse-relations")
                        .contentType("application/json")
                        .content("""
                                {
                                  "source": {
                                    "surah": 2,
                                    "verse": 255
                                  },
                                  "target": {
                                    "surah": 2,
                                    "verse": 256
                                  },
                                  "type": "THEMATIC"
                                }
                                """)
        ).andExpect(status().isCreated());
    }
}