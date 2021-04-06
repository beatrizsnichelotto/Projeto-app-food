package modelo;

public class Rei extends Peca {

    public Rei(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, "/home/operador/Desktop/Xadrez/src/figs/REI"+cor+".gif");
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
    
}
