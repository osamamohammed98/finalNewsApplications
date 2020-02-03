package com.osama.finalnewsapplications.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.osama.finalnewsapplications.Model.ModelItem;

import java.util.ArrayList;

public class ManuplationDB extends SQLiteOpenHelper {

    public ManuplationDB(Context context) {
        super(context, TablesDB.DB__NAME, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TablesDB.Create_Statments_Tabel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists '" + TablesDB.DB__TABLE + "'"); ىلالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالالا ىلاةةةةةةةةةةةةةةةةةةةةة
        onCreate(db);
    }


    public void AddData(ModelItem modelItem) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TablesDB.DB__TITL, modelItem.getTitle());
        values.put(TablesDB.DB__BODY, modelItem.getBody());
        values.put(TablesDB.DB__IMAGE, modelItem.getImage());
        values.put(TablesDB.DB__IS_FAV, String.valueOf(modelItem.getIs_fav()));
        database.insert(TablesDB.DB__TABLE, null, values);

    }

    public ArrayList<ModelItem> GetAllDataFromDataBase() {
        ArrayList<ModelItem> modelItems = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        ModelItem item = null;
        Cursor cursor = database.rawQuery(TablesDB.select_statment, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(TablesDB.DB__ID));
                String title = cursor.getString(cursor.getColumnIndex(TablesDB.DB__TITL));
                String body = cursor.getString(cursor.getColumnIndex(TablesDB.DB__BODY));
                String is_Fav = cursor.getString(cursor.getColumnIndex(TablesDB.DB__IS_FAV));
                String image = cursor.getString(cursor.getColumnIndex(TablesDB.DB__IMAGE));

                item = new ModelItem(id, Integer.parseInt(is_Fav), body, title, image);
                modelItems.add(item);

            } while (cursor.moveToNext());
        }
        return modelItems;
    }


    public void update(int id) {
        ModelItem modelItem = null;
////modelItem = "0";
//        String sql ="where IS_FAV=0";
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
////        values.put(TablesDB.DB__TITL, modelItem.getTitle());
////        values.put(TablesDB.DB__BODY, modelItem.getBody());
////        values.put(TablesDB.DB__IMAGE, modelItem.getImage());
//        values.put(TablesDB.DB__IS_FAV, String.valueOf("1"));
//        database.update(TablesDB.DB__TABLE , values ,sql,new String[]{String.valueOf(modelItem.getIs_fav())});
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update '" + TablesDB.DB__TABLE + "' set '" + TablesDB.DB__IS_FAV + "'=1 where ID='" + id + "'");
    }

    public void updatezero(int id) {
        ModelItem modelItem = null;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update '" + TablesDB.DB__TABLE + "' set '" + TablesDB.DB__IS_FAV + "'=0 where ID='" + id + "'");
    }


    public ArrayList<ModelItem> GetAllDataFromDataBaseByFav() {
        ArrayList<ModelItem> modelItems = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        ModelItem item = null;
        Cursor cursor = database.rawQuery(TablesDB.select_statment_fav, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(TablesDB.DB__ID));
                String title = cursor.getString(cursor.getColumnIndex(TablesDB.DB__TITL));
                String body = cursor.getString(cursor.getColumnIndex(TablesDB.DB__BODY));
                String is_Fav = cursor.getString(cursor.getColumnIndex(TablesDB.DB__IS_FAV));
                String image = cursor.getString(cursor.getColumnIndex(TablesDB.DB__IMAGE));

                item = new ModelItem(id, Integer.parseInt(is_Fav), body, title, image);
                modelItems.add(item);

            } while (cursor.moveToNext());
        }
        return modelItems;
    }


    public ModelItem GetAllDataFromDataBaseByID(int id) {

        SQLiteDatabase database = this.getReadableDatabase();
        ModelItem item = null;
        String select_statment_ID= "select * from '"+TablesDB.DB__TABLE+"' where ID='"+id+"'" ;
        Cursor cursor = database.rawQuery(select_statment_ID, null);

        if (cursor.moveToFirst()) {

            int ids = cursor.getInt(cursor.getColumnIndex(TablesDB.DB__ID));
            String title = cursor.getString(cursor.getColumnIndex(TablesDB.DB__TITL));
            String body = cursor.getString(cursor.getColumnIndex(TablesDB.DB__BODY));
            String is_Fav = cursor.getString(cursor.getColumnIndex(TablesDB.DB__IS_FAV));
            String image = cursor.getString(cursor.getColumnIndex(TablesDB.DB__IMAGE));

            item = new ModelItem(ids, Integer.parseInt(is_Fav), body, title, image);
            // modelItems.add(item);
            return item;
        }
        return null;
    }


}
