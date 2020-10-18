/*
 *
 *  Created by Sergey Stepchenkov on 16.10.20 13:47
 *  Copyright (c) 2020. All rights reserved.
 *  More info on www.bootcode.ru
 *  Last modified 16.10.20 13:38
 *
 */

package ru.bootcode.crdiet.database.noteday;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;
import java.util.UUID;

import ru.bootcode.crdiet.database.DataConverter;

@Entity
public class NoteDay {

    @NonNull
    @PrimaryKey
    private  String id;                           // Уникальный идентификатор записи UUID
    private  int number;                          // Порядковый номер недели
    @TypeConverters({DataConverter.class})
    private  Date date;                           // Датаи время записи(в БД как long)
    private  int weektype_id;                     // Ссылка на TYPE (тип недели)
    private  String comment;                      // Наименование записи
    private  boolean delete;                      // Истина если уалена
    private  int weigth;                          // Вес - результат (храниться как Х*1000)

    public NoteDay(@NonNull String id, int number, Date date, int weektype_id, String comment, boolean delete, int weigth) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.weektype_id = weektype_id;
        this.comment = comment;
        this.delete = delete;
        this.weigth = weigth;
    }
    @Ignore
    public NoteDay(int number, Date date, int weektype_id, String comment, boolean delete, int weigth) {
        // Аннотация Ignore позволяет подсказать Room, что не должно использоваться в
        // в данном случае данный конструктор будет игнорирован, так как у нас есть еще один выше
        this.id      = UUID.randomUUID().toString();
        this.number = number;
        this.date = date;
        this.weektype_id = weektype_id;
        this.comment = comment;
        this.delete = delete;
        this.weigth = weigth;
    }

    // переопределенная функция для возможности сравнения, используем для тестирования
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NoteDay tmp = (NoteDay) o;

        // Проверки на содержание сделаны от простейших к более сложным,
        // а следователь более ресурсным (это не принципиально, мне так удобнее и нагляднее)
        if (this.number != tmp.number || this.id != tmp.id || this.weigth != tmp.weigth ||
                this.weektype_id != tmp.weektype_id || this.delete != tmp.delete ) {
            return false;
        }

        if (!this.date.equals(tmp.date)) {
            return false;
        }

        return ( this.comment.equals(tmp.comment) /*&& this.name.equals(tmp.name)*/);
    }

    // Далее геттеры и Сеттеры-----------------------------------------------------

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWeektype_id() {
        return weektype_id;
    }

    public void setWeektype_id(int weektype_id) {
        this.weektype_id = weektype_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }


    //-----------------------------------------------------------------------------
}
