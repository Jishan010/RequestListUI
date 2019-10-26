package com.mobility.myapplication.network;

import java.lang.System;

/**
 * Created By J7202687 On 10/22/2019
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/mobility/myapplication/network/ServiceInterface;", "", "getFriendRequestsList", "Lretrofit2/Call;", "Lcom/mobility/myapplication/model/Example;", "results", "", "app_debug"})
public abstract interface ServiceInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "api/")
    public abstract retrofit2.Call<com.mobility.myapplication.model.Example> getFriendRequestsList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "results")
    java.lang.String results);
}