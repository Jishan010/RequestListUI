package com.mobility.myapplication.model;

import java.lang.System;

/**
 * Created By JISHAN ANSARI On 10/26/2019
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\t"}, d2 = {"Lcom/mobility/myapplication/model/NameDao;", "", "addName", "", "name", "Lcom/mobility/myapplication/model/Name;", "getNameList", "name_id", "", "app_debug"})
public abstract interface NameDao {
    
    @androidx.room.Insert()
    public abstract void addName(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Name name);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from name_table where name_id=:name_id")
    public abstract com.mobility.myapplication.model.Name getNameList(int name_id);
}