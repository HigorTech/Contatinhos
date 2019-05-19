package contatinhos.example.higor.contatinhos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ContatinhoAdapter extends RecyclerView.Adapter<ContatinhoViewHolder> {

    private List<Contatinho> contatinhos;
    private Context context;

    public ContatinhoAdapter(List<Contatinho> contatinho, Context context) {
        this.contatinhos = contatinho;
        this.context = context;
    }


    @NonNull
    @Override
    public ContatinhoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View linha = LayoutInflater.from(context).inflate(R.layout.layout_lista,viewGroup,false);


        ContatinhoViewHolder holder = new ContatinhoViewHolder(linha);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContatinhoViewHolder contatoViewHolder, int pos) {

        Contatinho contatinho = contatinhos.get(pos);
        ContatinhoViewHolder.campoNome.setText(contatinho.getNome());  ////erro Aqui O/
        ContatinhoViewHolder.campoTelefone.setText(contatinho.getTelefone());  ////erro Aqui O/

    }

    @Override
    public int getItemCount() {

        return this.contatinhos.size();
    }
}
