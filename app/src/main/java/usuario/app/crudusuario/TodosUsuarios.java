package usuario.app.crudusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TodosUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_usuarios);

        UsuarioDAO daoUsuario = new UsuarioDAO(TodosUsuarios.this);

        ArrayList<Usuario> listUser = (ArrayList<Usuario>) daoUsuario.listaUsuarios();

        ArrayList<String> nomeUsuarios = new ArrayList<String>();

        for (Usuario usuario : listUser) {
            nomeUsuarios.add("ID: " + usuario.getId() + "\nUsuário: " + usuario.getNome() + "\nTelefone: "+ usuario.getTelefone() + "\nCPF: " + usuario.getCpf() + "\nEmail: " + usuario.getEmail());
        }



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nomeUsuarios);

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);

    }

    public void voltar(View v){
        Intent it = new Intent(TodosUsuarios.this, MainActivity.class);
        startActivity(it);
        finish();
    }
}

