/*
 *
 *  Created by Sergey Stepchenkov on 02.10.20 17:10
 *  Copyright (c) 2020. All rights reserved.
 *  More info on www.bootcode.ru
 *  Last modified 02.10.20 17:10
 *
 */

package ru.bootcode.crdiet.di;

import android.app.Application;

import androidx.room.Room;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import ru.bootcode.crdiet.database.CRDatabase;


@Module
public class DatabaseModule {
    private CRDatabase crDatabase;

    // Создаем БД, прописывает тут же миграции (обновления базы данных)
    // Для каждого обновления БД свое имя MIGRATION_1_2, MIGRATION_2_3
    // Порядок обновления прописан в основном классе CRDatabase
    // Более подробно как действуют правила можно увидеть там же
    public DatabaseModule(Application mApplication) {
        // allowMainThreadQueries - затычка, необходимо переделать на RX
        crDatabase = Room.databaseBuilder(mApplication, CRDatabase.class, "cr_db")
                .addMigrations(CRDatabase.MIGRATION_1_2)
                .allowMainThreadQueries().build();
    }

    // Опять же тут все стандартно для дагера, можно смотреть документацию к нему
    // В модуле БД будет только один провайдер, укажем что CRDatabase будет единственным
    @Singleton
    @Provides
    CRDatabase provideCRDatabase() {
        return crDatabase;
    }



}
