package com.example.libraryui;

import com.example.libraryui.model.*;
import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.sql.SQLException;

public class Controller {

    @FXML
    private TableView studentTable;
    @FXML
    private TableView booksTable;

    @FXML
    private TableView fineTable;

    @FXML
    private TextField book_id;
    @FXML
    private TextField return_book_id;
    @FXML
    private TextField name;
    @FXML
    private TextField category;
    @FXML
    private TextField author;
    @FXML
    private TextField edition;
    @FXML
    private TextField student_ID;
    @FXML
    private TextField return_student_ID;
    @FXML
    private TextField student_name;
    @FXML
    private TextField stream;
    @FXML
    private TextField student_id;
    @FXML
    private TextField Student_Id;
    @FXML
    private TextField Student_Name;
    @FXML
    private TextField Stream;
    @FXML
    private TextField Book_Name;
    @FXML
    private TextField Date_of_issue;
    @FXML
    private TextField return_date;




    @FXML
    private ProgressBar progressBar;


    public void listStudents() {
        Task<ObservableList<Student>> task = new GetAllStudents();
        studentTable.itemsProperty().bind(task.valueProperty());
//        progressBar.progressProperty().bind(task.progressProperty());
//        progressBar.setVisible(true);
//
//        task.setOnSucceeded(e -> progressBar.setVisible(false));
//        task.setOnFailed(e -> progressBar.setVisible(false));


        new Thread(task).start();
    }

    public void listBooks(){
        Task<ObservableList<Book>> task = new GetAllBooks();
        booksTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }


    public void listIssueBooks() {
        final Student student = (Student) studentTable.getSelectionModel().getSelectedItem();
        if(student == null){
            System.out.println("No student is selected");
            return;
        }
        Task<ObservableList<Issue_Book>> task = new Task<ObservableList<Issue_Book>>() {
            @Override
            protected ObservableList<Issue_Book> call() throws Exception {
                return FXCollections.observableArrayList(Datasource.getInstance().query_issue_book(student.getStudent_Id(),student.getStream()));
            }
        };
        booksTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    public void listFine(){
        final Student student = (Student) studentTable.getSelectionModel().getSelectedItem();
        if(student == null){
            System.out.println("No student is selected");
            return;
        }
        Task<ObservableList<Return_Book>> task = new Task<ObservableList<Return_Book>>() {
            @Override
            protected ObservableList<Return_Book> call() throws Exception {
                return FXCollections.observableArrayList(Datasource.getInstance().calculate_fine(student.getStudent_Name(),student.getStream(),student.getStudent_Id()));
            }
        };
        fineTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }

    public void addBook(ActionEvent event) throws SQLException {
        String Name = name.getText();
        String Category = category.getText();
        String Author = author.getText();
        String Edition = edition.getText();

        if(Name.isEmpty() || Category.isEmpty() || Author.isEmpty() || Edition.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the fields");
            alert.showAndWait();
            return;
        }


        Datasource.getInstance().insertBook(Name,Category,Author,Integer.parseInt(Edition));

        if(true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data Entered Successfully");
            alert.showAndWait();
            return;
        }

    }

    public void issuetheBook(ActionEvent event) throws SQLException {
        String Book_Id = book_id.getText();
        String Student_Id = student_ID.getText();

        if(Book_Id.isEmpty() || Student_Id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the fields");
            alert.showAndWait();
            return;
        }
        Datasource.getInstance().issuethebook(Integer.parseInt(Book_Id),Student_Id);
        Datasource.getInstance().updatestatus("Issued", Integer.parseInt(Book_Id));

        if(true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data Entered Successfully");
            alert.showAndWait();
            return;
        }
    }



    public void returntheBook(ActionEvent event) throws SQLException {
        String Book_Id = return_book_id.getText();
        String Student_Id = return_student_ID.getText();

        if(Book_Id.isEmpty() || Student_Id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the fields");
            alert.showAndWait();
            return;
        }
        Datasource.getInstance().returnthebook(Integer.parseInt(Book_Id),Student_Id);
        Datasource.getInstance().updatestatus("Available", Integer.parseInt(Book_Id));

        if(true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data Entered Successfully");
            alert.showAndWait();
            return;
        }
    }





    public void addStudent(ActionEvent event) throws SQLException {
        String Student_Name = student_name.getText();
        String Stream = stream.getText();
        String Student_Id = student_id.getText();


        if(Student_Name.isEmpty() || Stream.isEmpty() || Student_Id.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the fields");
            alert.showAndWait();
            return;
        }


        Datasource.getInstance().insertStudent(Student_Name,Stream,Integer.parseInt(Student_Id));

        if(true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data Entered Successfully");
            alert.showAndWait();
            return;
        }

    }

    public void addIssueBook(ActionEvent event) throws SQLException {
        String Student_id = Student_Id.getText();
        String Student_name = Student_Name.getText();
        String Stream_ib = Stream.getText();
        String Book_name = Book_Name.getText();
        String Date_of_Issue = Date_of_issue.getText();
        String Return = return_date.getText();


        if(Student_name.isEmpty() || Stream_ib.isEmpty() || Student_id.isEmpty() || Book_name.isEmpty() || Date_of_Issue.isEmpty() || Return.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter all the fields");
            alert.showAndWait();
            return;
        }


        Datasource.getInstance().insert_issue_book(Integer.parseInt(Student_id),Student_name,Stream_ib,Book_name,Date_of_Issue,Return);

        if(true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Data Entered Successfully");
            alert.showAndWait();
            return;
        }

    }

    class GetAllStudents extends Task {
        @Override
        public ObservableList<Student> call() {
            return FXCollections.observableArrayList
                    (Datasource.getInstance().queryListStudents(Datasource.INDEX_STUDENT_STREAM));
        }
    }

    class GetAllBooks extends Task{
        @Override
        public ObservableList<Book> call(){
            return FXCollections.observableArrayList(Datasource.getInstance().queryListBooks(Datasource.INDEX_BOOK_NAME));
        }
    }



}






