package calculations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.calculations.AfricanAnimalNameCreator;
import training.calculations.AnimalNameCreator;
import training.calculations.AnimalType;

import java.io.FileNotFoundException;

class AfricanAnimalNameCreatorTest
{
    private AnimalNameCreator animalNameCreator;
    
    @BeforeEach
    void setUp()
    {
        animalNameCreator = new AfricanAnimalNameCreator();
    }
    
    @Test
    void shouldReturnCorrectAnimalNameTyp()
    {
        Assertions.assertEquals(AnimalType.AFRICAN, animalNameCreator.getAnimalType(), "Wrong animal type");
    }
    
    @Test
    void shouldCorrectlyAddNewAnimals()
    {
        String newAnimalName = "noAnimalName";
        int numberOfAfricanAnimals = animalNameCreator.getObservableListOfNames().size();
        Assertions.assertFalse(animalNameCreator.getObservableListOfNames().contains(newAnimalName));
        animalNameCreator.addAnimal(newAnimalName);
        Assertions.assertEquals(numberOfAfricanAnimals + 1, animalNameCreator.getObservableListOfNames().size());
        Assertions.assertTrue(animalNameCreator.getObservableListOfNames().contains(newAnimalName), "Animal was not added to animal list");
    }
    
    @Test()
    void shouldThrowFileNotFoundException()
    {
        Assertions.assertThrows(FileNotFoundException.class, () -> {throw new FileNotFoundException();});
    }
}