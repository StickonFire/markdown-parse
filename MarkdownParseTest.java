import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

    /**
     * Tests getLinks with snippet1.md
     */
    @Test
    public void testSnippet1(){
        List<String> snippet1Results = List.of("`google.com","google.com","ucsd.edu");
        assertEquals(snippet1Results,MarkdownParse.getLinks("snippet1.md"));
    }

    /**
     * Tests getLinks with snippet2.md
     */
    @Test
    public void testSnippet2(){
        List<String> snippet2Results = List.of("a.com","a.com(())","example.com");
        assertEquals(snippet2Results,MarkdownParse.getLinks("snippet2.md"));
    }

    /**
     * Tests getLinks with snippet3.md
     */
    @Test
    public void testSnippet3(){
        List<String> snippet3Results = List.of("https://ucsd-cse15l-w22.github.io/");
        assertEquals(snippet3Results,MarkdownParse.getLinks("snippet3.md"));
    }
}