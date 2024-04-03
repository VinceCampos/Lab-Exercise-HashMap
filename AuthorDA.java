import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class AuthorDA {
    private HashMap<String, Author> authorMap;
    
    public HashMap<String, Author> getAuthorMap(){
        return authorMap;
    }

    public AuthorDA() {
        authorMap = new HashMap<>();
        
        try (Scanner scanner = new Scanner(new FileReader("Author.csv"))){
        
            while (scanner.hasNextLine()) {
                String[] authorSplit = scanner.nextLine().split(",");
                Author author = new Author();
                author.setName(authorSplit[0].trim());
                author.setBio(authorSplit[1].trim());
                authorMap.put(author.getName(), author);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
