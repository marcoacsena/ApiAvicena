package br.com.marcoapps.apiavicena.model.dao.helpers;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class DaoHelper <T> {

    protected Class className;
    public static MyORMLiteHelper mInstance = null;

    public DaoHelper(Context c, Class className) {
        this.className = className;

        if (mInstance == null) { //mInstance é singleton - faz com que a conexão seja chamada apenas 1 vez
            mInstance = new MyORMLiteHelper(c.getApplicationContext());
        }
    }

    public Dao<T, Integer> getDao() {
        try {
            return mInstance.getDao(className);
        } catch (SQLException e) {
            return null;
        }
    }

}
