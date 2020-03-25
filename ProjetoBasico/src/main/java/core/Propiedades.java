package core;

public class Propiedades {

    public static boolean FECHAR_BROWSER = true;

    public static Browser browser = Browser.CHROME;

    public static String NOME_CONTA_ALTERADA = "Conta do Teste Alterada" + System.nanoTime();

    public enum Browser{
            CHROME,
            FIREFOX
    }
}
