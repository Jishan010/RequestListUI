package com.mobility.myapplication.model;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDatabase_Impl extends UserDatabase {
  private volatile NameDao _nameDao;

  private volatile ResultDao _resultDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `result_table` (`result_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `gender` TEXT, `email` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `name_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `result_id_column` INTEGER NOT NULL, `title` TEXT, `first` TEXT, `last` TEXT, FOREIGN KEY(`id`) REFERENCES `result_table`(`result_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '968d8defdd64bf6c207001fb1b1d210d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `result_table`");
        _db.execSQL("DROP TABLE IF EXISTS `name_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsResultTable = new HashMap<String, TableInfo.Column>(3);
        _columnsResultTable.put("result_id", new TableInfo.Column("result_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResultTable.put("gender", new TableInfo.Column("gender", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsResultTable.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysResultTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesResultTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoResultTable = new TableInfo("result_table", _columnsResultTable, _foreignKeysResultTable, _indicesResultTable);
        final TableInfo _existingResultTable = TableInfo.read(_db, "result_table");
        if (! _infoResultTable.equals(_existingResultTable)) {
          return new RoomOpenHelper.ValidationResult(false, "result_table(com.mobility.myapplication.model.Results).\n"
                  + " Expected:\n" + _infoResultTable + "\n"
                  + " Found:\n" + _existingResultTable);
        }
        final HashMap<String, TableInfo.Column> _columnsNameTable = new HashMap<String, TableInfo.Column>(5);
        _columnsNameTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNameTable.put("result_id_column", new TableInfo.Column("result_id_column", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNameTable.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNameTable.put("first", new TableInfo.Column("first", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNameTable.put("last", new TableInfo.Column("last", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNameTable = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysNameTable.add(new TableInfo.ForeignKey("result_table", "CASCADE", "NO ACTION",Arrays.asList("id"), Arrays.asList("result_id")));
        final HashSet<TableInfo.Index> _indicesNameTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNameTable = new TableInfo("name_table", _columnsNameTable, _foreignKeysNameTable, _indicesNameTable);
        final TableInfo _existingNameTable = TableInfo.read(_db, "name_table");
        if (! _infoNameTable.equals(_existingNameTable)) {
          return new RoomOpenHelper.ValidationResult(false, "name_table(com.mobility.myapplication.model.Name).\n"
                  + " Expected:\n" + _infoNameTable + "\n"
                  + " Found:\n" + _existingNameTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "968d8defdd64bf6c207001fb1b1d210d", "6ed8f7d697db3a030efa3313cef37051");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "result_table","name_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `result_table`");
      _db.execSQL("DELETE FROM `name_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public NameDao getNameDao() {
    if (_nameDao != null) {
      return _nameDao;
    } else {
      synchronized(this) {
        if(_nameDao == null) {
          _nameDao = new NameDao_Impl(this);
        }
        return _nameDao;
      }
    }
  }

  @Override
  public ResultDao getResultDao() {
    if (_resultDao != null) {
      return _resultDao;
    } else {
      synchronized(this) {
        if(_resultDao == null) {
          _resultDao = new ResultDao_Impl(this);
        }
        return _resultDao;
      }
    }
  }
}
