package lista;
import modelo.Produto;

public class Lista {
    private No inicio, aux, atual;

    public void inserir(Produto produto) {
        if (inicio == null) {
            inicio = new No(produto, null);
            aux = inicio;
        } else {
            atual = new No(produto, null);
            aux.setProximo(atual);
            aux = atual;
        }
    }

    public void exibir() {
        No e = inicio;
        if (e == null) System.out.println("Lista vazia.");
        while (e != null) {
            System.out.println(e.getProduto());
            e = e.getProximo();
        }
    }

    public Produto pesquisar(int id) {
        No e = inicio;
        while (e != null) {
            if (e.getProduto().getId() == id) {
                return e.getProduto();
            }
            e = e.getProximo();
        }
        return null;
    }

    public boolean atualizar(int id, float preco) {
        No e = inicio;
        while (e != null) {
            if (e.getProduto().getId() == id) {
                e.getProduto().setPreco(preco);
                return true;
            }
            e = e.getProximo();
        }
        return false;
    }

    public boolean remover(int id) {
        No remov = inicio;
        No anterior = null;

        while (remov != null) {
            if (id == remov.getProduto().getId()) {
                break;
            }
            anterior = remov;
            remov = remov.getProximo();
        }

        if (remov != null) {
            if (remov == inicio) {
                inicio = remov.getProximo();
                remov.setProximo(null);
            } else if (remov == atual) {
                atual = anterior;
                aux = anterior;
                anterior.setProximo(null);
            } else {
                anterior.setProximo(remov.getProximo());
                remov.setProximo(null);
            }
            return true;
        }
        return false;
    }

    public void apagarLista() {
        this.inicio = null;
        this.aux = null;
        this.atual = null;
    }

    public void atualizarLista(float P) {
    No e = inicio;
    while (e != null) {
        double precoAtual = e.getProduto().getPreco();
        double novoPreco = precoAtual * (1.0f + (P / 100.0f));
        e.getProduto().setPreco(novoPreco);
        e = e.getProximo();
    }
}
}