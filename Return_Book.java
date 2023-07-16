package com.example.libraryui.model;

public class Return_Book {
    private int Student_Id;
    private String Student_Name;
    private String Stream;
    private String Book_Name;
    private int Days_Elapsed;
    private int Fine;

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

    public int getDays_Elapsed() {
        return Days_Elapsed;
    }

    public void setDays_Elapsed(int days_Elapsed) {
        Days_Elapsed = days_Elapsed;
    }

    public int getFine() {
        return Fine;
    }

    public void setFine(int fine) {
        Fine = fine;
    }
}
