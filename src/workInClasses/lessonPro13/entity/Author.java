package workInClasses.lessonPro13.entity;

import java.util.Objects;

public class Author {
    private int id;
    private String authorName;
    private String info;

    public Author(int id, String authorName, String info) {
        this.id = id;
        this.authorName = authorName;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;
        return id == author.id && Objects.equals(authorName, author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
