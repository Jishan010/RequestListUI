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

  private final EntityInsertionAdapter<Name> __insertionAdapterOfName;

  private final EntityInsertionAdapter<Picture> __insertionAdapterOfPicture;

  private final EntityInsertionAdapter<Dob> __insertionAdapterOfDob;

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
    this.__insertionAdapterOfName = new EntityInsertionAdapter<Name>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `name_table` (`name_id`,`title`,`first`,`last`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Name value) {
        stmt.bindLong(1, value.getName_id());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getFirst() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFirst());
        }
        if (value.getLast() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLast());
        }
      }
    };
    this.__insertionAdapterOfPicture = new EntityInsertionAdapter<Picture>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `picture_table` (`picture_id`,`thumbnail`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Picture value) {
        stmt.bindLong(1, value.getPicture_id());
        if (value.getThumbnail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getThumbnail());
        }
      }
    };
    this.__insertionAdapterOfDob = new EntityInsertionAdapter<Dob>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `dob_table` (`dob_id`,`age`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Dob value) {
        stmt.bindLong(1, value.getDob_id());
        if (value.getAge() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getAge());
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
  public void addName(final Name name) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfName.insert(name);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addPicture(final Picture picture) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPicture.insert(picture);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addDob(final Dob dob) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDob.insert(dob);
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
  public Name getNameList(final int name_id) {
    final String _sql = "select * from name_table where name_id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, name_id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNameId = CursorUtil.getColumnIndexOrThrow(_cursor, "name_id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfFirst = CursorUtil.getColumnIndexOrThrow(_cursor, "first");
      final int _cursorIndexOfLast = CursorUtil.getColumnIndexOrThrow(_cursor, "last");
      final Name _result;
      if(_cursor.moveToFirst()) {
        final int _tmpName_id;
        _tmpName_id = _cursor.getInt(_cursorIndexOfNameId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpFirst;
        _tmpFirst = _cursor.getString(_cursorIndexOfFirst);
        final String _tmpLast;
        _tmpLast = _cursor.getString(_cursorIndexOfLast);
        _result = new Name(_tmpName_id,_tmpTitle,_tmpFirst,_tmpLast);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ResultNameData>> getResultNameDataList() {
    final String _sql = "select result_table.email , result_table.gender  ,name_table.title ,name_table.first,name_table.last,location_table.city,location_table.state,location_table.country ,dob_table.age,picture_table.thumbnail from result_table INNER JOIN name_table ON result_table.result_id=name_table.name_id INNER JOIN location_table ON   result_table.result_id=location_table.location_id  INNER JOIN dob_table ON result_table.result_id=dob_table.dob_id  INNER JOIN picture_table ON result_table.result_id=picture_table.picture_id ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"result_table","name_table","location_table","dob_table","picture_table"}, false, new Callable<List<ResultNameData>>() {
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
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfThumbnail = CursorUtil.getColumnIndexOrThrow(_cursor, "thumbnail");
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
            final String _tmpAge;
            _tmpAge = _cursor.getString(_cursorIndexOfAge);
            final String _tmpThumbnail;
            _tmpThumbnail = _cursor.getString(_cursorIndexOfThumbnail);
            _item = new ResultNameData(_tmpTitle,_tmpFirst,_tmpLast,_tmpGender,_tmpEmail,_tmpCity,_tmpState,_tmpCountry,_tmpThumbnail,_tmpAge);
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
