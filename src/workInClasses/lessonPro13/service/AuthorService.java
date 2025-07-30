package workInClasses.lessonPro13.service;

import workInClasses.lessonPro13.entity.Author;
import workInClasses.lessonPro13.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public boolean addAuthor(int id, String authorName, String info) {
        for (Author author : authorRepository.getAuthors()) {
            if (author.getId() == id || author.getAuthorName().equalsIgnoreCase(authorName)) {
                return false;
            }
        }
        authorRepository.addAuthor(new Author(id, authorName, info));
        return true;
    }

    public Optional<Author> getAuthorById(int id){
        Author author = authorRepository.getAuthorById(id);
        if (author == null) {
            return Optional.empty();
        }
        return Optional.of(author);
    }

    public Optional<Author> getAuthorByName(String name){
        Author author = authorRepository.getAuthorByName(name);
        if (author == null) {
            return Optional.empty();
        }
        return Optional.of(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.getAuthors();
    }
}
