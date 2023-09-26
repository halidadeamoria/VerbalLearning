package com.example.articulationlearning.database;

import static com.example.articulationlearning.util.Constant.CUSTOMER_NAME;
import static com.example.articulationlearning.util.Constant.CUSTOMER_NUMBER;
import static com.example.articulationlearning.util.Constant.TABLE_CUSTOMER;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.example.articulationlearning.model.CustomerModel;

public class CustomerDatabaseHelper {
    private DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

    public void loginCustomer(String name,String customerNumber,  QueryResponse<CustomerModel> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        Cursor cursorDataLogin = null;

        try {

            cursorDataLogin = sqLiteDatabase.query(TABLE_CUSTOMER, null,
                    CUSTOMER_NAME + " =? ", new String[]{name},
                    null, null, null);

            if (cursorDataLogin != null && cursorDataLogin.moveToFirst()) {
                String customerName = cursorDataLogin.getString(1);
                int customerId = cursorDataLogin.getInt(0);
                String custNumber = cursorDataLogin.getString(2);
                CustomerModel customerModel=new CustomerModel();
                customerModel.setName(customerName);
                customerModel.setCustNumber(custNumber);
                response.onSuccess(customerModel, customerId);
            } else {
                signUpCustomer(name,customerNumber, new QueryResponse<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data, int idData) {
                        CustomerModel customerModel=new CustomerModel();
                        customerModel.setName(name);
                        customerModel.setCustNumber(customerNumber);
                        response.onSuccess(customerModel, idData);
                    }

                    @Override
                    public void onFailure(String message) {
                        response.onFailure(message);
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
            if (cursorDataLogin != null)
                cursorDataLogin.close();
        }
    }

    public void signUpCustomer(String name,String custNumber, QueryResponse<Boolean> response) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(CUSTOMER_NAME, name);
        contentValues.put(CUSTOMER_NUMBER, custNumber);

        try {
            long id = sqLiteDatabase.insertOrThrow(TABLE_CUSTOMER, null, contentValues);
            if (id > 0) {
                response.onSuccess(true, Integer.parseInt(String.valueOf(id)));
            } else {
                response.onFailure("Gagal melakukan pendaftaran");

            }
        } catch (SQLiteException e) {
            e.printStackTrace();
            Log.d("customer sign database ","==>> "+e.getMessage());
            response.onFailure(e.getMessage());
        } finally {
            sqLiteDatabase.close();
        }
    }
}
