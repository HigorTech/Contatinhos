package contatinhos.example.higor.contatinhos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ContatinhoViewHolder extends RecyclerView.ViewHolder {

    public static TextView campoNome;
    public static TextView campoTelefone;


    public ContatinhoViewHolder(@NonNull View itemView) {
        super(itemView);
        campoNome = itemView.findViewById(R.id.nomeContatoId);
        campoTelefone = itemView.findViewById(R.id.telefoneContatoId);

    }
}

