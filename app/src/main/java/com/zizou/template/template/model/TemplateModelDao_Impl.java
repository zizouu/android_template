package com.zizou.template.template.model;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.zizou.template.common.database.TypeConverter;
import com.zizou.template.template.dao.TemplateModelDao;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TemplateModelDao_Impl implements TemplateModelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TemplateModel> __insertionAdapterOfTemplateModel;

  private final TypeConverter __typeConverter = new TypeConverter();

  private final EntityDeletionOrUpdateAdapter<TemplateModel> __deletionAdapterOfTemplateModel;

  private final EntityDeletionOrUpdateAdapter<TemplateModel> __updateAdapterOfTemplateModel;

  public TemplateModelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTemplateModel = new EntityInsertionAdapter<TemplateModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `template_room_model` (`index`,`created_date`,`title`,`content`,`modified_date`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TemplateModel value) {
        if (value.getIndex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIndex());
        }
        final Long _tmp;
        _tmp = __typeConverter.convertDateToTimeStamp(value.getCreatedDate());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getContent() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContent());
        }
        final Long _tmp_1;
        _tmp_1 = __typeConverter.convertDateToTimeStamp(value.getModifiedDate());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
      }
    };
    this.__deletionAdapterOfTemplateModel = new EntityDeletionOrUpdateAdapter<TemplateModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `template_room_model` WHERE `index` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TemplateModel value) {
        if (value.getIndex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIndex());
        }
      }
    };
    this.__updateAdapterOfTemplateModel = new EntityDeletionOrUpdateAdapter<TemplateModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `template_room_model` SET `index` = ?,`created_date` = ?,`title` = ?,`content` = ?,`modified_date` = ? WHERE `index` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TemplateModel value) {
        if (value.getIndex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getIndex());
        }
        final Long _tmp;
        _tmp = __typeConverter.convertDateToTimeStamp(value.getCreatedDate());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, _tmp);
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getContent() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContent());
        }
        final Long _tmp_1;
        _tmp_1 = __typeConverter.convertDateToTimeStamp(value.getModifiedDate());
        if (_tmp_1 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp_1);
        }
        if (value.getIndex() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getIndex());
        }
      }
    };
  }

  @Override
  public Maybe<Long> insertOne(final TemplateModel templateRoomModel) {
    return Maybe.fromCallable(new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfTemplateModel.insertAndReturnId(templateRoomModel);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Maybe<Integer> deleteOne(final TemplateModel templateRoomModel) {
    return Maybe.fromCallable(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__deletionAdapterOfTemplateModel.handle(templateRoomModel);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Maybe<Integer> updateOne(final TemplateModel templateRoomModel) {
    return Maybe.fromCallable(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__updateAdapterOfTemplateModel.handle(templateRoomModel);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Flowable<List<TemplateModel>> getAll() {
    final String _sql = "SELECT * FROM template_room_model";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createFlowable(__db, false, new String[]{"template_room_model"}, new Callable<List<TemplateModel>>() {
      @Override
      public List<TemplateModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "index");
          final int _cursorIndexOfCreatedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "created_date");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfModifiedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "modified_date");
          final List<TemplateModel> _result = new ArrayList<TemplateModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TemplateModel _item;
            _item = new TemplateModel();
            final Integer _tmpIndex;
            if (_cursor.isNull(_cursorIndexOfIndex)) {
              _tmpIndex = null;
            } else {
              _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
            }
            _item.setIndex(_tmpIndex);
            final Date _tmpCreatedDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfCreatedDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfCreatedDate);
            }
            _tmpCreatedDate = __typeConverter.convertTimeStampToDate(_tmp);
            _item.setCreatedDate(_tmpCreatedDate);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item.setTitle(_tmpTitle);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            _item.setContent(_tmpContent);
            final Date _tmpModifiedDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfModifiedDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfModifiedDate);
            }
            _tmpModifiedDate = __typeConverter.convertTimeStampToDate(_tmp_1);
            _item.setModifiedDate(_tmpModifiedDate);
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
  public Flowable<TemplateModel> findByIndex(final int index) {
    final String _sql = "SELECT * FROM template_room_model WHERE `index` = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, index);
    return RxRoom.createFlowable(__db, false, new String[]{"template_room_model"}, new Callable<TemplateModel>() {
      @Override
      public TemplateModel call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "index");
          final int _cursorIndexOfCreatedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "created_date");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfModifiedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "modified_date");
          final TemplateModel _result;
          if(_cursor.moveToFirst()) {
            _result = new TemplateModel();
            final Integer _tmpIndex;
            if (_cursor.isNull(_cursorIndexOfIndex)) {
              _tmpIndex = null;
            } else {
              _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
            }
            _result.setIndex(_tmpIndex);
            final Date _tmpCreatedDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfCreatedDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfCreatedDate);
            }
            _tmpCreatedDate = __typeConverter.convertTimeStampToDate(_tmp);
            _result.setCreatedDate(_tmpCreatedDate);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _result.setTitle(_tmpTitle);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            _result.setContent(_tmpContent);
            final Date _tmpModifiedDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfModifiedDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfModifiedDate);
            }
            _tmpModifiedDate = __typeConverter.convertTimeStampToDate(_tmp_1);
            _result.setModifiedDate(_tmpModifiedDate);
          } else {
            _result = null;
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
