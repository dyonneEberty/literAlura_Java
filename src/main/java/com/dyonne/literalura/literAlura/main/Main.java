package com.dyonne.literalura.literAlura.main;

import com.dyonne.literalura.literAlura.model.*;
import com.dyonne.literalura.literAlura.service.BookService;
import com.dyonne.literalura.literAlura.service.ConvertData;
import com.dyonne.literalura.literAlura.service.HttpService;

import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private HttpService getDataApi = new HttpService();
    private ConvertData converter = new ConvertData();
    private BookService bookService;

    public Main(BookService bookService) {
        this.bookService = bookService;
    }

    public void getMenu() {
        String menu = """
                ########## Choose a number to search: #############
                1 - Add a book to the library
                2 - Show list of books registered
                3 - Show list of authors registered
                4 - Show list of living authors in the respective year
                5 - Show list of books in a given language
                
                0 - Exit
                ######################################################
                """;

        int option = -1;

        while (option != 0) {
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    getBook();
                    break;
                case 2:
                    getAllBooks();
                    break;
                case 3:
                    getAllAuthors();
                case 4:
                    getAuthorsAliveIn();
                    break;
                case 5:
                    getBooksByLanguage();
                case 0:
                    System.out.println("Finishing the search...");
           }
        }
    }

    private BookData getBookData() {
        String urlStart = "https://gutendex.com//books?search=";
        System.out.println("Enter the name of the book to search: ");
        String bookTitle = scanner.nextLine();

        var bookJson = getDataApi.getApi(urlStart + bookTitle.toLowerCase().replace(" ", "%20"));
        ResultsData resultsData = converter.getData(bookJson, ResultsData.class);
        BookData bookData = resultsData.results().get(0);

        return bookData;
    }

    private void getBook() {
        BookData bookData = getBookData();
        Book book = new Book(bookData);


        // getting the first element in the array inside bookData and putting him into the Author class
        var firstAuthor = bookData.authors().get(0);
        AuthorData authorData = new AuthorData(firstAuthor.name(), firstAuthor.birth_year(), firstAuthor.death_year());
        Author author = new Author(authorData);

        book.setAuthor(author);
        bookService.saveBook(book);
        System.out.println(book);
    }

    private void getAllBooks() {
        var books = bookService.getAllBooks();
        if (!books.isEmpty()) {
            books.forEach(System.out::println);
        } else {
            System.out.println("There are currently no books registered, select option 1 to register a book!");
        }
    }

    private void  getAllAuthors() {
        var authors = bookService.getAllAuthors();
        if (!authors.isEmpty()) {
            authors.forEach(System.out::println);
        } else {
            System.out.println("There are currently no authors registered, select option 1 to register a book to get the author!");
        }
    }

    private void getAuthorsAliveIn() {
        System.out.println("Insert the year you want to search: ");
        String year = scanner.nextLine();

        var authorAliveIn = bookService.getAuthorsAliveIn(year);
        if (!authorAliveIn.isEmpty()) {
            authorAliveIn.forEach(System.out::println);
        } else {
            System.out.println("No registered author was alive this year!");
        }
    }

    private void getBooksByLanguage() {
        var booksByLanguage = bookService.getBookByLanguage();
        booksByLanguage.forEach(System.out::println);
    }
}
