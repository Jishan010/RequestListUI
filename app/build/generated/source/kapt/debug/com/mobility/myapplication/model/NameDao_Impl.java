package com.mobility.myapplication.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NameDao_Impl implements NameDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Name> __insertionAdapterOfName;

  public NameDao_Impl(RoomDatabase __db) {
    this.__db = __db;
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
}
