package contatinhos.example.higor.contatinhos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private Button salvar;
    private Button cancealr;
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoInfo;
    Contatinho contato;
    ContatinhoDAO dao = new ContatinhoDAO(CadastroActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        salvar = findViewById(R.id.btnSalvarId);
        cancealr = findViewById(R.id.btnCancelarId);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                campoNome = findViewById(R.id.editNomeId);
                campoTelefone = findViewById(R.id.editTelefoneId);
                campoInfo  = findViewById(R.id.editTextInfoId);

                String campoNomeString = campoNome.getText().toString();
                String campoTelefoneString = campoTelefone.getText().toString();
                String campoInfoString = campoInfo.getText().toString();
                contato = new Contatinho(campoNomeString,campoTelefoneString,campoInfoString);
//             Contatinho c = new Contatinho(1,"xxxxxxxxx","064993-00000","My best Friend");
                dao.inserirContatinho(contato);


                Intent voltarInicio = new Intent(CadastroActivity.this,MainActivity.class);
                startActivity(voltarInicio);

            }
        });


        cancealr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltarInicio = new Intent(CadastroActivity.this,MainActivity.class);
                startActivity(voltarInicio);
            }
        });
    }
}
