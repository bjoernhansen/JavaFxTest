package training;

import training.calculations.*;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;


public class Controller
{
    @FXML
    private Button printRandomAnimalNameButton;
    
    @FXML
    private Button printAllAnimalNamesButton;
    
    @FXML
    private Button addAnimalButton;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private Button stopAnimationButton;
    
    @FXML
    private Button startAnimationButton;
    
    @FXML
    private RadioButton africanAnimalRadioButton;
    
    @FXML
    private RadioButton nativeEuropeanAnimalRadioButton;
    
    @FXML
    private TextField animalNameTextField;
    
    @FXML
    private Canvas animationCanvas;
    
    @FXML
    private Label taskLabel;
    
    @FXML
    private Button taskStartButton;
    
    @FXML
    private Spinner<Integer> taskDurationSpinner;
    
    @FXML
    ListView<String> animalListView;
    
    @FXML
    ComboBox<String> animalListComboBox;
    
    @FXML
    Label animalLabel;
    
    
    private AnimalNameCreator animalNameCreator = new AfricanAnimalNameCreator();
    private AnimationTimer animationTimer;
    private Image earth, sun, space ;
    private double v = 1.0, t = 0.0;
    private long lastCurrentNanoTime;

    
    
    @FXML
    void initialize(){
        earth = new Image(getClass().getResource("/earth.png")
                .toString());
        sun = new Image(getClass().getResource("/sun.png")
                .toString());
        space = new Image(getClass().getResource("/space.png")
                .toString());
        
        taskDurationSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 6));
  
        animalListView.setItems(animalNameCreator.getObservableListOfNames());
        animalListComboBox.setItems(animalNameCreator.getObservableListOfNames());
        animalListComboBox.getSelectionModel().select(0);
        
        printRandomAnimalNameButton.getTransforms().add(new Rotate(5, 50, 30));
        printRandomAnimalNameButton.getTransforms().add(new Scale(0.9, 1.1 ));
        
        System.out.println("Initialized Controller");
        start();
    }
    
    private void start(){
        GraphicsContext gc = animationCanvas.getGraphicsContext2D();
        
        lastCurrentNanoTime = System.nanoTime();
    
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double elapsedTimeSinceLastCall = (currentNanoTime - lastCurrentNanoTime) / 1000000000.0;
                lastCurrentNanoTime = currentNanoTime;
                t += elapsedTimeSinceLastCall * v;
            
                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);
            
                // Clear the canvas
                gc.clearRect(0, 0, 512, 512);
            
                // background image clears canvas
                gc.drawImage(space, 0, 0);
                gc.drawImage(earth, x, y);
                gc.drawImage(sun, 196, 196);
            }
        };
        animationTimer.start();
    }
    
    public void handlePrintRandomNameAction(ActionEvent actionEvent)
    {
        System.out.println(animalNameCreator.getSingleName());
        System.out.println();
    }
    
    public void handlePrintAllNamesAction(ActionEvent actionEvent)
    {
        System.out.println("All animal Names:");
        animalNameCreator.getObservableListOfNames().forEach(System.out::println);
        System.out.println();
    }
    
    public void handleAnimalNamesChangedAction(ActionEvent actionEvent)
    {
        updateAnimalNameCreator();
    }
    
    public void handleAddAnimalAction(ActionEvent actionEvent)
    {
        if(!animalNameTextField.getText().isBlank())
        {
            animalNameCreator.addAnimal(animalNameTextField.getText());
        }
    }
    
    public void handleSlowDownAction(ActionEvent actionEvent)
    {
        v/=1.05;
    }
    
    public void handleSpeedUpAction(ActionEvent actionEvent)
    {
        v*=1.05;
    }
    
    private void updateAnimalNameCreator()
    {
        if (africanAnimalRadioButton.isSelected() && animalNameCreator.getAnimalType() != AnimalType.AFRICAN)
        {
            animalNameCreator = new AfricanAnimalNameCreator();
        }
        else if (nativeEuropeanAnimalRadioButton.isSelected() && animalNameCreator.getAnimalType() != AnimalType.NATIVE_EUROPEAN)
        {
            animalNameCreator = new NativeEuropeanAnimalNameCreator();
        }
        animalListView.setItems(animalNameCreator.getObservableListOfNames());
        animalListComboBox.setItems(animalNameCreator.getObservableListOfNames());
    }
    
    public void handleStartAnimatonEvent(Event actionEvent)
    {
        animationTimer.start();
    }
    
    public void handleStopAnimationEvent(Event actionEvent)
    {
        animationTimer.stop();
    }
    
    public void handleTaskStartEvent(Event actionEvent)
    {
        Task<String> task = new ExpensiveTask(taskDurationSpinner.getValue());
        new Thread(task).start();
        task.setOnSucceeded(event -> taskLabel.setText("Ergebnis: " + task.getValue()));
    }
    
    public void handleComboBoxAnimalSelectionEvent(ActionEvent actionEvent)
    {
        animalLabel.setText(animalListComboBox.getSelectionModel().getSelectedItem());
    }
    
    public void handleListViewAnimalSelectionEvent(MouseEvent actionEvent)
    {
        animalLabel.setText(animalListView.getSelectionModel().getSelectedItem());
    }
    
    public void handleCloseAction(ActionEvent actionEvent)
    {
        Platform.exit();
    }
}