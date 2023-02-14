package com.example.gromik2sem1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val list: List<Humans>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val viewHolder: ViewHolder = ViewHolder()
        val view = p1 ?: LayoutInflater.from(p2?.context).inflate(
            R.layout.item_listview, p2, false)
        with(viewHolder) {
            parent = view
            id = view.findViewById(R.id.tv_id)
            name = view.findViewById(R.id.tv_name)
            surname = view.findViewById(R.id.tv_email)
            val human = getItem(p0) as Humans
            id.text = human.id.toString()
            name.text = human.username
            surname.text = human.email
        }


        return viewHolder.parent

    }

    private class ViewHolder() {
        lateinit var parent: View
        lateinit var id: TextView
        lateinit var name: TextView
        lateinit var surname: TextView
    }

}