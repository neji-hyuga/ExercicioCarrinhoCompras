package br.com.exerciciocarrinhocompras.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.com.exerciciocarrinhocompras.model.Produto;
import br.com.exerciciocarrinhocompras.repository.ProdutoRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProdutosViewModel extends AndroidViewModel {

    private MutableLiveData<List<Produto>> produtoLiveData = new MutableLiveData<>();

    private ProdutoRepository repository = new ProdutoRepository();
    private CompositeDisposable disposable = new CompositeDisposable();


    public ProdutosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Produto>> getProdutoLiveData() {
        return produtoLiveData;
    }

    public void atualizarProdutos() {

        disposable.add(repository.buscarListProduto()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(produtos -> produtoLiveData.setValue(produtos))

        );
    }


    @Override

    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
