package com.example.libraryui.model;

public class Issue_Book {
    private int Book_ID;
    private int Student_Id;
    private String Student_Name;
    private String Stream;
    private String Book_Name;
    private String Date_of_Issue;
    private String Return;


    public int getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(int book_ID) {
        Book_ID = book_ID;
    }

    public int getStudent_Id() {
        return Student_Id;
    }

    public void setStudent_Id(int student_Id) {
        Student_Id = student_Id;
    }

    public String getStudent_Name() {
        return Student_Name;
    }

    public void setStudent_Name(String student_Name) {
        Student_Name = student_Name;
    }

    public String getStream() {
        return Stream;
    }

    public void setStream(String stream) {
        Stream = stream;
    }

    public String getBook_Name() {
        return Book_Name;
    }

    public void setBook_Name(String book_Name) {
        Book_Name = book_Name;
    }

    public String getDate_of_Issue() {
        return Date_of_Issue;
    }

    public void setDate_of_Issue(String date_of_Issue) {
        Date_of_Issue = date_of_Issue;
    }

    public String getReturn() {
        return Return;
    }

    public void setReturn(String aReturn) {
        Return = aReturn;
    }
}
