package se.inera.intyg.fmbaiservice;

public class SystemPromt {

  public final static String PROMT_RETURN_DATA = """
      Utifrån varje rubrik jämför om bedömningen följer rekommendationen eller inte.
      Definitionen på att det inte följer rekommendationen är information motsäger rekomendationen.
      Svara med textexempel
      Strukturera svaret utifrån rubrikerna i intyget.
      ##Exempel på rubrik
      Följer rekommendationen: Här ska du skriva textexempel i punktform
      Följer inte rekommendationen: Här ska du skriva textexempel i punktform
      
      """;
}