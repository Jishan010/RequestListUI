package com.mobility.myapplication.model;

import java.lang.System;

/**
 * Created By J7202687 On 10/22/2019
 */
@androidx.room.Database(entities = {com.mobility.myapplication.model.Results.class, com.mobility.myapplication.model.Name.class, com.mobility.myapplication.model.Location.class, com.mobility.myapplication.model.Dob.class, com.mobility.myapplication.model.Picture.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/mobility/myapplication/model/UserDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cleanUp", "", "getResultDao", "Lcom/mobility/myapplication/model/ResultDao;", "Companion", "app_debug"})
public abstract class UserDatabase extends androidx.room.RoomDatabase {
    private static com.mobility.myapplication.model.UserDatabase userDataBaseInstance;
    private static final androidx.room.RoomDatabase.Callback roomCallback = null;
    public static final com.mobility.myapplication.model.UserDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.mobility.myapplication.model.ResultDao getResultDao();
    
    public final void cleanUp() {
    }
    
    public UserDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/mobility/myapplication/model/UserDatabase$Companion;", "", "()V", "roomCallback", "Landroidx/room/RoomDatabase$Callback;", "userDataBaseInstance", "Lcom/mobility/myapplication/model/UserDatabase;", "getInstance", "context", "Landroid/content/Context;", "getUserList", "", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.mobility.myapplication.model.UserDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final void getUserList(com.mobility.myapplication.model.UserDatabase userDataBaseInstance) {
        }
        
        private Companion() {
            super();
        }
    }
}