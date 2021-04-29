package ru.veqveq.client.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ru.veqveq.client.ClientApplication;

import java.io.InputStream;

public class ClientFxApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage primaryStage) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MainController.class);
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Планировщик задач");
        primaryStage.show();
        InputStream stageLogo = getClass().getResourceAsStream("/ru/veqveq/client/gui/img/stagelogo.png");
        Image icon = new Image(stageLogo);
        primaryStage.getIcons().add(icon);
            }

    @Override
    public void init() {
        String [] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(ClientApplication.class)
                .run(args);
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}
