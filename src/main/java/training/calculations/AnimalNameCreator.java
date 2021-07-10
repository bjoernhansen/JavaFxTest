package training.calculations;

import javafx.collections.ObservableList;

public interface AnimalNameCreator
{
    String getSingleName();
    ObservableList<String> getObservableListOfNames();
    AnimalType getAnimalType();
    void addAnimal(String animalName);
}
