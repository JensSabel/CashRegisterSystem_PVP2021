package com.example.demo;

import com.example.demo.service.JarOpener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication extends Application {

	private ConfigurableApplicationContext springContext;
	private Scene scene1;
	private Scene scene2;

	public static void main(String[] args) throws IOException {
		JarOpener shotGun = new JarOpener();
		shotGun.openJar();
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(DemoApplication.class);

		FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/CashierGUI.fxml"));
		fxmlLoader1.setControllerFactory(springContext::getBean);
		scene1 = new Scene(fxmlLoader1.load(), 600, 400);

		FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/CustomerGUI.fxml"));
		fxmlLoader2.setControllerFactory(springContext::getBean);
		scene2 = new Scene(fxmlLoader2.load(), 600, 400);
	}

	@Override
	public void start(Stage cashierStage) throws Exception {

		Stage customerStage = new Stage();

		cashierStage.setTitle("CashierGUI");
		cashierStage.setScene(scene1);
		cashierStage.show();

		customerStage.setTitle("CustomerGUI");
		customerStage.setScene(scene2);
		customerStage.show();
	}

	@Override
	public void stop() throws Exception {
		this.springContext.close();
		Platform.exit();
	}
}
