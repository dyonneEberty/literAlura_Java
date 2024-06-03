package com.dyonne.literalura.literAlura.service;

import com.dyonne.literalura.literAlura.model.Author;
import com.dyonne.literalura.literAlura.model.Book;
import com.dyonne.literalura.literAlura.respository.AuthorRepository;
import com.dyonne.literalura.literAlura.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public void saveBook(Book book) {

        Book bookAlreadySaved = bookRepository.getByTitle(book.getTitle());

        if (bookAlreadySaved == null) {

            Author author = book.getAuthor();
            Author authorAlreadySaved = authorRepository.findByNameContainingIgnoreCase(author.getName());

            if (authorAlreadySaved != null) {
                book.setAuthor(authorAlreadySaved);
                authorAlreadySaved.setBooks(book);
            } else {
                Author savedAuthor = authorRepository.save(author);
                book.setAuthor(savedAuthor);
                savedAuthor.setBooks(book);
            }

            bookRepository.save(book);
            System.out.println("Book added successfully!");
        } else {
            System.out.println("This book has already been entered");
        }
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsAliveIn(String year) {
        return authorRepository.authorsAliveIn(year);
    }

    public List<Book> getBookByLanguage() {

        Scanner scanner = new Scanner(System.in);
        List<String> languages = bookRepository.languages();

        System.out.println("\nLanguages available: {");

        if (languages.size() == 1) {
            languages.forEach(System.out::println);
        } else {
            languages.forEach(l -> System.out.println(l + "- "));
        }

        System.out.println("} ");

        System.out.println("\nChoose your language to search the books by: ");
        String language = scanner.nextLine();

        if (!language.contains(language)) {
            System.out.println("There is no record of books in this language");
        }
        return bookRepository.booksByLanguage(language);
    }
}
