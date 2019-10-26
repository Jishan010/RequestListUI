package com.mobility.myapplication.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ResultDao_Impl implements ResultDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Results> __insertionAdapterOfResults;

  private final EntityInsertionAdapter<Location> __insertionAdapterOfLocation;

  public ResultDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfResults = new EntityInsertionAdapter<Results>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `result_table` (`result_id`,`gender`,`email`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Results value) {
        stmt.bindLong(1, value.getResult_id());
        if (value.getGender() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGender());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
      }
    };
    this.__insertionAdapterOfLocation = new EntityInsertionAdapter<Location>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `location_table` (`location_id`,`city`,`state`,`country`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Location value) {
        stmt.bindLong(1, value.getLocation_id());
        if (value.getCity() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCity());
        }
        if (value.getState() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getState());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCountry());
        }
      }
    };
  }

  @Override
  public void addResult(final Results results) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfResults.insert(results);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addLocation(final Location location) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLocation.insert(location);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Results>> getResultLists() {
    final String _sql = "select * from result_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"result_table"}, false, new Callable<List<Results>>() {
      @Override
      public List<Results> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfResultId = CursorUtil.getColumnIndexOrThrow(_cursor, "result_id");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final List<Results> _result = new ArrayList<Results>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Results _item;
            _item = new Results();
            final int _tmpResult_id;
            _tmpResult_id = _cursor.getInt(_cursorIndexOfResultId);
            _item.setResult_id(_tmpResult_id);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            _item.setGender(_tmpGender);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            _item.setEmail(_tmpEmail);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<ResultNameData>> getResultNameDataList() {
    final String _sql = "select result_table.email , result_table.gender  ,name_table.title ,name_table.first,name_table.last,location_table.city,location_table.state,location_table.country  from result_table INNER JOIN name_table ON result_table.result_id=name_table.name_id INNER JOIN location_table ON   result_table.result_id=location_table.location_id  ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"result_table","name_table","location_table"}, false, new Callable<List<ResultNameData>>() {
      @Override
      public List<ResultNameData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfFirst = CursorUtil.getColumnIndexOrThrow(_cursor, "first");
          final int _cursorIndexOfLast = CursorUtil.getColumnIndexOrThrow(_cursor, "last");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
          final List<ResultNameData> _result = new ArrayList<ResultNameData>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ResultNameData _item;
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpGender;
            _tmpGender = _cursor.getString(_cursorIndexOfGender);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpFirst;
            _tmpFirst = _cursor.getString(_cursorIndexOfFirst);
            final String _tmpLast;
            _tmpLast = _cursor.getString(_cursorIndexOfLast);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            final String _tmpState;
            _tmpState = _cursor.getString(_cursorIndexOfState);
            final String _tmpCountry;
            _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
            _item = new ResultNameData(_tmpTitle,_tmpFirst,_tmpLast,_tmpGender,_tmpEmail,_tmpCity,_tmpState,_tmpCountry);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
