package parentesSjekker;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParentesSjekkerTest {
    private final ParentesSjekker sjekker = new ParentesSjekker();

    @Test
    public void testKorrektParenteser() {
        assertTrue(sjekker.sjekkParenteser("{[()]}"));
    }

    @Test
    public void testManglendeSluttParentes() {
        assertFalse(sjekker.sjekkParenteser("{[()}"));
    }

    @Test
    public void testManglendeStartParentes() {
        assertFalse(sjekker.sjekkParenteser("[()] }"));
    }

    @Test
    public void testFeilRekkefolge() {
        assertFalse(sjekker.sjekkParenteser("{[(])}"));
    }

    @Test
    public void testKodeSnippet() {
        String javaprogram = """
        class HelloWorld {
            public static void main(String[] args) {
                System.out.println("Hello World!");
            }
        }
        """;
        assertTrue(sjekker.sjekkParenteser(javaprogram));
    }
}
