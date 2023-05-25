package com.example.bangunan.Domain;

public class AlatDomain {
    private String title;
    private String pic;
    private String description;
    private int numberInCart;

    public AlatDomain(String title, String pic, String description) {
        this.title = title;
        this.pic = pic;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
