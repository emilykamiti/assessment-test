package com.resale.app.model.entity;

import java.io.Serializable;
import java.util.List;
import com.resale.app.view.html.ResaleHtmlForm;
import com.resale.app.view.html.ResaleHtmlFormField;
import com.resale.app.view.html.ResaleTableColHeader;

@ResaleHtmlForm(label = "Item", url = "./item")
public class Item implements Serializable {

    @ResaleTableColHeader(header = "Name")
    @ResaleHtmlFormField(label = "item-name")
    private String name;

    @ResaleTableColHeader(header = "Type")
    @ResaleHtmlFormField(label = "item-type")
    private String type;

    @ResaleTableColHeader(header = "Price")
    @ResaleHtmlFormField(label = "item-price")
    private double price;
    

    @ResaleTableColHeader(header = "Image")
    @ResaleHtmlFormField(label = "item-image")
    private String imageURL;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Item(String name, String type, double price, String imageURL) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.imageURL = imageURL;
    }

    // public String tableRow() {
    // StringBuilder trBuilder = new StringBuilder();
    // trBuilder.append("<tr>");
    // trBuilder.append("<td class='item-price'>").append(String.format("%.2f",
    // getPrice())).append("</td>");
    // trBuilder.append("<td class='item-image'><img src='").append(getImageURL()).append("' alt='Item Image'></td>");
    // trBuilder.append("<td class='item-bid'><a href='./bidaction'>Bid</a></td>");
    // trBuilder.append("</tr>");
    // return trBuilder.toString();
    // }

    public void placeBid(Bid newBid) {
    }

    public List<Bid> getBids() {
        return null;
    }

}
