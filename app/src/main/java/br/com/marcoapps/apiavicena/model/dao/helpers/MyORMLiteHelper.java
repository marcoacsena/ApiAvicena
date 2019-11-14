package br.com.marcoapps.apiavicena.model.dao.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.marcoapps.apiavicena.model.vo.Consulta;
import br.com.marcoapps.apiavicena.model.vo.Medico;
import br.com.marcoapps.apiavicena.model.vo.Paciente;

public class MyORMLiteHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "avicena";
    private static final int DATABASE_VERSION = 17;

    public MyORMLiteHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Paciente.class);
            TableUtils.createTable(connectionSource, Consulta.class);
            TableUtils.createTable(connectionSource, Medico.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

        try {
            TableUtils.dropTable(connectionSource, Paciente.class, true);
            TableUtils.dropTable(connectionSource, Consulta.class, true);
            TableUtils.dropTable(connectionSource, Medico.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
