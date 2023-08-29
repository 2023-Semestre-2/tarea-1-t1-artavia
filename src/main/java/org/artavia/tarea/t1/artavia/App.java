package org.artavia.tarea.t1.artavia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import org.artavia.tarea.t1.artavia.model.AsmModel;
import org.artavia.tarea.t1.artavia.model.MemoryModel;
import org.artavia.tarea.t1.artavia.model.MiniPcModel;

/** JavaFX App */
public class App extends Application {

  private static Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("MainProgramView"), 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
    return fxmlLoader.load();
  }

  public static void main(String[] args) {

    String filepath = "/home/alex/Descargas/Test01.asm";
    AsmModel asmFile = new AsmModel(filepath);

    MiniPcModel minipc = new MiniPcModel(asmFile);
    minipc.getMiniPcMemory().printMemoryTerminal();
    launch();
  }
}