package ru.veqveq.client.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ru.veqveq.client.ClientApplication;

public class ClientFxApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(MainController.class);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        String [] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(ClientApplication.class)
                .run(args);
    }

    @Override
    public void stop() throws Exception {
        this.applicationContext.close();
        Platform.exit();
    }
}
