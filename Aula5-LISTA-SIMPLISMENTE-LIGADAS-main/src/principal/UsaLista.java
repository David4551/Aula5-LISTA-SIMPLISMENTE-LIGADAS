package principal;

import lista.Lista;
import modelo.Produto;

public class UsaLista {
    public static void main(String[] args) {
        Lista lista = new Lista();

        lista.inserir(new Produto("Café", 40.34f));
        lista.inserir(new Produto("Azeite", 38.67f));
        lista.inserir(new Produto("Arroz", 25.78f));
        lista.inserir(new Produto("Celular", 1234.56f));

        // --- metodo de pesquisa  ---
        System.out.println("=== PESQUISA ===");
        System.out.println("Pesquisa ID 2: " + lista.pesquisar(2));

        // --- metodo de atualização ---
        System.out.println("\n=== ATUALIZAÇÃO UNITÁRIA ===");
        if (lista.atualizar(2, 53.59f)) {
            System.out.println("Produto ID 2 atualizado com sucesso.");
        }
        System.out.println("Lista após atualização:");
        lista.exibir();
        
        // --- metodo para eu remover o produto ---
        System.out.println("\n=== REMOÇÃO ===");
        Produto pRemover = lista.pesquisar(1);
        System.out.println("Testando remoção: " + (pRemover != null ? pRemover : "Não encontrado")); 
        
        if (lista.remover(1)) {
            System.out.println("Lista após remoção:");
            lista.exibir();
        } else {
            System.out.println("Não encontrou nenhum ID para remover.");
        }

        // --- atualização (porcentagem) ---
        System.out.println("\n=== ATUALIZAÇÃO DA LISTA (REAJUSTE %) ===");
        float porcentagem = 10.0f;
        System.out.println("Aplicando " + porcentagem + "% de aumento em todos os itens...");
        lista.atualizarLista(porcentagem);
        lista.exibir();

        // --- Exclusão total ---
        System.out.println("\n=== ESVAZIAR LISTA ===");
        System.out.println("Apagando a lista completa...");
        lista.apagarLista();
        
        // Verificação final do projeto
        System.out.print("Estado atual da lista: ");
        lista.exibir(); // Se estiver vazia, não imprimirá nada conforme sua lógica
        System.out.println("[FIM DA OPERAÇÃO]");
    }
}