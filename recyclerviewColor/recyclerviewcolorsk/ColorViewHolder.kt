package com.example.recyclerviewcolorsk

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    // получаем ссылку на текстовое поле в каждом элементе списка
    val tv = itemView.findViewById<TextView>(R.id.color)



    // TODO: добавить обработку нажатия на элемент списка (вывести Toast с кодом цвета)
    // совет: использовать блок init { }


    fun bindTo(color: Int, onItemClickListener: ((Int) -> Unit)?) {

        itemView.setOnClickListener{
            onItemClickListener?.invoke(color)
        }


        tv.setBackgroundColor(color)
        // вывод кода цвета в 16-ричном виде
        tv.text = itemView.context.getString(R.string.template, color)
    }
}
