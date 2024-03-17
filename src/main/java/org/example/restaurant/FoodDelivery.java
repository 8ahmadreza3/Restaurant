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

    public void menuRestaurant(){

        Button[] buttons = new Button[5];
        Image[] images = new Image[5];

        for(int i=0 ; i<5 ; i++){
            images[i] = new Image("file:D:/Code/Java/Photo/"+(i+1)+".jpg");
        }

        for (int i=0 ; i<5  ; i++){
            buttons[i] = new Button();
            buttons[i].setGraphic(new ImageView(images[i]));
            buttons[i].setPrefSize(125 , 125);
        }

        Label[] names = new Label[5];
        Label[] info = new Label[5];
        Label[] rates = new Label[5];
        Rectangle[] rec = new Rectangle[5];

        for (int i=0 , b=15 ; i<5 ; i++ , b+=165){

            names[i] = new Label(res[i].getName());
            info[i] = new Label("Address : ......\nNumber : ......");
            rates[i] = new Label(res[i].getRate()+"*/5.0*");

            rec[i] = new Rectangle(160 , 290 ,Color.WHITESMOKE);
            rec[i].setArcHeight(30);
            rec[i].setArcWidth(30);
            rec[i].setTranslateX(b-10);
            rec[i].setTranslateY(290);


            names[i].setTranslateX(b+10);
            info[i].setTranslateX(b+20);
            rates[i].setTranslateX(b+50);

            names[i].setTranslateY(450);
            info[i].setTranslateY(490);
            rates[i].setTranslateY(550);

            names[i].setFont(Font.font("Tahoma" , FontPosture.ITALIC , 25));
            info[i].setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD , 12 ));
            rates[i].setFont(Font.font("Tah" , FontPosture.REGULAR , 15));

            if(res[i].getRate()>=4) {
                rates[i].setTextFill(Color.GREEN);
            }
            else if (res[i].getRate()>=3) {
                rates[i].setTextFill(Color.YELLOW);
            }
            else if (res[i].getRate()>=2) {
                rates[i].setTextFill(Color.RED);
            }
            else {
                rates[i].setTextFill(Color.GRAY);
            }

            buttons[i].setTranslateY(300);
            buttons[i].setTranslateX(b);

            int finalI = i;
            buttons[i].setOnAction(e -> {
                menuFoods(finalI);
            });

        }

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginForm();
            }
        });
        exitButton.setTranslateX(950);
        exitButton.setTranslateY(550);

        ImageView im = new ImageView(new Image("file:D:/Code/Java/Photo/7.png"));
        im.setFitHeight(169);
        im.setFitWidth(169);
        im.setTranslateX(831);
        im.setTranslateY(0);

        ImageView iv = new ImageView(new Image("file:D:/Code/Java/Photo/6.png"));
        iv.setFitHeight(270);
        iv.setFitWidth(820);
        iv.setTranslateX(5);
        iv.setTranslateY(15);

        Label us = new Label( a.getUserName()+ " ,\nwelcome to our\nfood ordering \nplatform :)");
        us.setTranslateX(840);
        us.setTranslateY(200);
        us.setFont(Font.font("Tahoma" , FontWeight.EXTRA_BOLD , 15));

        Line l = new Line(830 , 0 , 830 ,600);

        Button cart = new Button("Cart");
        cart.setTranslateY(550);
        cart.setTranslateX(840);
        cart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cartOrder();
            }
        });