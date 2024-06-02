package com.dyonne.literalura.literAlura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private Integer birth_year;
    private Integer death_year;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author() {}
    public Author(AuthorData authorData) {
        String[] author = authorData.name().split(",");
        this.name = author[1] + " " + author[0];
        this.birth_year = authorData.birth_year();
        this.death_year = authorData.death_year();
    }

    public String getName() {
        return name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }
}
