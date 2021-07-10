package chapter_03;


public class MainApplication {

    public static void main(final String[] args) throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        final Exporter exporter = new TextExporter();

        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser, exporter);

    }
}
