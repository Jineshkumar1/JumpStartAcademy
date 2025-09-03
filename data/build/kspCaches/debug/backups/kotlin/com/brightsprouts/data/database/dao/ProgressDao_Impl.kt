package com.brightsprouts.`data`.database.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.brightsprouts.`data`.database.converters.DomainConverters
import com.brightsprouts.`data`.database.entity.LessonProgressEntity
import com.brightsprouts.`data`.database.entity.UserProgressEntity
import java.time.LocalDateTime
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class ProgressDao_Impl(
  __db: RoomDatabase,
) : ProgressDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfLessonProgressEntity: EntityInsertAdapter<LessonProgressEntity>

  private val __domainConverters: DomainConverters = DomainConverters()

  private val __insertAdapterOfUserProgressEntity: EntityInsertAdapter<UserProgressEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfLessonProgressEntity = object :
        EntityInsertAdapter<LessonProgressEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `lesson_progress` (`lessonId`,`completed`,`score`,`starsEarned`,`completedAt`,`attempts`) VALUES (?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: LessonProgressEntity) {
        statement.bindText(1, entity.lessonId)
        val _tmp: Int = if (entity.completed) 1 else 0
        statement.bindLong(2, _tmp.toLong())
        statement.bindLong(3, entity.score.toLong())
        statement.bindLong(4, entity.starsEarned.toLong())
        val _tmpCompletedAt: LocalDateTime? = entity.completedAt
        val _tmp_1: String? = __domainConverters.fromLocalDateTime(_tmpCompletedAt)
        if (_tmp_1 == null) {
          statement.bindNull(5)
        } else {
          statement.bindText(5, _tmp_1)
        }
        statement.bindLong(6, entity.attempts.toLong())
      }
    }
    this.__insertAdapterOfUserProgressEntity = object : EntityInsertAdapter<UserProgressEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `user_progress` (`id`,`totalLessonsCompleted`,`totalStarsEarned`,`currentStreak`,`longestStreak`,`lastActivityDate`,`stickersUnlocked`) VALUES (?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: UserProgressEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindLong(2, entity.totalLessonsCompleted.toLong())
        statement.bindLong(3, entity.totalStarsEarned.toLong())
        statement.bindLong(4, entity.currentStreak.toLong())
        statement.bindLong(5, entity.longestStreak.toLong())
        val _tmpLastActivityDate: LocalDateTime? = entity.lastActivityDate
        val _tmp: String? = __domainConverters.fromLocalDateTime(_tmpLastActivityDate)
        if (_tmp == null) {
          statement.bindNull(6)
        } else {
          statement.bindText(6, _tmp)
        }
        statement.bindText(7, entity.stickersUnlocked)
      }
    }
  }

  public override suspend fun insertLessonProgress(progress: LessonProgressEntity): Unit =
      performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfLessonProgressEntity.insert(_connection, progress)
  }

  public override suspend fun insertUserProgress(progress: UserProgressEntity): Unit =
      performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfUserProgressEntity.insert(_connection, progress)
  }

  public override suspend fun getLessonProgress(lessonId: String): LessonProgressEntity? {
    val _sql: String = "SELECT * FROM lesson_progress WHERE lessonId = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, lessonId)
        val _columnIndexOfLessonId: Int = getColumnIndexOrThrow(_stmt, "lessonId")
        val _columnIndexOfCompleted: Int = getColumnIndexOrThrow(_stmt, "completed")
        val _columnIndexOfScore: Int = getColumnIndexOrThrow(_stmt, "score")
        val _columnIndexOfStarsEarned: Int = getColumnIndexOrThrow(_stmt, "starsEarned")
        val _columnIndexOfCompletedAt: Int = getColumnIndexOrThrow(_stmt, "completedAt")
        val _columnIndexOfAttempts: Int = getColumnIndexOrThrow(_stmt, "attempts")
        val _result: LessonProgressEntity?
        if (_stmt.step()) {
          val _tmpLessonId: String
          _tmpLessonId = _stmt.getText(_columnIndexOfLessonId)
          val _tmpCompleted: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_columnIndexOfCompleted).toInt()
          _tmpCompleted = _tmp != 0
          val _tmpScore: Int
          _tmpScore = _stmt.getLong(_columnIndexOfScore).toInt()
          val _tmpStarsEarned: Int
          _tmpStarsEarned = _stmt.getLong(_columnIndexOfStarsEarned).toInt()
          val _tmpCompletedAt: LocalDateTime?
          val _tmp_1: String?
          if (_stmt.isNull(_columnIndexOfCompletedAt)) {
            _tmp_1 = null
          } else {
            _tmp_1 = _stmt.getText(_columnIndexOfCompletedAt)
          }
          _tmpCompletedAt = __domainConverters.toLocalDateTime(_tmp_1)
          val _tmpAttempts: Int
          _tmpAttempts = _stmt.getLong(_columnIndexOfAttempts).toInt()
          _result =
              LessonProgressEntity(_tmpLessonId,_tmpCompleted,_tmpScore,_tmpStarsEarned,_tmpCompletedAt,_tmpAttempts)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getUserProgress(): UserProgressEntity? {
    val _sql: String = "SELECT * FROM user_progress WHERE id = 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTotalLessonsCompleted: Int = getColumnIndexOrThrow(_stmt,
            "totalLessonsCompleted")
        val _columnIndexOfTotalStarsEarned: Int = getColumnIndexOrThrow(_stmt, "totalStarsEarned")
        val _columnIndexOfCurrentStreak: Int = getColumnIndexOrThrow(_stmt, "currentStreak")
        val _columnIndexOfLongestStreak: Int = getColumnIndexOrThrow(_stmt, "longestStreak")
        val _columnIndexOfLastActivityDate: Int = getColumnIndexOrThrow(_stmt, "lastActivityDate")
        val _columnIndexOfStickersUnlocked: Int = getColumnIndexOrThrow(_stmt, "stickersUnlocked")
        val _result: UserProgressEntity?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpTotalLessonsCompleted: Int
          _tmpTotalLessonsCompleted = _stmt.getLong(_columnIndexOfTotalLessonsCompleted).toInt()
          val _tmpTotalStarsEarned: Int
          _tmpTotalStarsEarned = _stmt.getLong(_columnIndexOfTotalStarsEarned).toInt()
          val _tmpCurrentStreak: Int
          _tmpCurrentStreak = _stmt.getLong(_columnIndexOfCurrentStreak).toInt()
          val _tmpLongestStreak: Int
          _tmpLongestStreak = _stmt.getLong(_columnIndexOfLongestStreak).toInt()
          val _tmpLastActivityDate: LocalDateTime?
          val _tmp: String?
          if (_stmt.isNull(_columnIndexOfLastActivityDate)) {
            _tmp = null
          } else {
            _tmp = _stmt.getText(_columnIndexOfLastActivityDate)
          }
          _tmpLastActivityDate = __domainConverters.toLocalDateTime(_tmp)
          val _tmpStickersUnlocked: String
          _tmpStickersUnlocked = _stmt.getText(_columnIndexOfStickersUnlocked)
          _result =
              UserProgressEntity(_tmpId,_tmpTotalLessonsCompleted,_tmpTotalStarsEarned,_tmpCurrentStreak,_tmpLongestStreak,_tmpLastActivityDate,_tmpStickersUnlocked)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun observeUserProgress(): Flow<UserProgressEntity?> {
    val _sql: String = "SELECT * FROM user_progress WHERE id = 1"
    return createFlow(__db, false, arrayOf("user_progress")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfTotalLessonsCompleted: Int = getColumnIndexOrThrow(_stmt,
            "totalLessonsCompleted")
        val _columnIndexOfTotalStarsEarned: Int = getColumnIndexOrThrow(_stmt, "totalStarsEarned")
        val _columnIndexOfCurrentStreak: Int = getColumnIndexOrThrow(_stmt, "currentStreak")
        val _columnIndexOfLongestStreak: Int = getColumnIndexOrThrow(_stmt, "longestStreak")
        val _columnIndexOfLastActivityDate: Int = getColumnIndexOrThrow(_stmt, "lastActivityDate")
        val _columnIndexOfStickersUnlocked: Int = getColumnIndexOrThrow(_stmt, "stickersUnlocked")
        val _result: UserProgressEntity?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpTotalLessonsCompleted: Int
          _tmpTotalLessonsCompleted = _stmt.getLong(_columnIndexOfTotalLessonsCompleted).toInt()
          val _tmpTotalStarsEarned: Int
          _tmpTotalStarsEarned = _stmt.getLong(_columnIndexOfTotalStarsEarned).toInt()
          val _tmpCurrentStreak: Int
          _tmpCurrentStreak = _stmt.getLong(_columnIndexOfCurrentStreak).toInt()
          val _tmpLongestStreak: Int
          _tmpLongestStreak = _stmt.getLong(_columnIndexOfLongestStreak).toInt()
          val _tmpLastActivityDate: LocalDateTime?
          val _tmp: String?
          if (_stmt.isNull(_columnIndexOfLastActivityDate)) {
            _tmp = null
          } else {
            _tmp = _stmt.getText(_columnIndexOfLastActivityDate)
          }
          _tmpLastActivityDate = __domainConverters.toLocalDateTime(_tmp)
          val _tmpStickersUnlocked: String
          _tmpStickersUnlocked = _stmt.getText(_columnIndexOfStickersUnlocked)
          _result =
              UserProgressEntity(_tmpId,_tmpTotalLessonsCompleted,_tmpTotalStarsEarned,_tmpCurrentStreak,_tmpLongestStreak,_tmpLastActivityDate,_tmpStickersUnlocked)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clearLessonProgress() {
    val _sql: String = "DELETE FROM lesson_progress"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clearUserProgress() {
    val _sql: String = "DELETE FROM user_progress"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
