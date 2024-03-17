package org.example.restaurant;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FoodDelivery extends Application {

    private Stage primaryStage;
    User a = new User("AhmadReza" , "1");

    static Restaurant[] res = {new Restaurant("ShabChehre") ,new Restaurant(" DelGosha") ,
            new Restaurant("Bakhtiyary") ,new Restaurant(" AmoJoon") ,new Restaurant("    110") ,};

    static Food[] foods = {new Food(" Kebab" , 150) , new Food(" Joojeh", 125 ),
            new Food("Shishlik" , 175) , new Food("  Pitza" , 100), new Food(" Berger"
            , 75) , new Food("  Sallad" , 20) , new Food("Noshabe" , 10)};


    public static void main(String[] args) {
        for (int i=0 ; i<5 ; i++){
            int ran = (int)(Math.random()*40)+10 ;
            res[i].setRate((float) (ran/10.0));
        }
        launch(args);
    }
    public void loginForm()
    {
        primaryStage.setTitle("FoodDelivery");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text headerText = new Text("Welcome");
        headerText.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        grid.add(headerText, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);

        TextField usernameTextField = new TextField();
        grid.add(usernameTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 3);

        Text actionTarget = new Text();
        grid.add(actionTarget, 1, 4);

        loginButton.setOnAction(e -> {
            String username = usernameTextField.getText();
            String password = passwordField.getText();

            if (username.equalsIgnoreCase(a.getUserName()) && password.equals(a.getPassword())) {
                //actionTarget.setText("Welcome, " + username + "!");
                menuRestaurant();

            } else {
                actionTarget.setText("Invalid username or password.");
            }
        });

        Scene scene = new Scene(grid, 1000, 600);
        BackgroundFill backgroundFill = new BackgroundFill(Color.ORANGE, null, null);
        Background background = new Background(backgroundFill);

        grid.setBackground(background);
        primaryStage.setScene(scene);
        primaryStage.show();
    }