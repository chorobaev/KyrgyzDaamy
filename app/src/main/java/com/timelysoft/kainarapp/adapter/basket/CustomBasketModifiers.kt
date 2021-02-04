package com.timelysoft.kainarapp.adapter.basket

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.timelysoft.kainarapp.R
import com.timelysoft.kainarapp.base.GenericRecyclerAdapter
import com.timelysoft.kainarapp.base.ViewHolder
import com.timelysoft.kainarapp.service.model2.response2.BaseModifier
import kotlinx.android.synthetic.main.item_mod_basket.view.*

class CustomBasketModifiers(val list: ArrayList<BaseModifier>)  :GenericRecyclerAdapter<BaseModifier>(list) {


    override fun bind(item: BaseModifier, holder: ViewHolder) = with(holder.itemView){
        if (item.price == 0){
            modifierPrice.visibility = View.GONE
        }
        item_mod_basket_modifierName.text = item.name
        amount.text = "${item.count}"
        modifierPrice.text = "${item.price}"

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_mod_basket)
    }


}