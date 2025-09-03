package com.brightsprouts.`data`.database

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import com.brightsprouts.`data`.database.dao.ProgressDao
import com.brightsprouts.`data`.database.dao.ProgressDao_Impl
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class JumpStartAcademyDatabase_Impl : JumpStartAcademyDatabase() {
  private val _progressDao: Lazy<ProgressDao> = lazy {
    ProgressDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1,
        "ecccece0aa2b4b580a5b7240f4abaa38", "8e41e34694173adc398e2544252a3600") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `lesson_progress` (`lessonId` TEXT NOT NULL, `completed` INTEGER NOT NULL, `score` INTEGER NOT NULL, `starsEarned` INTEGER NOT NULL, `completedAt` TEXT, `attempts` INTEGER NOT NULL, PRIMARY KEY(`lessonId`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS `user_progress` (`id` INTEGER NOT NULL, `totalLessonsCompleted` INTEGER NOT NULL, `totalStarsEarned` INTEGER NOT NULL, `currentStreak` INTEGER NOT NULL, `longestStreak` INTEGER NOT NULL, `lastActivityDate` TEXT, `stickersUnlocked` TEXT NOT NULL, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ecccece0aa2b4b580a5b7240f4abaa38')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `lesson_progress`")
        connection.execSQL("DROP TABLE IF EXISTS `user_progress`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsLessonProgress: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsLessonProgress.put("lessonId", TableInfo.Column("lessonId", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsLessonProgress.put("completed", TableInfo.Column("completed", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsLessonProgress.put("score", TableInfo.Column("score", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsLessonProgress.put("starsEarned", TableInfo.Column("starsEarned", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsLessonProgress.put("completedAt", TableInfo.Column("completedAt", "TEXT", false, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsLessonProgress.put("attempts", TableInfo.Column("attempts", "INTEGER", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysLessonProgress: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesLessonProgress: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoLessonProgress: TableInfo = TableInfo("lesson_progress", _columnsLessonProgress,
            _foreignKeysLessonProgress, _indicesLessonProgress)
        val _existingLessonProgress: TableInfo = read(connection, "lesson_progress")
        if (!_infoLessonProgress.equals(_existingLessonProgress)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |lesson_progress(com.brightsprouts.data.database.entity.LessonProgressEntity).
              | Expected:
              |""".trimMargin() + _infoLessonProgress + """
              |
              | Found:
              |""".trimMargin() + _existingLessonProgress)
        }
        val _columnsUserProgress: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsUserProgress.put("id", TableInfo.Column("id", "INTEGER", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserProgress.put("totalLessonsCompleted", TableInfo.Column("totalLessonsCompleted",
            "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUserProgress.put("totalStarsEarned", TableInfo.Column("totalStarsEarned", "INTEGER",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUserProgress.put("currentStreak", TableInfo.Column("currentStreak", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUserProgress.put("longestStreak", TableInfo.Column("longestStreak", "INTEGER", true,
            0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUserProgress.put("lastActivityDate", TableInfo.Column("lastActivityDate", "TEXT",
            false, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsUserProgress.put("stickersUnlocked", TableInfo.Column("stickersUnlocked", "TEXT",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysUserProgress: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesUserProgress: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoUserProgress: TableInfo = TableInfo("user_progress", _columnsUserProgress,
            _foreignKeysUserProgress, _indicesUserProgress)
        val _existingUserProgress: TableInfo = read(connection, "user_progress")
        if (!_infoUserProgress.equals(_existingUserProgress)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |user_progress(com.brightsprouts.data.database.entity.UserProgressEntity).
              | Expected:
              |""".trimMargin() + _infoUserProgress + """
              |
              | Found:
              |""".trimMargin() + _existingUserProgress)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "lesson_progress",
        "user_progress")
  }

  public override fun clearAllTables() {
    super.performClear(false, "lesson_progress", "user_progress")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(ProgressDao::class, ProgressDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun progressDao(): ProgressDao = _progressDao.value
}
