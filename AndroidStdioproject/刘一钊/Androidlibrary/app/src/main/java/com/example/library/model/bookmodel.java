package com.example.library.model;

import android.os.Parcel;
import android.os.Parcelable;
//book的数据库中对应的模型

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class bookmodel implements Parcelable{
    @Id(autoincrement = true)
    private Long id;
    private String ISBN;
    private String name;
    private String author;
    private String price;
    private String press;
    private String score;
    private String date;
    private String page;
    private String content_description;
    private String link;
    @Generated(hash = 552197769)
    public bookmodel(Long id, String ISBN, String name, String author, String price,
            String press, String score, String date, String page,
            String content_description, String link) {
        this.id = id;
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.price = price;
        this.press = press;
        this.score = score;
        this.date = date;
        this.page = page;
        this.content_description = content_description;
        this.link = link;
    }
    @Generated(hash = 158598002)
    public bookmodel() {
    }



    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getISBN() {
        return this.ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPress() {
        return this.press;
    }
    public void setPress(String press) {
        this.press = press;
    }
    public String getScore() {
        return this.score;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPage() {
        return this.page;
    }
    public void setPage(String page) {
        this.page = page;
    }
    public String getContent_description() {
        return this.content_description;
    }
    public void setContent_description(String content_description) {
        this.content_description = content_description;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public bookmodel(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        name = in.readString();
        ISBN = in.readString();
        author= in.readString();
        press = in.readString();
        price= in.readString();
        page= in.readString();
        score= in.readString();
        content_description= in.readString();
        date= in.readString();
        link= in.readString();

    }
    public static final Creator<bookmodel> CREATOR = new Creator<bookmodel>() {
        @Override
        public bookmodel createFromParcel(Parcel in) {
            return new bookmodel(in);
        }

        @Override
        public bookmodel[] newArray(int size) {
            return new bookmodel[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }

        dest.writeString(name);
        dest.writeString(ISBN);
        dest.writeString(author);
        dest.writeString(press);
        dest.writeString(price);
        dest.writeString(page);
        dest.writeString(score);
        dest.writeString(content_description);
        dest.writeString(date);
        dest.writeString(link);

    }
}
