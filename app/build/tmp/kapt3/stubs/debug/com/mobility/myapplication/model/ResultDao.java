package com.mobility.myapplication.model;

import java.lang.System;

/**
 * Created By JISHAN ANSARI On 10/26/2019
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'\u00a8\u0006\t"}, d2 = {"Lcom/mobility/myapplication/model/ResultDao;", "", "addResult", "", "results", "Lcom/mobility/myapplication/model/Results;", "getResultLists", "Landroidx/lifecycle/LiveData;", "", "app_debug"})
public abstract interface ResultDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from result_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mobility.myapplication.model.Results>> getResultLists();
    
    @androidx.room.Insert()
    public abstract void addResult(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Results results);
}