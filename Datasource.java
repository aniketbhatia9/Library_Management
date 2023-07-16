package com.example.libraryui.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {

    public static final String DB_NAME = "Library.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\anike\\OneDrive\\Documents\\Java_Project\\" + DB_NAME;
    public static final String TABLE_BOOK = "Book";
    public static final String COLUMN_BOOK_ID = "Book_ID";
    public static final String COLUMN_BOOK_NAME = "Name";
    public static final String COLUMN_BOOK_CATEGORY = "Category";
    public static final String COLUMN_BOOK_AUTHOR = "Author";
    public static final String COLUMN_BOOK_EDITION = "Edition";
    public static final String COLUMN_BOOK_STATUS = "Status";
    public static final int INDEX_BOOK_ID = 1;
    public static final int INDEX_BOOK_NAME = 2;
    public static final int INDEX_BOOK_CATEGORY = 3;
    public static final int INDEX_BOOK_AUTHOR = 4;
    public static final int INDEX_BOOK_EDITION = 5;
    public static final int INDEX_BOOK_STATUS = 6;
    public static final String TABLE_ISSUE_BOOK = "Issue_Book";
    public static final String COLUMN_IB_BOOK_ID = "Book_Id";
    public static final String COLUMN_IB_STUDENT_ID = "Student_Id";
    public static final String COLUMN_IB_STUDENT_NAME = "Student_Name";
    public static final String COLUMN_IB_STREAM = "Stream";
    public static final String COLUMN_IB_BOOK = "Book_Name";
    public static final String COLUMN_IB_DATE = "Date_of_Issue";
    public static final String COLUMN_IB_RETURN = "Return";
    public static final int INDEX_IB_BOOK_ID = 1;
    public static final int INDEX_IB_STUDENT_ID = 2;
    public static final int INDEX_IB_STUDENT_NAME = 3;
    public static final int INDEX_IB_STREAM = 4;
    public static final int INDEX_IB_BOOK = 5;
    public static final int INDEX_IB_DATE = 6;
    public static final int INDEX_IB_RETURN = 7;
    public static final String TABLE_RETURN_BOOK = "Return_Book";
    public static final String COLUMN_RB_STUDENT_ID = "Student_Id";
    public static final String COLUMN_RB_STUDENT_NAME = "Student_Name";
    public static final String COLUMN_RB_STREAM = "Stream";
    public static final String COLUMN_RB_BOOK = "Book_Name";
    public static final String COLUMN_RB_DAYS_ELAPSED = "Days_Elapsed";
    public static final String COLUMN_RB_FINE = "Fine";
    public static final int INDEX_RB_STUDENT_ID = 1;
    public static final int INDEX_RB_STUDENT_NAME = 2;
    public static final int INDEX_RB_STREAM = 3;
    public static final int INDEX_RB_BOOK_NAME = 4;
    public static final int INDEX_RB_DAYS_ELAPSED = 5;
    public static final int INDEX_RB_FINE = 6;
    public static final String TABLE_STUDENT = "Student";
    public static final String COLUMN_STUDENT_NAME = "Student_Name";
    public static final String COLUMN_STUDENT_STREAM = "Stream";
    public static final String COLUMN_STUDENT_ID = "Student_Id";
    public static final int INDEX_STUDENT_NAME = 1;
    public static final int INDEX_STUDENT_STREAM = 2;
    public static final int INDEX_STUDENT_ID = 3;
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_BOOK = "SELECT " + COLUMN_BOOK_NAME + ", " + COLUMN_BOOK_AUTHOR + ", " + COLUMN_BOOK_CATEGORY + ", " +  COLUMN_BOOK_EDITION +  " FROM " + TABLE_BOOK + " WHERE " +
            COLUMN_BOOK_CATEGORY +  " =  ?";

    public static final String QUERY_STUDENT = "SELECT " + COLUMN_STUDENT_NAME + ", " + COLUMN_STUDENT_STREAM + ", " +
            COLUMN_STUDENT_ID + " FROM " + TABLE_STUDENT + " WHERE " + COLUMN_STUDENT_STREAM + " = ?";


//    public static final String QUERY_ISSUE_BOOK = "SELECT " + COLUMN_IB_STUDENT_ID + ", " + COLUMN_IB_STUDENT_NAME + ", " + COLUMN_IB_STREAM + ", " +
//            COLUMN_IB_BOOK + ", " + COLUMN_IB_DATE + ", " + COLUMN_IB_RETURN + " FROM " + TABLE_ISSUE_BOOK +
//            " WHERE " + COLUMN_IB_STUDENT_ID + " = ?" +  " AND " + COLUMN_IB_STREAM + " = ?";

    public static final String QUERY_ISSUE_BOOK = "SELECT "  + COLUMN_IB_STUDENT_NAME + ", " + COLUMN_IB_STREAM + ", " +
            COLUMN_IB_STUDENT_ID + ", " + COLUMN_IB_BOOK + ", " + COLUMN_IB_DATE + ", " + COLUMN_IB_RETURN +   " FROM " + TABLE_ISSUE_BOOK + " WHERE " + COLUMN_IB_STUDENT_ID + " = ?" +  " AND " + COLUMN_IB_STREAM + " = ?";

    public static final String QUERY_RETURN_BOOK = "SELECT " + COLUMN_RB_STUDENT_ID + ", " + COLUMN_RB_STUDENT_NAME + ", " + COLUMN_RB_STREAM + ", " +
            COLUMN_RB_BOOK + ", " + COLUMN_RB_DAYS_ELAPSED + ", " + COLUMN_RB_FINE + " FROM " + TABLE_RETURN_BOOK + " WHERE " +
            COLUMN_RB_STUDENT_ID + " = ?" + " AND " + COLUMN_RB_STREAM + " = ?" + " AND " + COLUMN_RB_BOOK + " = ?";

    public static final String INSERT_STUDENT = "INSERT INTO " + TABLE_STUDENT + '(' + COLUMN_STUDENT_NAME + ", " + COLUMN_STUDENT_STREAM + ", " + COLUMN_STUDENT_ID + ") VALUES(?, ?, ?)";
    public static final String INSERT_BOOK = "INSERT INTO " + TABLE_BOOK + '(' + COLUMN_BOOK_NAME + ", " + COLUMN_BOOK_CATEGORY + ", " + COLUMN_BOOK_AUTHOR + ", " + COLUMN_BOOK_EDITION +  ") VALUES(?, ?, ?, ?)";

    public static final String INSERT_ISSUE_BOOK = "INSERT INTO " + TABLE_ISSUE_BOOK + '(' + COLUMN_IB_STUDENT_ID + ", " + COLUMN_IB_STUDENT_NAME
            + ", " + COLUMN_IB_STREAM + ", " + COLUMN_IB_BOOK + ", " + COLUMN_IB_DATE + ", " + COLUMN_IB_RETURN + ") VALUES(?, ?, ?, ?, ?, ?)";

    public static final String CALCULATE_FINE = "SELECT " + COLUMN_RB_FINE + " FROM " + TABLE_RETURN_BOOK + " WHERE " + COLUMN_RB_STUDENT_NAME + " = ?" + " AND " + COLUMN_RB_STREAM + " = ?" + " AND " + COLUMN_RB_STUDENT_ID  + " = ?";

    public static final String ISSUE_THE_BOOK = "INSERT INTO " + TABLE_ISSUE_BOOK + '(' + COLUMN_BOOK_ID + ", " + COLUMN_IB_STUDENT_ID +  ')' + " SELECT " + COLUMN_BOOK_ID +
            ", " + COLUMN_IB_STUDENT_ID + " FROM " + TABLE_BOOK + " INNER JOIN " + TABLE_STUDENT + " WHERE " + COLUMN_BOOK_STATUS + " = ?"  + " AND " +
            COLUMN_BOOK_ID + " = ?" + " AND " + COLUMN_IB_STUDENT_ID + " = ?";

    public static final String UPDATE_STATUS = "UPDATE " + TABLE_BOOK + " SET " + COLUMN_BOOK_STATUS +
            " = ?" + " WHERE " + COLUMN_BOOK_ID + " = ?";

    public static final String RETURN_THE_BOOK = "DELETE FROM " + TABLE_ISSUE_BOOK + " WHERE " + COLUMN_BOOK_ID + " = ?" +  " AND " +
            COLUMN_IB_STUDENT_ID + " = ?";
    private Connection conn;

    private PreparedStatement query_book;
    private PreparedStatement query_student;
    private PreparedStatement query_issue_book;
    private PreparedStatement query_return_book;
    private PreparedStatement insert_student;
    private PreparedStatement insert_book;
    private PreparedStatement insert_issue_book;
    private PreparedStatement calculate_fine;
    private PreparedStatement issue_the_book;
    private PreparedStatement update_status;
    private PreparedStatement return_the_book;


    private static Datasource instance = new Datasource();

    private Datasource(){

    }

    public static Datasource getInstance(){
        return instance;
    }
    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            query_book = conn.prepareStatement(QUERY_BOOK);
            query_student = conn.prepareStatement(QUERY_STUDENT);
            query_issue_book = conn.prepareStatement(QUERY_ISSUE_BOOK);
            query_return_book = conn.prepareStatement(QUERY_RETURN_BOOK);
            insert_book = conn.prepareStatement(INSERT_BOOK);
            insert_student = conn.prepareStatement(INSERT_STUDENT);
            insert_issue_book = conn.prepareStatement(INSERT_ISSUE_BOOK);
            calculate_fine = conn.prepareStatement(CALCULATE_FINE);
            issue_the_book = conn.prepareStatement(ISSUE_THE_BOOK);
            update_status = conn.prepareStatement(UPDATE_STATUS);
            return_the_book = conn.prepareStatement(RETURN_THE_BOOK);
            return true;
        }catch (SQLException e){
            System.out.println("Couldn't connect to database" + e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if(query_book != null){
                query_book.close();
            }
            if(query_student != null){
                query_student.close();
            }
            if(query_issue_book != null){
                query_issue_book.close();
            }
            if(query_return_book != null){
                query_return_book.close();
            }
            if(insert_book != null){
                insert_book.close();
            }
            if(insert_student != null){
                insert_student.close();
            }
            if(insert_issue_book != null){
                insert_issue_book.close();
            }
            if(issue_the_book != null){
                issue_the_book.close();
            }
            if(update_status != null){
                update_status.close();
            }
            if(return_the_book != null){
                return_the_book.close();
            }
        }catch (SQLException e){
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }

    public List<Student> queryListStudents(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_STUDENT);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_STUDENT_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        Statement statement = null;
        ResultSet results = null;

        try {
            statement = conn.createStatement();
            results = statement.executeQuery(sb.toString());

            List<Student> students = new ArrayList<>();
            while (results.next()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted " + e.getMessage());
                }
                Student student = new Student();
                student.setStudent_Name(results.getString(INDEX_STUDENT_NAME));
                student.setStream(results.getString(INDEX_STUDENT_STREAM));
                student.setStudent_Id(results.getString(INDEX_STUDENT_ID));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resultset" + e.getMessage());
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing Statement" + e.getMessage());
            }
        }
    }


    public List<Book> queryListBooks(int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_BOOK);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_BOOK_ID);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        Statement statement = null;
        ResultSet results = null;

        try {
            statement = conn.createStatement();
            results = statement.executeQuery(sb.toString());

            List<Book> books = new ArrayList<>();
            while (results.next()) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted " + e.getMessage());
                }
                Book book = new Book();
                book.setBook_ID(results.getInt(INDEX_BOOK_ID));
                book.setName(results.getString(INDEX_BOOK_NAME));
                book.setCategory(results.getString(INDEX_BOOK_CATEGORY));
                book.setAuthor(results.getString(INDEX_BOOK_AUTHOR));
                book.setEdition(results.getInt(INDEX_BOOK_EDITION));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            System.out.println("error is here");
            System.out.println("Query failed: " + e.getMessage());
            return null;
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resultset" + e.getMessage());
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing Statement" + e.getMessage());
            }
        }
    }

    public List<Book> query_book(String category){
        try{
            query_book.setString(1,category);
            ResultSet results = query_book.executeQuery();
            List<Book> books = new ArrayList<>();
            while(results.next()){
               Book book = new Book();
               book.setName(results.getString(1));
               book.setAuthor(results.getString(2));
                book.setCategory(results.getString(3));
               book.setEdition(results.getInt(4));
               books.add(book);
            }
            return books;
        }catch (SQLException e){
            System.out.println("query failed" + e.getMessage());
            return null;
        }
    }

    public List<Student> query_student(String Stream){
        try{
            query_student.setString(1,Stream);
            ResultSet results = query_student.executeQuery();
            List<Student> students = new ArrayList<>();
            while(results.next()){
                Student student = new Student();
                student.setStudent_Name(results.getString(1));
                student.setStream(results.getString(2));
                student.setStudent_Id(results.getString(3));
                students.add(student);
            }
            return students;
        }catch (SQLException e){
            System.out.println("query failed" + e.getMessage());
            return null;
        }
    }

    public List<Issue_Book> query_issue_book(String Student_Id, String Stream){
        try{
            query_issue_book.setString(1,Student_Id);
            query_issue_book.setString(2,Stream);
            ResultSet results = query_issue_book.executeQuery();
            List<Issue_Book> issue_books = new ArrayList<>();
            while(results.next()){
                Issue_Book issueBook = new Issue_Book();
                issueBook.setStudent_Name(results.getString(1));
                issueBook.setStream(results.getString(2));
                issueBook.setStudent_Id(results.getInt(3));
                issueBook.setBook_Name(results.getString(4));
                issueBook.setDate_of_Issue(results.getString(5));
                issueBook.setReturn(results.getString(6));
                issue_books.add(issueBook);
            }
            return issue_books;
        }catch (SQLException e){
            System.out.println("query failed " + e.getMessage());
            return null;
        }
    }

    public List<Return_Book> calculate_fine(String Student_Name, String Stream, String Student_Id){
        try{
            calculate_fine.setString(1,Student_Name);
            calculate_fine.setString(2,Stream);
            calculate_fine.setString(3,Student_Id);
            ResultSet results = calculate_fine.executeQuery();
            List<Return_Book> fine = new ArrayList<>();
            while(results.next()){
                Return_Book returnBook = new Return_Book();
                returnBook.setFine((results.getInt(1)));
                fine.add(returnBook);

            }
            return fine;
        }catch (SQLException e) {
            System.out.println("query failed " + e.getMessage());
            return null;
        }
    }

  public List<Return_Book> query_return_book(int Student_id, String Stream, String Book_Name){
        try{
            query_return_book.setInt(1,Student_id);
            query_return_book.setString(2,Stream);
            query_return_book.setString(3,Book_Name);
            ResultSet results = query_return_book.executeQuery();
            List<Return_Book> returnBooks = new ArrayList<>();
            while(results.next()){
                Return_Book returnBook = new Return_Book();
                returnBook.setStudent_Id(results.getInt(1));
                returnBook.setStudent_Name(results.getString(2));
                returnBook.setStream(results.getString(3));
                returnBook.setBook_Name(results.getString(4));
                returnBook.setDays_Elapsed(results.getInt(5));
                returnBook.setFine(results.getInt(6));
                returnBooks.add(returnBook);
            }
            return returnBooks;
        }catch (SQLException e){
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
  }


    public int issuethebook(int Book_ID, String Student_Id) throws SQLException {
        issue_the_book.setString(1,"Available");
        issue_the_book.setInt(2,Book_ID);
        issue_the_book.setString(3,Student_Id);
        int affectedRows = issue_the_book.executeUpdate();

        if(affectedRows != 1){
            throw new SQLException("Couldn't issue the book");
        }
        ResultSet generatedKeys = issue_the_book.getGeneratedKeys();
        if(generatedKeys.next()){
            return generatedKeys.getInt(1);
        }else{
            throw new SQLException("Couldn't get book_id");
        }
    }

    public int updatestatus(String Status , int Book_ID) throws SQLException{
        update_status.setString(1,Status);
        update_status.setInt(2,Book_ID);
        int affectedRows = update_status.executeUpdate();
        if(affectedRows != 1){
            throw new SQLException("Book is already issued");
        }ResultSet generatedKeys = update_status.getGeneratedKeys();
        if(generatedKeys.next()){
            return generatedKeys.getInt(1);
        }else{
            throw new SQLException("Couldn't get book_id");
        }
    }

    public int returnthebook(int Book_ID, String Student_Id) throws SQLException{
        return_the_book.setInt(1,Book_ID);
        return_the_book.setString(2,Student_Id);
        int affectedRows = return_the_book.executeUpdate();
        if(affectedRows != 1){
            throw new SQLException("Book is already available");
        }ResultSet generatedKeys = update_status.getGeneratedKeys();
        if(generatedKeys.next()){
            return generatedKeys.getInt(1);
        }else{
            throw new SQLException("Couldn't get book_id");
        }
    }


  public int insertStudent(String Name, String Stream, int Id) throws SQLException {
        insert_student.setString(1,Name);
        insert_student.setString(2,Stream);
        insert_student.setInt(3,Id);
        int affectedRows = insert_student.executeUpdate();

        if(affectedRows != 1){
            throw new SQLException("Couldn't insert student");
        }
        ResultSet generatedKeys = insert_student.getGeneratedKeys();
        if(generatedKeys.next()){
            return generatedKeys.getInt(1);
        }else{
            throw new SQLException("Couldn't get name of student");
        }
  }

  public int insertBook(String Name, String Category, String Author, int Edition) throws SQLException{
        insert_book.setString(1,Name);
        insert_book.setString(2,Category);
        insert_book.setString(3,Author);
        insert_book.setInt(4,Edition);
        int affectedRows = insert_book.executeUpdate();

        if(affectedRows != 1){
            throw new SQLException("Couldn't insert book");
        }
        ResultSet generatedKeys = insert_book.getGeneratedKeys();
        if(generatedKeys.next()){
            return generatedKeys.getInt(1);
        }else{
            throw new SQLException("Couldn't get name of the Book");
        }
  }

  public int insert_issue_book(int Student_id, String Name,String Stream, String Book_Name, String Date, String Return) throws SQLException{
        insert_issue_book.setInt(1,Student_id);
        insert_issue_book.setString(2,Name);
      insert_issue_book.setString(3,Stream);
      insert_issue_book.setString(4,Book_Name);
      insert_issue_book.setString(5,Date);
      insert_issue_book.setString(6,Return);

      int affectedRows = insert_issue_book.executeUpdate();
      if(affectedRows != 1){
          throw new SQLException("Couldn't insert the data");
      }
      ResultSet generatedKeys = insert_issue_book.getGeneratedKeys();
      if(generatedKeys.next()){
          return generatedKeys.getInt(1);
      }else{
          throw new SQLException("Couldn't get the id");
      }


  }



}
