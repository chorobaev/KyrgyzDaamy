package com.timelysoft.kainarapp.adapter.expandable

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.timelysoft.kainarapp.R
import com.timelysoft.kainarapp.service.response.AboutResponse


class CustomExpandableListAdapter(
    private val context: Context,
    private val dataList: ArrayList<AboutResponse>
) : BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return this.dataList[listPosition].description
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(
        listPosition: Int,
        expandedListPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val expandedListText = getChild(listPosition, expandedListPosition) as String
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_list_child, null)
        }
        val expandedListTextView = convertView!!.findViewById<TextView>(R.id.about_child)
        expandedListTextView.text = expandedListText
        return convertView
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return 1
    }

    override fun getGroup(listPosition: Int): Any {
        return this.dataList[listPosition].title
    }

    override fun getGroupCount(): Int {
        return this.dataList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(
        listPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_list_parent, null)
        }
        val listTitleTextView = convertView!!.findViewById<TextView>(R.id.about_parent)
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}