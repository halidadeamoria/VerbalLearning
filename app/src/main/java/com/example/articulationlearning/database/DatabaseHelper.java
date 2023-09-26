package com.example.articulationlearning.database;

import static com.example.articulationlearning.util.Constant.CUSTOMER_ID;
import static com.example.articulationlearning.util.Constant.CUSTOMER_NAME;
import static com.example.articulationlearning.util.Constant.CUSTOMER_NUMBER;
import static com.example.articulationlearning.util.Constant.TABLE_CUSTOMER;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.articulationlearning.util.MyApp;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "learning-db";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper databaseHelper;

    private DatabaseHelper() {
        super(MyApp.context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance() {

        if (databaseHelper == null) {
            synchronized (DatabaseHelper.class) { //thread safe singleton
                if (databaseHelper == null)
                    databaseHelper = new DatabaseHelper();
            }
        }

        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + TABLE_CUSTOMER + "("
                + CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CUSTOMER_NAME + " TEXT NOT NULL, "
                + CUSTOMER_NUMBER + " TEXT NOT NULL "
                + ")";


        sqLiteDatabase.execSQL(CREATE_CUSTOMER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);

        //enable foreign key constraints like ON UPDATE CASCADE, ON DELETE CASCADE
        db.execSQL("PRAGMA foreign_keys=ON;");
    }
}
