package com.mobility.myapplication.model;

import java.lang.System;

/**
 * Created By J7202687 On 10/22/2019
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/mobility/myapplication/model/UserRepository;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "userDatabase", "Lcom/mobility/myapplication/model/UserDatabase;", "userList", "Landroidx/lifecycle/LiveData;", "", "Lcom/mobility/myapplication/model/Results;", "users", "getUsers", "()Landroidx/lifecycle/LiveData;", "getUserName", "Lcom/mobility/myapplication/model/Name;", "id", "", "insertUser", "", "results", "Companion", "InsertAsyncTask", "app_debug"})
public final class UserRepository {
    private com.mobility.myapplication.model.UserDatabase userDatabase;
    private androidx.lifecycle.LiveData<java.util.List<com.mobility.myapplication.model.Results>> userList;
    @org.jetbrains.annotations.Nullable()
    private static com.mobility.myapplication.model.ResultDao userDao;
    @org.jetbrains.annotations.Nullable()
    private static com.mobility.myapplication.model.NameDao nameDao;
    public static final com.mobility.myapplication.model.UserRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.mobility.myapplication.model.Results>> getUsers() {
        return null;
    }
    
    public final void insertUser(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Results results) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mobility.myapplication.model.Name getUserName(int id) {
        return null;
    }
    
    public UserRepository(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/mobility/myapplication/model/UserRepository$InsertAsyncTask;", "Landroid/os/AsyncTask;", "Lcom/mobility/myapplication/model/Results;", "Ljava/lang/Void;", "()V", "doInBackground", "results", "", "([Lcom/mobility/myapplication/model/Results;)Ljava/lang/Void;", "app_debug"})
    public static final class InsertAsyncTask extends android.os.AsyncTask<com.mobility.myapplication.model.Results, java.lang.Void, java.lang.Void> {
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
        com.mobility.myapplication.model.Results... results) {
            return null;
        }
        
        public InsertAsyncTask() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/mobility/myapplication/model/UserRepository$Companion;", "", "()V", "nameDao", "Lcom/mobility/myapplication/model/NameDao;", "getNameDao", "()Lcom/mobility/myapplication/model/NameDao;", "setNameDao", "(Lcom/mobility/myapplication/model/NameDao;)V", "userDao", "Lcom/mobility/myapplication/model/ResultDao;", "getUserDao", "()Lcom/mobility/myapplication/model/ResultDao;", "setUserDao", "(Lcom/mobility/myapplication/model/ResultDao;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.mobility.myapplication.model.ResultDao getUserDao() {
            return null;
        }
        
        public final void setUserDao(@org.jetbrains.annotations.Nullable()
        com.mobility.myapplication.model.ResultDao p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.mobility.myapplication.model.NameDao getNameDao() {
            return null;
        }
        
        public final void setNameDao(@org.jetbrains.annotations.Nullable()
        com.mobility.myapplication.model.NameDao p0) {
        }
        
        private Companion() {
            super();
        }
    }
}