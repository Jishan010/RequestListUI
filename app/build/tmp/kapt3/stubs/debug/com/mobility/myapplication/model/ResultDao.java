package com.mobility.myapplication.model;

import java.lang.System;

/**
 * Created By JISHAN ANSARI On 10/26/2019
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00170\u0016H\'J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00170\u0016H\'\u00a8\u0006\u001a"}, d2 = {"Lcom/mobility/myapplication/model/ResultDao;", "", "addDob", "", "dob", "Lcom/mobility/myapplication/model/Dob;", "addLocation", "location", "Lcom/mobility/myapplication/model/Location;", "addName", "name", "Lcom/mobility/myapplication/model/Name;", "addPicture", "picture", "Lcom/mobility/myapplication/model/Picture;", "addResult", "results", "Lcom/mobility/myapplication/model/Results;", "getNameList", "name_id", "", "getResultLists", "Landroidx/lifecycle/LiveData;", "", "getResultNameDataList", "Lcom/mobility/myapplication/model/ResultNameData;", "app_debug"})
public abstract interface ResultDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from result_table")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mobility.myapplication.model.Results>> getResultLists();
    
    @androidx.room.Insert()
    public abstract void addResult(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Results results);
    
    @androidx.room.Insert()
    public abstract void addLocation(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Location location);
    
    @androidx.room.Insert()
    public abstract void addName(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Name name);
    
    @androidx.room.Insert()
    public abstract void addPicture(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Picture picture);
    
    @androidx.room.Insert()
    public abstract void addDob(@org.jetbrains.annotations.NotNull()
    com.mobility.myapplication.model.Dob dob);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from name_table where name_id=:name_id")
    public abstract com.mobility.myapplication.model.Name getNameList(int name_id);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select result_table.email , result_table.gender  ,name_table.title ,name_table.first,name_table.last,location_table.city,location_table.state,location_table.country ,dob_table.age,picture_table.thumbnail from result_table INNER JOIN name_table ON result_table.result_id=name_table.name_id INNER JOIN location_table ON   result_table.result_id=location_table.location_id  INNER JOIN dob_table ON result_table.result_id=dob_table.dob_id  INNER JOIN picture_table ON result_table.result_id=picture_table.picture_id ")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.mobility.myapplication.model.ResultNameData>> getResultNameDataList();
}