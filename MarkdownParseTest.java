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

    public void autoTestMarkdownParse(String[] results, String file) throws IOException{
        ArrayList<String> links = new ArrayList<String>();
        for(String link : results){
            links.add(link);
        }
        String issue = Files.readString(Path.of(file));
        assertEquals(MarkdownParse.getLinks(issue),links);
    }

    @Test
    public void testSecondaryBug() throws IOException{
        String[] links = {"www.weirdP().com"};
        autoTestMarkdownParse(links, "edge-case.md");
    }

    @Test
    public void testEdge_Case2() throws IOException{
        String[] links = {"google.com"};
        autoTestMarkdownParse(links, "edge_case2.md");
    }
}