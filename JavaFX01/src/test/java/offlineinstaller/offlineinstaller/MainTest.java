package offlineinstaller.offlineinstaller;
/**
 * 
 */

import org.apache.log4j.Logger;

/**
 * @author 584326
 *
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainTest extends Application implements EventHandler<ActionEvent>{
	final static Logger logger = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	Button btnStartTest;
	Button btnExitTest;
	Scene scene;
	Stage primaryStage;
	int dialogReturnValue;
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		logger.info("this is start of start method");
		primaryStage.setTitle("Offline Installer");
		this.primaryStage = primaryStage;
		
		btnStartTest = new Button();
		btnStartTest.setText("Start");
		btnStartTest.setLayoutY(100);
		btnStartTest.setLayoutX(10);
		btnStartTest.setOnAction(this);
			
		btnExitTest = new Button();
		btnExitTest.setText("Exit");
		btnExitTest.setLayoutX(200);
		btnExitTest.setLayoutY(100);
		btnExitTest.setOnAction(this);
		
		Pane layout = new Pane();
		layout.getChildren().add(btnStartTest);
		layout.getChildren().add(btnExitTest);
		
		scene = new Scene(layout,400,200);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void handle(ActionEvent event) {
		
		String whichButton = ((Button)event.getSource()).getText();
		
		switch (whichButton) {
		case "Start":
			
			btnStartTest = new BtnStartTest(event);
		
			break;
			
		case "Exit":
			logger.info("Exit button was clicked");
			
			btnExitTest = new BtnExitTest(event,primaryStage);
			break;
		}

	}
}