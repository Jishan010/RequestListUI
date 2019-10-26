package com.mobility.myapplication.viewmodel;

import java.lang.System;

/**
 * Created By J7202687 On 10/22/2019
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/mobility/myapplication/viewmodel/UserViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "userList", "Landroidx/lifecycle/LiveData;", "", "Lcom/mobility/myapplication/model/ResultNameData;", "userName", "Lcom/mobility/myapplication/model/Name;", "userRepository", "Lcom/mobility/myapplication/model/UserRepository;", "getUserList", "getUserName", "id", "", "insertUser", "", "result", "Lcom/mobility/myapplication/model/Results;", "app_debug"})
public class UserViewModel extends androidx.lifecycle.AndroidViewModel {
    private com.mobility.myapplication.model.UserRepository userRepository;
    private androidx.lifecycle.LiveData<java.util.List<com.mobility.myapplication.model.ResultNameData>> userList;
    private com.mobility.myapplication.model.Name userName;
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<java.util.List<com.mobility.myapplication.model.ResultNameData>> getUserList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.mobility.myapplication.model.Name getUserName(int id) {
        return null;
    }
    
    public final void insertUser(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Results result) {
    }
    
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}