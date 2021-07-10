package calculations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.calculations.AnimalNameCreator;
import training.calculations.AnimalType;
import training.calculations.NativeEuropeanAnimalNameCreator;

class NativeEuropeanAnimalNameCreatorTest
{
    private AnimalNameCreator animalNameCreator;
    
    @BeforeEach
    void setUp()
    {
        animalNameCreator = new NativeEuropeanAnimalNameCreator();
    }
    
    @Test
    void getAnimalType()
    {
        Assertions.assertEquals(animalNameCreator.getAnimalType(), AnimalType.NATIVE_EUROPEAN);
    }
}