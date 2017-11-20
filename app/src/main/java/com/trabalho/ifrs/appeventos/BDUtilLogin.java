package com.trabalho.ifrs.appeventos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtilLogin extends SQLiteOpenHelper {
    //BDNAME
    private static final String BASE_DE_DADOS = "EVENTOS";
    //TABLE NAME
    private static final String TABLE_USERS = "USERS";
    private static final String Column_User_name = "USERNAME";
    private static final String Column_User_id = "_ID";
    private static final String Column_User_password = "USERPASSWORD";
    private static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_USERS
            + " ( "
            + "_ID  INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Column_User_name+" TEXT NOT NULL, "
            + Column_User_password +" TEXT NOT NULL"
            + " ) ";

    private static final int VERSAO = 1;

    public BDUtilLogin(Context context) {
        super(context, BASE_DE_DADOS, null, VERSAO);
    }
    //Cria a base de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
    //Adiciona usuario
    public Long addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Column_User_name, user.getNome());
        values.put(Column_User_password, user.getSenha());

        return db.insert(TABLE_USERS, null, values);
    }

    public User Auth(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{Column_User_id, Column_User_name, Column_User_password},
                Column_User_name+ "=?",
                new String[]{user.getNome()},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            User user1 = new User(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
            if (user.getSenha().equalsIgnoreCase(user1.getSenha())) {
                return user1;
            }
        }
        return null;
    }

    public Boolean ifExistUser(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{Column_User_id, Column_User_name, Column_User_password},
                Column_User_name+ "=?",
                new String[]{user.getNome()},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()&& cursor.getCount()>0) {
            return true;
        }

        //if email does not exist return false
        return false;
    }


}
