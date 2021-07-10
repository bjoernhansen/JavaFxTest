package training.calculations;

public class AfricanAnimalNameCreator extends AbstractAnimalNameCreator
{
    public AfricanAnimalNameCreator()
    {
        super("Elefant", "Zebra", "Löwe", "Nashorn");
    }
    
    @Override
    public AnimalType getAnimalType()
    {
        return AnimalType.AFRICAN;
    }
}