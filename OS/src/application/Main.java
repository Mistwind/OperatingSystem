package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
        try {
            // �����root��FXML�ļ��м��ؽ��г�ʼ��������FXMLLoader�����ڼ���FXML�ļ�
        	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("MainWin.fxml"));
            Scene scene = new Scene(root, 900, 700);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello World");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
