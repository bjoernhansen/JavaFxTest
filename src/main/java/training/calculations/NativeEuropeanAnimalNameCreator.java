package training.calculations;

public class NativeEuropeanAnimalNameCreator extends AbstractAnimalNameCreator
{
    public NativeEuropeanAnimalNameCreator()
    {
        super("Eichhörnchen", "Fuchs", "Dachs");
    }
    
    @Override
    public AnimalType getAnimalType()
    {
        return AnimalType.NATIVE_EUROPEAN;
    }
}