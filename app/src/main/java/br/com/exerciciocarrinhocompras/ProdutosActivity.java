package br.com.exerciciocarrinhocompras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import br.com.exerciciocarrinhocompras.adapter.ProdutosAdapter;
import br.com.exerciciocarrinhocompras.viewmodel.ProdutosViewModel;

public class ProdutosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProdutosAdapter produtosAdapter = new ProdutosAdapter();
    private ProdutosViewModel produtosViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        recyclerView = findViewById(R.id.produtos_recycler_id);
        recyclerView.setAdapter(produtosAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        produtosViewModel = ViewModelProviders.of(this).get(ProdutosViewModel.class);
        produtosViewModel.atualizarProdutos();
        produtosViewModel.getProdutoLiveData()
                .observe(this, produtos -> {

                    produtosAdapter.updateProdutosList(produtos);

                });




    }
}
