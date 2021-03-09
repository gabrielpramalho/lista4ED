public class main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(new No(5));
        arvore.inserir(new No(7));
        arvore.inserir(new No(2));
        arvore.inserir(new No(8));
        arvore.remover(8);

        arvore.imprimir(arvore.raiz);

    }
}
