package com.example.libraryui.model;

public class Book {

    private int Book_ID;
    private String Name;
    private String Category;
    private String Author;
    private int Edition;
    private String Status;

    public int getBook_ID(){
        return Book_ID;
    }

    public void setBook_ID(int bookId){Book_ID = bookId;}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getEdition() {
        return Edition;
    }

    public void setEdition(int edition) {
        Edition = edition;
    }

    public String getStatus(){return Status;}
    public void setStatus(String status){Status = status;}
}
