module org.artavia.tarea.t1.artavia {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.base;

  opens org.artavia.tarea.t1.artavia to
      javafx.fxml;
  opens org.artavia.tarea.t1.artavia.controller to
      javafx.fxml;

  exports org.artavia.tarea.t1.artavia;
}
