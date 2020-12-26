package com.example.scheduleapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ScheduleListAdapter(
    context: Context
) : RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder>(){

    private var listener: ((Int?) -> Unit)? = null
    // 関数型の変数Listenerに登録する
    fun setOnItemClickListener(listener: (Int?)-> Unit){
        this.listener = listener
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var schedule = emptyList<Schedule>()

    inner class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var dateText: TextView = itemView.findViewById(R.id.dateText)
        var titleIText: TextView = itemView.findViewById(R.id.titleText)
    }

    // ScheduleViewHolderのオブジェクト生成をするメソッド
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleListAdapter.ScheduleViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ScheduleViewHolder(itemView)
    }

    // ScheduleViewHolder内の各画面部品に表示データを割り当てるメソッド
    override fun onBindViewHolder(holder: ScheduleListAdapter.ScheduleViewHolder, position: Int) {
        val scheduleItem = schedule[position]
        holder.titleIText.text = scheduleItem.title
        holder.dateText.text = "test"
        // RecyclerViewのがタップされたことをMainActivityへ通知する
        holder.itemView.setOnClickListener{
            listener?.invoke(scheduleItem.id) // タップされたセルのIDを送る
        }
    }

    // scheduleのセッター
    fun setSchedule(schedule: List<Schedule>){
        this.schedule = schedule
        notifyDataSetChanged() // 登録されているobserverにデータセットが変更されたことを通知
    }

    // データ件数を返すメソッド
    override fun getItemCount() = schedule.size
}