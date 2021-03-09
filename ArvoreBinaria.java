public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void imprimir(No no){
        System.out.println(no.toString());

        if(no.filhoDir != null){
            imprimir(no.filhoDir);
        }
        if(no.filhoEsq != null){
            imprimir(no.filhoEsq);
        }
    }

    public void inserir (No no){
        if (this.raiz == null){
            this.raiz = no;
        }else {
            inserirArvore(no, raiz);
        }
    }

    public void inserirArvore(No no, No pai){
        if(no.valor > pai.valor){
            if (pai.filhoDir == null){
                pai.filhoDir = no;
                no.pai = pai;
            }else{
                inserirArvore(no, pai.filhoDir);
            }

        }else if(no.valor < pai.valor){
            if (pai.filhoEsq == null){
                pai.filhoEsq = no;
                no.pai = pai;
            }else{
                inserirArvore(no, pai.filhoEsq);
            }
        }
    }

    public No busca(No no, int valor) {
        if (no.valor == valor) {
            return no;
        } else if (valor > no.valor) {
            if (no.filhoDir == null){
                return null;
            } else {
                return busca(no.filhoDir, valor);
            }
        } else {
            if (no.filhoEsq == null){
                return null;
            } else {
                return busca(no.filhoEsq, valor);
            }
        }
    }

    public void visita(No no) {
        System.out.println(no.valor);
    }

    public void ordem(No no) {
        if (no != null) {
            ordem(no.filhoEsq);
            visita(no);
            ordem(no.filhoDir);
        }
    }

    public void preOrdem(No no) {
        if (no != null) {
            visita(no);
            preOrdem(no.filhoEsq);
            preOrdem(no.filhoDir);
        }
    }

    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.filhoEsq);
            posOrdem(no.filhoDir);
            visita(no);
        }
    }

    public boolean remover(long v) {
        if (raiz == null) {
            return false;
        }

        No atual = raiz;
        No pai = raiz;
        boolean filho_esq = true;


        while (atual.valor != v) {
            pai = atual;
            if (v < atual.valor) {
                atual = atual.filhoEsq;
                filho_esq = true;
            } else {
                atual = atual.filhoDir;
                filho_esq = false;
            }
            if (atual == null) {
                return false;
            }
        }


        if (atual.filhoEsq == null && atual.filhoDir == null) {
            if (atual == raiz) {
                raiz = null;
            } else if (filho_esq) {
                pai.filhoEsq = null;
            } else {
                pai.filhoDir = null;
            }
        } else if (atual.filhoDir == null) {
            if (atual == raiz) {
                raiz = atual.filhoEsq;
            } else if (filho_esq) {
                pai.filhoEsq = atual.filhoEsq;
            } else {
                pai.filhoDir = atual.filhoEsq;
            }
        } else if (atual.filhoEsq == null) {
            if (atual == raiz) {
                raiz = atual.filhoDir;
            } else if (filho_esq) {
                pai.filhoEsq = atual.filhoDir;
            } else {
                pai.filhoDir = atual.filhoDir;
            }
        } else {
            No sucessor = no_sucessor(atual);

            if (atual == raiz) {
                raiz = sucessor;
            } else if (filho_esq) {
                pai.filhoEsq = sucessor;
            } else {
                pai.filhoDir = sucessor;
            }
            sucessor.filhoEsq = atual.filhoEsq;
        }

        return true;
    }

    public No no_sucessor(No apaga) {
        No paidosucessor = apaga;
        No sucessor = apaga;
        No atual = apaga.filhoDir;

        while (atual != null) {
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.filhoEsq;
        }

        if (sucessor != apaga.filhoDir) {
            paidosucessor.filhoEsq = sucessor.filhoDir;
            sucessor.filhoDir = apaga.filhoDir;
        }
        return sucessor;
    }

}
