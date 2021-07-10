package training.calculations;

import javafx.concurrent.Task;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;


public class ExpensiveTask extends Task<String>
{
    private Integer duration;
    
    public ExpensiveTask(Integer duration)
    {
        this.duration = duration;
    }
    
    public String call()
    {
        LocalDateTime now = LocalDateTime.now();
        someSlowFunction();
        return now.toString();
    }
    
    private void someSlowFunction()
    {
        try
        {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}