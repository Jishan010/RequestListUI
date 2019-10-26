package com.mobility.myapplication.model;

import java.lang.System;

/**
 * Created By JISHAN ANSARI On 10/25/2019
 */
@androidx.room.Entity(tableName = "result_table")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J[\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u00020\u0003H\u00d6\u0001J\t\u00106\u001a\u00020\u0005H\u00d6\u0001R \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u00067"}, d2 = {"Lcom/mobility/myapplication/model/Results;", "", "result_id", "", "gender", "", "name", "Lcom/mobility/myapplication/model/Name;", "location", "Lcom/mobility/myapplication/model/Location;", "dob", "Lcom/mobility/myapplication/model/Dob;", "picture", "Lcom/mobility/myapplication/model/Picture;", "email", "(ILjava/lang/String;Lcom/mobility/myapplication/model/Name;Lcom/mobility/myapplication/model/Location;Lcom/mobility/myapplication/model/Dob;Lcom/mobility/myapplication/model/Picture;Ljava/lang/String;)V", "getDob", "()Lcom/mobility/myapplication/model/Dob;", "setDob", "(Lcom/mobility/myapplication/model/Dob;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getGender", "setGender", "getLocation", "()Lcom/mobility/myapplication/model/Location;", "setLocation", "(Lcom/mobility/myapplication/model/Location;)V", "getName", "()Lcom/mobility/myapplication/model/Name;", "setName", "(Lcom/mobility/myapplication/model/Name;)V", "getPicture", "()Lcom/mobility/myapplication/model/Picture;", "setPicture", "(Lcom/mobility/myapplication/model/Picture;)V", "getResult_id", "()I", "setResult_id", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Results {
    @androidx.room.ColumnInfo(name = "result_id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int result_id;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "gender")
    private java.lang.String gender;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Ignore()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "name")
    private com.mobility.myapplication.model.Name name;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Ignore()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "location")
    private com.mobility.myapplication.model.Location location;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Ignore()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "dob")
    private com.mobility.myapplication.model.Dob dob;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Ignore()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "picture")
    private com.mobility.myapplication.model.Picture picture;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "email")
    private java.lang.String email;
    
    public final int getResult_id() {
        return 0;
    }
    
    public final void setResult_id(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Name getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Name p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Location getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Location p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Dob getDob() {
        return null;
    }
    
    public final void setDob(@org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Dob p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Picture getPicture() {
        return null;
    }
    
    public final void setPicture(@org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Picture p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public Results(int result_id, @org.jetbrains.annotations.Nullable()
    java.lang.String gender, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Name name, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Location location, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Dob dob, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Picture picture, @org.jetbrains.annotations.Nullable()
    java.lang.String email) {
        super();
    }
    
    public Results() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Name component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Location component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Dob component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mobility.myapplication.model.Picture component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    /**
     * Created By JISHAN ANSARI On 10/25/2019
     */
    @org.jetbrains.annotations.NotNull()
    public final com.mobility.myapplication.model.Results copy(int result_id, @org.jetbrains.annotations.Nullable()
    java.lang.String gender, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Name name, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Location location, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Dob dob, @org.jetbrains.annotations.Nullable()
    com.mobility.myapplication.model.Picture picture, @org.jetbrains.annotations.Nullable()
    java.lang.String email) {
        return null;
    }
    
    /**
     * Created By JISHAN ANSARI On 10/25/2019
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Created By JISHAN ANSARI On 10/25/2019
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Created By JISHAN ANSARI On 10/25/2019
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}