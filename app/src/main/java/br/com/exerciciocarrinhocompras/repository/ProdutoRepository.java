package br.com.exerciciocarrinhocompras.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.exerciciocarrinhocompras.model.Produto;
import io.reactivex.Observable;

public class ProdutoRepository {

    public Observable<List<Produto>> buscarListProduto(){

        return Observable.create(emitter -> {

            List<Produto>produtoList = new ArrayList<>();
            Produto produto1 = new Produto();
            produto1.setNomeProduto("Boné Palace");
            produto1.setPrecoProduto(89.90f);
            produtoList.add(produto1);


            Produto produto2 = new Produto();
            produto2.setNomeProduto("Jaqueta Obey");
            produto2.setPrecoProduto(290.90f);
            produtoList.add(produto2);

            Produto produto3 = new Produto();
            produto3.setNomeProduto("Calça Chino Santa Cruz");
            produto3.setPrecoProduto(189.90f);
            produtoList.add(produto3);

            Produto produto4 = new Produto();
            produto4.setNomeProduto("Camiseta DC");
            produto4.setPrecoProduto(49.90f);
            produtoList.add(produto4);

            Produto produto5 = new Produto();
            produto5.setNomeProduto("Touca Diamond");
            produto5.setPrecoProduto(89.98f);
            produtoList.add(produto5);

            Produto produto6 = new Produto();
            produto6.setNomeProduto("Camiseta Supreme x Palace");
            produto6.setPrecoProduto(289.90f);
            produtoList.add(produto6);

            emitter.onNext(produtoList);
            emitter.onComplete();

        });

    }
}
