package modelo;

public class Rainha extends Peca{

    public Rainha(EnumCor cor, int linha, int coluna, String imagem) {
        super(cor, linha, coluna, "/home/operador/Desktop/Xadrez/src/figs/RAINHA"+cor+".gif");
    }

    @Override
    public boolean validaMovimento(int linhaDestino, int colunaDestino) {
        return true;
    }
    
}
