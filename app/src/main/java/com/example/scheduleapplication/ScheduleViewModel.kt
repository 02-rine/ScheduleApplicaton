package com.example.scheduleapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

// データの保持・管理をするクラス
class ScheduleViewModel(application: Application) : AndroidViewModel(application) {

    // 非同期処理をするための宣言
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: ScheduleRepository
    val allSchedule: LiveData<List<Schedule>> // データベースの全データを格納

    init{
        val scheduleDao = ScheduleRoomDatabase.getDatabase(application, scope).scheduleDao()
        repository = ScheduleRepository(scheduleDao)
        allSchedule = repository.allSchedule // データベースの全データを取得
    }

    // parentJobをキャンセル
    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

    // データベースへデータを入力する
    fun insert(schedule: Schedule) = scope.launch(Dispatchers.IO) {
        repository.insert(schedule)
    }
}