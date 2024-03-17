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

        Group group = new Group( rec );
        group.getChildren().addAll( exitButton, l , im , iv , us , cart );
        for(int i=0 ; i<5 ; i++){
            group.getChildren().addAll( buttons[i] , names[i] , info[i] , rates[i] );
        }

        Scene scene = new Scene(group, 1000, 600 , Color.ORANGERED);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void menuFoods(int x){

        Group group = new Group( );

        Button backButton = new Button("Back->");
        backButton.setTranslateY(20);
        backButton.setTranslateX(940);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuRestaurant();
            }
        });

        Rectangle[] rect = new Rectangle[4];
        ImageView[] imv = new ImageView[2];
        Button[] but = new Button[4] ;
        Label[] lab = new Label[4];

        for(int i=0 , b=565 ; i<2 ; i++ , b+=200){
            rect[i] = new Rectangle(170 , 570 , Color.ORANGERED);
            rect[i].setArcHeight(30);
            rect[i].setArcWidth(30);
            rect[i].setTranslateX(b);
            rect[i].setTranslateY(15);

            imv[i] = new ImageView(new Image("D:/Code/Java/Photo/"+(i+9)+".jpg"));
            imv[i].setFitHeight(150);
            imv[i].setFitWidth(150);
            imv[i].setTranslateX(b+10);
            imv[i].setTranslateY(30);

            but[i] = new Button("-");
            but[i+2] = new Button("+");
            but[i].setTranslateX(b+10);
            but[i].setTranslateY(200);
            but[i+2].setTranslateX(b+135);
            but[i+2].setTranslateY(200);

            lab[i] = new Label(foods[i+5].getName()+"  "+foods[i+5].getPrice()+"T");
            lab[i].setTranslateX(b+35);
            lab[i].setTranslateY(180);
            lab[i].setFont(Font.font(15));

            int finalI = i;
            but[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    foods[finalI+5].less();
                    menuFoods(x);
                }
            });

            but[i+2].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    foods[finalI+5].plus();
                    menuFoods(x);
                }
            });

            lab[i+2] = new Label(foods[i+5].getOrder()+"");
            lab[i+2].setTranslateX(b+80);
            lab[i+2].setTranslateY(205);

            rect[i+2] = new Rectangle(90 , 25 , Color.WHITE);
            rect[i+2].setArcHeight(30);
            rect[i+2].setArcWidth(30);
            rect[i+2].setTranslateX(b+40);
            rect[i+2].setTranslateY(200);

            group.getChildren().addAll(rect[i] , imv[i] , but[i] , but[i+2] , lab[i] , rect[i+2] ,
                    lab[i+2]);

        }

        Label lOrder = new Label(foods[x].getOrder()+"");
        lOrder.setTranslateX(90);
        lOrder.setTranslateY(205);


        Rectangle rc = new Rectangle(90 , 25 , Color.WHITE);
        rc.setArcHeight(30);
        rc.setArcWidth(30);
        rc.setTranslateX(50);
        rc.setTranslateY(200);

        ImageView ima = new ImageView(new Image("file:D:/Code/Java/Photo/"+(x+11)+".jpg"));
        ima.setFitHeight(150);
        ima.setFitWidth(150);
        ima.setTranslateX(25);
        ima.setTranslateY(30);

        Rectangle r = new Rectangle(520 , 570 , Color.ORANGERED);
        r.setArcHeight(30);
        r.setArcWidth(30);
        r.setTranslateX(15);
        r.setTranslateY(15);

        Button p = new Button("+");
        Button m = new Button("-");
        p.setTranslateX(150);
        p.setTranslateY(200);
        m.setTranslateX(25);
        m.setTranslateY(200);

        p.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                foods[x].plus();
                menuFoods(x);
            }
        });
        m.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                foods[x].less();
                menuFoods(x);
            }
        });

        Label label = new Label(foods[x].getName()+"  "+foods[x].getPrice()+"T");
        label.setTranslateX(55);
        label.setTranslateY(180);
        label.setFont(Font.font(15));

        Button cart = new Button("Cart->");
        cart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cartOrder();
            }
        });

        cart.setTranslateX(940);
        cart.setTranslateY(550);

        group.getChildren().addAll(backButton , r , ima ,m , p , label , rc , lOrder , cart);

        Scene scene = new Scene(group, 1000, 600);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void signUp(){

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(nameField, 1, 0);

        Label phoneLabel = new Label("Number:");
        TextField phoneField = new TextField();
        GridPane.setConstraints(phoneLabel, 0, 1);
        GridPane.setConstraints(phoneField, 1, 1);

        Label passLabel = new Label("Password:");
        TextField passField = new TextField();
        GridPane.setConstraints(passLabel, 0, 2);
        GridPane.setConstraints(passField, 1, 2);

        Button signupButton = new Button("SignUp");
        GridPane.setConstraints(signupButton, 1, 4);

        grid.getChildren().addAll(nameLabel, nameField, phoneLabel, phoneField, passLabel,
                passField, signupButton );

        signupButton.setOnAction(e -> {
            a.setUserName(nameField.getText());
            a.setPassword(passField.getText());
            a.setNumber(Long.parseLong(phoneField.getText()));
            loginForm();
        });

        Scene scene = new Scene(grid, 1000, 600);
        BackgroundFill backgroundFill = new BackgroundFill(Color.ORANGE, null, null);
        Background background = new Background(backgroundFill);
        grid.setBackground(background);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void cartOrder(){

        Group group = new Group();

        Rectangle r = new Rectangle(550 , 570 , Color.ORANGERED);
        r.setArcHeight(30);
        r.setArcWidth(30);
        r.setTranslateX(15);
        r.setTranslateY(15);

        Rectangle re = new Rectangle( 390 , 100 , Color.ORANGERED);
        re.setArcHeight(30);
        re.setArcWidth(30);
        re.setTranslateX(580);
        re.setTranslateY(15);

        String foodsOrder = "List  :\n";
        String priceOrder = "Price :\n";
        String numberOrder = "Number:\n";
        int total = 0 ;

        for(int i=0 ; i< foods.length ; i++){
            if(foods[i].getOrder()>0){
                foodsOrder += "\n"+foods[i].getName() ;
                numberOrder += "\n"+foods[i].getOrder() ;
                priceOrder += "\n"+foods[i].getPrice() ;
                total += foods[i].getPrice()*foods[i].getOrder();
            }
        }

        Label foodsOr = new Label(foodsOrder);
        foodsOr.setTranslateY(30);
        foodsOr.setTranslateX(30);
        foodsOr.setFont(Font.font("Ta" , FontWeight.BLACK , 16));
        foodsOr.setTextFill(Color.GOLD);

        Label numberOr = new Label(numberOrder);
        numberOr.setTranslateY(30);
        numberOr.setTranslateX(490);
        numberOr.setFont(Font.font("Ta" , FontWeight.BLACK , 16));
        numberOr.setTextFill(Color.GOLD);

        Label priceOr = new Label(priceOrder);
        priceOr.setTranslateY(30);
        priceOr.setTranslateX(250);
        priceOr.setFont(Font.font("Ta" , FontWeight.BLACK , 16));
        priceOr.setTextFill(Color.GOLD);

        Label totalOr = new Label("Total Amount :");
        totalOr.setTranslateY(45);
        totalOr.setTranslateX(585);
        totalOr.setFont(Font.font("Ta" , FontWeight.BLACK , 23));
        totalOr.setTextFill(Color.GOLD);

        Label totalOrder = new Label("" +total);
        totalOrder.setTranslateY(45);
        totalOrder.setTranslateX(900);
        totalOrder.setFont(Font.font("Ta" , FontWeight.BLACK , 23));
        totalOrder.setTextFill(Color.GOLD);

        Button pay = new Button("Pay!! :)");
        pay.setTranslateX(850);
        pay.setTranslateY(500);
        pay.setPrefSize(80 , 30);
        pay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                payment();
            }
        });

        Button back = new Button("Back :|");
        back.setTranslateX(750);
        back.setTranslateY(500);
        back.setPrefSize(80 , 30);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuRestaurant();
            }
        });

        Button delete = new Button("Delete :(");
        delete.setTranslateX(650);
        delete.setTranslateY(500);
        delete.setPrefSize(80 , 30);
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Food food : foods) {
                    food.setOrder(0);
                }
                cartOrder();
            }
        });

        group.getChildren().addAll(r , re , foodsOr , numberOr , priceOr , totalOr , totalOrder
                , pay , back , delete);

        Scene scene = new Scene(group, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void payment(){

        Label be = new Label("You don't need to pay, be my guest ;) ");
        be.setTranslateY(250);
        be.setTranslateX(250);
        be.setTextFill(Color.WHITE);
        be.setFont(Font.font("Ta" , FontPosture.ITALIC , 30));

        Group group = new Group(be);
        Scene scene = new Scene(group, 1000, 600 , Color.ORANGE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage ;
        signUp();
    }
}
