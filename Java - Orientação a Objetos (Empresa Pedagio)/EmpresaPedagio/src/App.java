import modelo.*;

public class App {

    public static void main(String[] args) throws Exception {

    Concessionaria minhaConcessionaria = new Concessionaria();
    

    minhaConcessionaria.setNome("Concessionaria aaa");
        
    Praca praca01 = new Praca();
    praca01.setCidade("Curitiba");

    Praca praca02 = new Praca();
    praca02.setCidade("Rio de Janeiro");
    
    Praca praca03 = new Praca();
    praca03.setCidade("Salvador");

    minhaConcessionaria.adicionarPraca(praca01);
    minhaConcessionaria.adicionarPraca(praca02);
    minhaConcessionaria.adicionarPraca(praca03);

    minhaConcessionaria.adicionarPraca(praca01);

    ClasseA objClasseA = (ClasseA) minhaConcessionaria;
    praca01.setConcessionaria(objClasseA);

    }
}