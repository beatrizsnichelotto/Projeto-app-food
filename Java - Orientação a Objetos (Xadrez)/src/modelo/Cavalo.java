package modelo;

public class Cavalo extends Peca {

    public Cavalo(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, "/home/operador/Desktop/Xadrez/src/figs/CAVALO"+cor+".gif");
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
    
}
