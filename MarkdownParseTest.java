import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void subtraction() {
        assertEquals(8, 9-1);
    }

    @Test
    public void testSecondaryBug() throws IOException{
        ArrayList<String> links = new ArrayList<String>();
        links.add("www.weirdP().com");
        String issue = Files.readString(Path.of("edge-case.md"));
        assertEquals(MarkdownParse.getLinks(issue),links);
    }
}