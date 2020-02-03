package com.osama.finalnewsapplications.Model;

public class ModelItem  {
    int id ;
    int is_fav ;
    String body ;
    String title ;
    String image ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIs_fav() {
        return is_fav;
    }

    public void setIs_fav(int is_fav) {
        this.is_fav = is_fav;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ModelItem(int id, int is_fav, String body, String title, String image) {
        this.id = id;
        this.is_fav = is_fav;
        this.body = body;
        this.title = title;
        this.image = image;
    }

    public ModelItem( int is_fav, String body, String title, String image) {

        this.is_fav = is_fav;
        this.body = body;
        this.title = title;
        this.image = image;
    }


    public ModelItem(  String body, String title, String image) {


        this.body = body;
        this.title = title;
        this.image = image;
    }
}
