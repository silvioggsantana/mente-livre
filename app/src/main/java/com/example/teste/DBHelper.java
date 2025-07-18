package com.example.teste;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "mente_livre.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "email TEXT UNIQUE, " +
                "senha TEXT," +
                "datanascimento TEXT)");

        db.execSQL("CREATE TABLE anotacao (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT, " +
                "conteudo TEXT, " +
                "data TEXT, " +
                "id_usuario INTEGER, " +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS anotacao");
        db.execSQL("DROP TABLE IF EXISTS usuario");
        onCreate(db);
    }

    // Inserir usuário
    public boolean inserirUsuario(String nome, String email, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("email", email);
        cv.put("senha", senha);
        long res = db.insert("usuario", null, cv);
        return res != -1;
    }

    // Verificar login
    public int validarLogin(String email, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT id FROM usuario WHERE email = ? AND senha = ?", new String[]{email, senha});
        if (c.moveToFirst()) {
            @SuppressLint("Range") int id = c.getInt(c.getColumnIndex("id"));
            c.close();
            return id;
        } else {
            c.close();
            return -1; // login inválido
        }
    }


    // Inserir anotação
    public boolean inserirAnotacao(String titulo, String conteudo, String data, int idUsuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("titulo", titulo);
        cv.put("conteudo", conteudo);
        cv.put("data", data);
        cv.put("id_usuario", idUsuario);
        long res = db.insert("anotacao", null, cv);
        return res != -1;
    }

    // Listar anotações por usuário
    public Cursor listarAnotacoes(int idUsuario) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM anotacao WHERE id_usuario = ?", new String[]{String.valueOf(idUsuario)});
    }

    // Recupera usuário pelo ID
    public Cursor getUsuarioPorId(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM usuario WHERE id = ?", new String[]{String.valueOf(id)});
    }

    // Atualiza nome e senha do usuário
    public boolean atualizarUsuario(int id, String nome, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nome", nome);
        cv.put("senha", senha);
        int result = db.update("usuario", cv, "id = ?", new String[]{String.valueOf(id)});
        return result > 0;
    }

}
