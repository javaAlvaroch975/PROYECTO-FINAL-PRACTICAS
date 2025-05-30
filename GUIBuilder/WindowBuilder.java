import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WindowBuilder extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My Awesome Window");

        Pane pane = new Pane();
        pane.setPrefSize(937, 470);
        pane.setStyle("-fx-background-color: #f4c064;");

        Button ButAñadirUsuario = new Button("Añadir");
        ButAñadirUsuario.setLayoutX(60.79);
        ButAñadirUsuario.setLayoutY(291.22);
        ButAñadirUsuario.setPrefWidth(105.81);
        ButAñadirUsuario.setPrefHeight(30.00);
        ButAñadirUsuario.setDisable(false);
        ButAñadirUsuario.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ButAñadirUsuario.setStyle("-fx-background-color: #bca8e4; -fx-text-fill: #000; -fx-border-color: #3d364a; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ButAñadirUsuario.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ButAñadirUsuario.setBackground(new Background(new BackgroundFill(Color.web("#7c6f97"), new CornerRadii(4.00), null))); });
        ButAñadirUsuario.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ButAñadirUsuario.setBackground(new Background(new BackgroundFill(Color.web("#bca8e4"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ButAñadirUsuario);

        Button ButActualizarUSuario = new Button("Actualizar");
        ButActualizarUSuario.setLayoutX(212.78);
        ButActualizarUSuario.setLayoutY(292.22);
        ButActualizarUSuario.setPrefWidth(105.81);
        ButActualizarUSuario.setPrefHeight(30.00);
        ButActualizarUSuario.setDisable(false);
        ButActualizarUSuario.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ButActualizarUSuario.setStyle("-fx-background-color: #bca8e4; -fx-text-fill: #000; -fx-border-color: #3d364a; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ButActualizarUSuario.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ButActualizarUSuario.setBackground(new Background(new BackgroundFill(Color.web("#7c6f97"), new CornerRadii(4.00), null))); });
        ButActualizarUSuario.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ButActualizarUSuario.setBackground(new Background(new BackgroundFill(Color.web("#bca8e4"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ButActualizarUSuario);

        Button ButBorrarAlumno = new Button("Borrar");
        ButBorrarAlumno.setLayoutX(136.19);
        ButBorrarAlumno.setLayoutY(347.22);
        ButBorrarAlumno.setPrefWidth(105.81);
        ButBorrarAlumno.setPrefHeight(30.00);
        ButBorrarAlumno.setDisable(false);
        ButBorrarAlumno.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ButBorrarAlumno.setStyle("-fx-background-color: #bca8e4; -fx-text-fill: #000; -fx-border-color: #3d364a; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ButBorrarAlumno.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ButBorrarAlumno.setBackground(new Background(new BackgroundFill(Color.web("#7c6f97"), new CornerRadii(4.00), null))); });
        ButBorrarAlumno.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ButBorrarAlumno.setBackground(new Background(new BackgroundFill(Color.web("#bca8e4"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ButBorrarAlumno);

        Button ButAñadirRol = new Button("Añadir");
        ButAñadirRol.setLayoutX(594.79);
        ButAñadirRol.setLayoutY(285.22);
        ButAñadirRol.setPrefWidth(105.81);
        ButAñadirRol.setPrefHeight(30.00);
        ButAñadirRol.setDisable(false);
        ButAñadirRol.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ButAñadirRol.setStyle("-fx-background-color: #bca8e4; -fx-text-fill: #000; -fx-border-color: #3d364a; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ButAñadirRol.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ButAñadirRol.setBackground(new Background(new BackgroundFill(Color.web("#7c6f97"), new CornerRadii(4.00), null))); });
        ButAñadirRol.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ButAñadirRol.setBackground(new Background(new BackgroundFill(Color.web("#bca8e4"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ButAñadirRol);

        Button ButActualizarRol = new Button("Rol");
        ButActualizarRol.setLayoutX(745.78);
        ButActualizarRol.setLayoutY(285.22);
        ButActualizarRol.setPrefWidth(105.81);
        ButActualizarRol.setPrefHeight(30.00);
        ButActualizarRol.setDisable(false);
        ButActualizarRol.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ButActualizarRol.setStyle("-fx-background-color: #bca8e4; -fx-text-fill: #000; -fx-border-color: #3d364a; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ButActualizarRol.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ButActualizarRol.setBackground(new Background(new BackgroundFill(Color.web("#7c6f97"), new CornerRadii(4.00), null))); });
        ButActualizarRol.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ButActualizarRol.setBackground(new Background(new BackgroundFill(Color.web("#bca8e4"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ButActualizarRol);

        Button ButBorrarRol = new Button("Borrar");
        ButBorrarRol.setLayoutX(671.00);
        ButBorrarRol.setLayoutY(337.22);
        ButBorrarRol.setPrefWidth(105.81);
        ButBorrarRol.setPrefHeight(30.00);
        ButBorrarRol.setDisable(false);
        ButBorrarRol.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        ButBorrarRol.setStyle("-fx-background-color: #bca8e4; -fx-text-fill: #000; -fx-border-color: #3d364a; -fx-border-radius: 4px; -fx-background-radius: 4px; -fx-border-width: 1px;");
        ButBorrarRol.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> { ButBorrarRol.setBackground(new Background(new BackgroundFill(Color.web("#7c6f97"), new CornerRadii(4.00), null))); });
        ButBorrarRol.addEventFilter(MouseEvent.MOUSE_RELEASED, e -> { ButBorrarRol.setBackground(new Background(new BackgroundFill(Color.web("#bca8e4"), new CornerRadii(4.00), null))); });
        pane.getChildren().add(ButBorrarRol);

        Label lblIDAlumno = new Label("ID Alumno");
        lblIDAlumno.setLayoutX(58);
        lblIDAlumno.setLayoutY(131.96875);
        lblIDAlumno.setPrefWidth(105.8125);
        lblIDAlumno.setPrefHeight(18);
        lblIDAlumno.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        lblIDAlumno.setStyle("-fx-text-fill: #000;");
        pane.getChildren().add(lblIDAlumno);

        Label lblNombreAlumno = new Label("Nombre");
        lblNombreAlumno.setLayoutX(56);
        lblNombreAlumno.setLayoutY(185);
        lblNombreAlumno.setPrefWidth(105.8125);
        lblNombreAlumno.setPrefHeight(18);
        lblNombreAlumno.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        lblNombreAlumno.setStyle("-fx-text-fill: #000;");
        pane.getChildren().add(lblNombreAlumno);

        Label lblClan = new Label("Clan");
        lblClan.setLayoutX(50.78125);
        lblClan.setLayoutY(240.96875);
        lblClan.setPrefWidth(105.8125);
        lblClan.setPrefHeight(18);
        lblClan.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        lblClan.setStyle("-fx-text-fill: #000;");
        pane.getChildren().add(lblClan);

        TextField txtIDAlumno = new TextField("");
        txtIDAlumno.setLayoutX(154.79);
        txtIDAlumno.setLayoutY(129.72);
        txtIDAlumno.setPrefWidth(105.81);
        txtIDAlumno.setPrefHeight(24.00);
        txtIDAlumno.setPromptText("Your Input!");
        txtIDAlumno.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        txtIDAlumno.setStyle("-fx-background-color: #ffe7bf; -fx-text-fill: #000; -fx-border-color: #000; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #73664e;");
        pane.getChildren().add(txtIDAlumno);

        TextField txtNombreAlumno = new TextField("");
        txtNombreAlumno.setLayoutX(153.79);
        txtNombreAlumno.setLayoutY(180.72);
        txtNombreAlumno.setPrefWidth(105.81);
        txtNombreAlumno.setPrefHeight(24.00);
        txtNombreAlumno.setPromptText("Your Input!");
        txtNombreAlumno.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        txtNombreAlumno.setStyle("-fx-background-color: #ffe7bf; -fx-text-fill: #000; -fx-border-color: #000; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #73664e;");
        pane.getChildren().add(txtNombreAlumno);

        TextField txtNombreClan = new TextField("");
        txtNombreClan.setLayoutX(153.79);
        txtNombreClan.setLayoutY(236.72);
        txtNombreClan.setPrefWidth(105.81);
        txtNombreClan.setPrefHeight(24.00);
        txtNombreClan.setPromptText("Your Input!");
        txtNombreClan.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        txtNombreClan.setStyle("-fx-background-color: #ffe7bf; -fx-text-fill: #000; -fx-border-color: #000; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #73664e;");
        pane.getChildren().add(txtNombreClan);

        TextField txtIDRol = new TextField("");
        txtIDRol.setLayoutX(737.79);
        txtIDRol.setLayoutY(129.72);
        txtIDRol.setPrefWidth(105.81);
        txtIDRol.setPrefHeight(24.00);
        txtIDRol.setPromptText("Your Input!");
        txtIDRol.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        txtIDRol.setStyle("-fx-background-color: #ffe7bf; -fx-text-fill: #000; -fx-border-color: #000; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #73664e;");
        pane.getChildren().add(txtIDRol);

        Label lblNombreRol = new Label("Nombre");
        lblNombreRol.setLayoutX(616.78125);
        lblNombreRol.setLayoutY(184.96875);
        lblNombreRol.setPrefWidth(105.8125);
        lblNombreRol.setPrefHeight(18);
        lblNombreRol.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        lblNombreRol.setStyle("-fx-text-fill: #000;");
        pane.getChildren().add(lblNombreRol);

        Label lblTipoDanyo = new Label("Tipo Daño");
        lblTipoDanyo.setLayoutX(614.78125);
        lblTipoDanyo.setLayoutY(232.96875);
        lblTipoDanyo.setPrefWidth(105.8125);
        lblTipoDanyo.setPrefHeight(18);
        lblTipoDanyo.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        lblTipoDanyo.setStyle("-fx-text-fill: #000;");
        pane.getChildren().add(lblTipoDanyo);

        TextField txtNombreRol = new TextField("");
        txtNombreRol.setLayoutX(738.79);
        txtNombreRol.setLayoutY(179.72);
        txtNombreRol.setPrefWidth(105.81);
        txtNombreRol.setPrefHeight(24.00);
        txtNombreRol.setPromptText("Your Input!");
        txtNombreRol.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        txtNombreRol.setStyle("-fx-background-color: #ffe7bf; -fx-text-fill: #000; -fx-border-color: #000; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #73664e;");
        pane.getChildren().add(txtNombreRol);

        TextField txtTipoDanyo = new TextField("");
        txtTipoDanyo.setLayoutX(741.78);
        txtTipoDanyo.setLayoutY(236.72);
        txtTipoDanyo.setPrefWidth(105.81);
        txtTipoDanyo.setPrefHeight(24.00);
        txtTipoDanyo.setPromptText("Your Input!");
        txtTipoDanyo.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        txtTipoDanyo.setStyle("-fx-background-color: #ffe7bf; -fx-text-fill: #000; -fx-border-color: #000; -fx-border-width: 1px; -fx-border-radius: 2px; -fx-prompt-text-fill: #73664e;");
        pane.getChildren().add(txtTipoDanyo);

        Label lblIDRol = new Label("ID Rol");
        lblIDRol.setLayoutX(619.78125);
        lblIDRol.setLayoutY(133.96875);
        lblIDRol.setPrefWidth(105.8125);
        lblIDRol.setPrefHeight(18);
        lblIDRol.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Lexend.ttf"), 14.00));
        lblIDRol.setStyle("-fx-text-fill: #000;");
        pane.getChildren().add(lblIDRol);

        Scene scene = new Scene(pane, 937, 470);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}