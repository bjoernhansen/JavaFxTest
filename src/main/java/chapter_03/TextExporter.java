package chapter_03;

public class TextExporter implements Exporter
{
    @Override
    public String export(final SummaryStatistics summaryStatistics)
    {
        String result = "Bank Transaction Report"
                + "\nThe sum is " + summaryStatistics.getSum()
                + "\nThe average is: " + summaryStatistics.getAverage()
                + "\nThe max is: " + summaryStatistics.getMax()
                + "\nThe min is: " + summaryStatistics.getMin() + "\n";
        return result;
    }
}
