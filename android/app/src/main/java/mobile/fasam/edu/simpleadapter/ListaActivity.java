package mobile.fasam.edu.simpleadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtTelefone;
    ListView listView;

    List<HashMap<String,String>> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
    }

    public void enviar(View view) {


        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);


        String nome,email,telefone, sobrenome;


        nome = txtNome.getText().toString();
        sobrenome = txtSobrenome.getText().toString();
        email = txtEmail.getText().toString();
        telefone = txtTelefone.getText().toString();



        String dados = String
                .format("Os dados digitados foram %s %s %s %s",
                        nome,sobrenome,email, telefone);



        HashMap<String,String> map = new HashMap<>();
        map.put("nome",nome);
        map.put("sobrenome",sobrenome);
        map.put("email",email);
        map.put("telefone",telefone);

        lista.add(map);


        String[] de = {"nome","sobrenome", "email", "telefone"}; //dados do Map

        //id's do layout item.xml
        int[] para = {R.id.labelNome,R.id.labelSobrenome,R.id.labelEmail,R.id.labelTelefone};


        SimpleAdapter adapter = new SimpleAdapter(
                getApplicationContext(),
                lista,
                R.layout.item,
                de,
                para
        );


        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);


    }
}
