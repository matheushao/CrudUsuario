package usuario.app.crudusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cadastrarUsuario(View v){
        Intent it = new Intent(MainActivity.this, CadastrarUsuario.class);
        startActivity(it);
    }
    public void todosUsuarios(View v){
        Intent it = new Intent(MainActivity.this, TodosUsuarios.class);
        startActivity(it);
    }
}
