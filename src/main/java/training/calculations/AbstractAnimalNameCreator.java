package training.calculations;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class AbstractAnimalNameCreator implements AnimalNameCreator
{
    private ObservableList<String> animals;
    private Random random = new Random();
    
    protected AbstractAnimalNameCreator(String... names)
    {
        animals = FXCollections.observableList(new ArrayList<>(Arrays.asList(names)));
    }
    
    @Override
    public String getSingleName()
    {
        return animals.get(random.nextInt(animals.size()));
    }
    
    @Override
    public ObservableList<String> getObservableListOfNames()
    {
        return animals;
    }
    
    @Override
    public void addAnimal(String animalName)
    {
        animals.add(animalName);
    }
}