package com.dyonne.literalura.literAlura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authorName;
    private String language;
    private Integer download_count;

    @ManyToOne
    private Author author;


    public Book() {}
    public Book(BookData bookData) {
        this.title = bookData.title();
        this.authorName = bookData.authors().get(0).name();
        this.language = String.join("," , bookData.languages());
        this.download_count = bookData.download_count();
    }
}
