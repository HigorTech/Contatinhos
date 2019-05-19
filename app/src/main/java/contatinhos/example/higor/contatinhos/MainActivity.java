package contatinhos.example.higor.contatinhos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button adicionar;
    ContatinhoDAO dao;


    @Override
    protected void onStart() {
        super.onStart();

        RecyclerView recyclerView = findViewById(R.id.minhaLista);
        dao = new ContatinhoDAO(MainActivity.this);
        List<Contatinho> contatinhos = new ArrayList<Contatinho>();

       contatinhos = dao.buscarTodosContatinhos();


        contatinhos.add(new Contatinho(1,"Gabriela","064993-00000","My best Friend"));
        contatinhos.add(new Contatinho(2,"Felipe","064993-00000","My best Friend 2"));
        contatinhos.add(new Contatinho(3,"Gilmar","064993-00000","My Friend"));
        contatinhos.add(new Contatinho(3,"Igor","064993-00000","My Friend"));
        contatinhos.add(new Contatinho(3,"Fred","064993-00000","My Friend"));
        contatinhos.add(new Contatinho(3,"Italo","064993-00000","My Friend"));
        contatinhos.add(new Contatinho(3,"Marcel","064993-00000","My Friend"));
        contatinhos.add(new Contatinho(3,"Pedro","064993-00000","My Friend"));
        contatinhos.add(new Contatinho(3,"Lucas","064993-00000","My Friend"));
        contatinhos.add(new Contatinho(3,"Maycon","064993-00000","My Friend"));
        ContatinhoAdapter adapter = new ContatinhoAdapter(contatinhos,this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layout  = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adicionar = findViewById(R.id.btnAddId);

        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent salvarContato = new Intent(MainActivity.this,CadastroActivity.class);
                startActivity(salvarContato);
            }
        });



    }
}
