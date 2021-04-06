package modelo;

public class Bispo extends Peca{

    public Bispo(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, "/home/operador/Desktop/Xadrez/src/figs/BISPO"+cor+".gif");
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
    
}
