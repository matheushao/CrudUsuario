package usuario.app.crudusuario;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
    }

    public void voltar(View v){
        finish();
    }

    public void cadastrar(View v){

        EditText editNome = (EditText) findViewById(R.id.nome);
        EditText editSenha = (EditText) findViewById(R.id.senha);
        EditText editTelefone = (EditText) findViewById(R.id.telefone);
        EditText editCpf = (EditText) findViewById(R.id.cpf);
        EditText editEmail = (EditText) findViewById(R.id.email);

        String nome = editNome.getText().toString();
        String senha = editSenha.getText().toString();
        String telefone = editTelefone.getText().toString();
        String cpf = editCpf.getText().toString();
        String email = editEmail.getText().toString();

        Usuario usuario = new Usuario(nome, senha, cpf, telefone, email);

        UsuarioDAO daoUsuario = new UsuarioDAO(CadastrarUsuario.this);

        int cadastrar = daoUsuario.inserirUsuario(usuario);

        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        if(cadastrar == 1){
            String texto = "Cadastrado com sucesso";
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
            finish();
        }else{
            String texto = "Erro ao cadastrar";
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }
}
