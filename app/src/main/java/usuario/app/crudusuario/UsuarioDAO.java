package usuario.app.crudusuario;

/**
 * Created by Matheus Alves on 08/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private OpenDB conexao;

    public UsuarioDAO(Context ctx) {

        this.conexao = new OpenDB(ctx);
    }

    public int inserirUsuario(Usuario usuario){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues data = new ContentValues();
            data.put("nome", usuario.getNome());
            data.put("senha", usuario.getSenha());
            data.put("cpf", usuario.getCpf());
            data.put("telefone", usuario.getTelefone());
            data.put("email", usuario.getEmail());

            db.insert("usuarios", null, data);
            db.close();

            return 1;
        }catch (Exception e){
            return 0;
        }
    }


    public List<Usuario> listaUsuarios(){
        SQLiteDatabase db = conexao.getReadableDatabase();
        Cursor cursor = db.query("usuarios", new String[]{}, null, null, null, null, null);

        String nome, senha, cpf, telefone, email;
        int id;

        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {

            id = cursor.getInt(cursor.getColumnIndex("id"));
            nome = cursor.getString(cursor.getColumnIndex("nome"));
            senha = cursor.getString(cursor.getColumnIndex("senha"));
            cpf = cursor.getString(cursor.getColumnIndex("cpf"));
            telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            email = cursor.getString(cursor.getColumnIndex("email"));

            Usuario usuario = new Usuario(id, nome, senha, cpf, telefone, email);

            listaUsuario.add(usuario);

        }

        db.close();

        return listaUsuario;

    }

    public Usuario usuarioPorNome(String name){
        SQLiteDatabase db = conexao.getReadableDatabase();
        String whereClause = "nome = ?";
        String[] whereArgs = new String[] {name};
        Cursor cursor = db.query("usuarios", new String[]{}, whereClause, whereArgs, null, null, null);
        String nome, senha, cpf, telefone, email;
        int id;
        Usuario usuario = null;
        try {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                senha = cursor.getString(cursor.getColumnIndex("senha"));
                cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                email = cursor.getString(cursor.getColumnIndex("email"));

                usuario = new Usuario(id, nome, senha, cpf, telefone, email);
                db.close();
                return usuario;
            }
        }catch (Exception e ){

        }
        return usuario;

    }

    public int alterarUsuario(int idUsuario, String newNome, String newSenha){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues data = new ContentValues();

            data.put("nome", newNome);
            data.put("senha", newSenha);

            db.update("usuarios", data, "id=?", new String[]{String.valueOf(idUsuario)});
            db.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    public int deletarUsuario(int idUsuario){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            db.delete("usuarios", "id=?", new String[]{String.valueOf(idUsuario)});
            db.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

}
