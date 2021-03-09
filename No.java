public class No {
    int valor;
    No pai, filhoEsq, filhoDir;

    public No(int valor){
        this.valor = valor;
        this.pai = null;
        this.filhoDir = null;
        this.filhoEsq = null;
    }

    @Override
    public String toString(){
        if (this.filhoDir != null && this.filhoEsq != null){
            return "Esq: " + this.filhoEsq.valor + " <- " + this.valor + " -> " + "Dir: " + this.filhoDir.valor;
        }else if(this.filhoEsq == null && this.filhoDir != null){
            return "Esq: x" + " <- " + this.valor + " -> "+ "Dir: "+ this.filhoDir.valor;
        }else if(this.filhoEsq != null && this.filhoDir == null){
            return "Esq: " + this.filhoEsq.valor + " <- " + this.valor + " -> " + "Dir: x";
        } else {
            return "Esq: x <- " + this.valor + " -> Dir: x";
        }
    }
}
