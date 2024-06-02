package com.dyonne.literalura.literAlura.main;

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
    }
}
