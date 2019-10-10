package br.com.exerciciocarrinhocompras.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.exerciciocarrinhocompras.R;
import br.com.exerciciocarrinhocompras.model.Produto;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ViewHolder> {

    private List<Produto>produtoList = new ArrayList<>();

    public void updateProdutosList(List<Produto> produtoList){
        this.produtoList = produtoList;
        notifyDataSetChanged();

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.produto_item_cel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutosAdapter.ViewHolder holder, int position) {

        Produto produto =produtoList.get(position);
        holder.bind(produto);

    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeProduto;
        private TextView precoProduto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeProduto = itemView.findViewById(R.id.produto_nome_text_view);
            precoProduto = itemView.findViewById(R.id.produto_preco_text_view);

        }

        public void bind (Produto produto){

            nomeProduto.setText(produto.getNomeProduto());

            // preco mantem float e set.text, concatena com uma string qualquer
            precoProduto.setText("R$"+produto.getPrecoProduto());

        }
    }
}
