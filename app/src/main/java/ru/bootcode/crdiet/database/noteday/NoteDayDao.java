/*
 *
 *  Created by Sergey Stepchenkov on 16.10.20 13:23
 *  Copyright (c) 2020. All rights reserved.
 *  More info on www.bootcode.ru
 *  Last modified 09.10.20 13:20
 *
 */

package ru.bootcode.crdiet.database.noteday;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;


@Dao
public interface NoteDayDao {
    // Запрос всех записей из базы данных с сортировкой по дате (новые записи - первые)
    // возвращает Flowable - изменяемый, тоесть при внесении данных запрос будет выполнен автоматом
    // в том же потоке где он выполнялся ранее
    @Query("SELECT * FROM EatTime ORDER BY date DESC")
    Flowable<List<NoteDay>> getAll();

    // Запрос 10 последних записей из базы данных с сортировкой по дате (новые записи - первые)
    // возвращает Flowable - изменяемый, тоесть при внесении данных запрос будет выполнен автоматом
    // в том же потоке где он выполнялся ранее
    @Query("SELECT * FROM EatTime  ORDER BY date DESC LIMIT 10")
    Flowable<List<NoteDay>> get10();

    // Запрос записи из базы данных по идентификатору возвращает Flowable - изменяемый,
    // тоесть при внесении данных запрос будет выполнен автоматом
    // в том же потоке где он выполнялся ранее
    @Query("SELECT * FROM EatTime WHERE id = :id")
    Flowable<NoteDay> getById(String id);

    @Insert
    void insert(NoteDay noteWeek);

    @Update
    void update(NoteDay noteWeek);

    @Delete
    void delete(NoteDay noteWeek);
}




