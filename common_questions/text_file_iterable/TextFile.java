import java.util.*;
import java.io.*;

public class TextFile implements Iterable<String> {
    BufferedReader br;
    String line = null;
    public TextFile(String fileName) {
        // please implement this
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /** Begin reading the file, line by line. The returned Iterator.next() will return a line. */
    @Override
    public Iterator<String> iterator() {
        // please implement this
        return new Iterator<String> () {
            public boolean hasNext() {
                if (line == null) {
                    try {
                        line = br.readLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return line != null;
            }
            public String next() {
                if (line == null) throw new RuntimeException();
                String result = new String(line);
                line = null;
                return result;
            }
            public void remove() {
                if (hasNext()) next();
            }
        };
    }
    public static void main(String[] args) {
        TextFile f = new TextFile("./TextFile.java");
        for (String s : f) {
            System.out.println(s);
        }
        // alternatively 
        // Iterator<String> it = f.iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }
    }
}