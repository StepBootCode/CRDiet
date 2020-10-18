/*
 *
 *  Created by Sergey Stepchenkov on 16.10.20 13:18
 *  Copyright (c) 2020. All rights reserved.
 *  More info on www.bootcode.ru
 *  Last modified 16.10.20 13:16
 *
 */

package ru.bootcode.crdiet.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import ru.bootcode.crdiet.database.noteweek.NoteWeek;
import ru.bootcode.crdiet.database.noteweek.NoteWeekDao;


@Database(entities = {NoteWeek.class}, version = CRDatabase.VERSION)
public abstract class CRDatabase extends RoomDatabase {

    // Версия базы данных, при изменении версии необходимо настроить миграцию
    static final int VERSION = 1;

    // Область для перечисления наших DAO интерфейсо-----------------------------------
    public abstract NoteWeekDao noteWeekDao();

    //---------------------------------------------------------------------------------

    // Правила для настройки миграции:
    // указывать начальную и предыдущю версию миграции (MIGRATION_1_2 - обновление сверсии 1 на 2)
    // последовательность миграции 1 -> 2, 2->3, 3->4  и т.д. если пользователь будет обновляться
    // с версии 1 на 4 то все миграции будут выполнены последовательно
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE NoteWeek ADD COLUMN color INTEGER DEFAULT -1 NOT NULL");
        }
    };
}
