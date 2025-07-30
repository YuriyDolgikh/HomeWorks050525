package workInClasses.lessonPro13.repository;

import workInClasses.lessonPro13.entity.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    List<Author> authors = new ArrayList<>();

    public void addAuthor(Author author){
        authors.add(author);
    }

    public List<Author> getAuthors(){
        return authors;
    }

    public Author getAuthorById(int id){
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author getAuthorByName(String name){
        for (Author author : authors) {
            if (author.getAuthorName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }
}
