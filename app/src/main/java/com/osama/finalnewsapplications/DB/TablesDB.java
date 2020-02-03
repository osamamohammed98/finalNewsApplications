package com.osama.finalnewsapplications.DB;

public class TablesDB  {

    public static  final  String DB__NAME = "News DATA bASE";
    public static  final  String DB__TABLE = "NEWS";
    public static  final  String DB__ID = "ID";
    public static  final  String DB__TITL = "TITLE";
    public static  final  String DB__BODY = "BODY";
    public static  final  String DB__IS_FAV = "IS_FAV";
    public static  final  String DB__IMAGE = "IMAGE";

   public static  final String Create_Statments_Tabel = "create table '"+DB__TABLE+"'( '"+DB__ID+"' integer primary key autoincrement ," +
           "'"+DB__TITL+"' text , '"+DB__BODY+"' text , '"+DB__IMAGE+"' blob , '"+DB__IS_FAV+"' text)";


   public static final String select_statment= "select * from '"+DB__TABLE+"'" ;
   public static final String select_statment_fav= "select * from '"+DB__TABLE+"' where IS_FAV =1" ;
}
