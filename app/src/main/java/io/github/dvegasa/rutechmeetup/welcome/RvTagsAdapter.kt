package io.github.dvegasa.rutechmeetup.welcome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.dvegasa.rutechmeetup.R
import kotlinx.android.synthetic.main.item_tag.view.*

/**
 * Created by Ed Khalturin @DVegasa
 */
class RvTagsAdapter (val tags: List<Tag>) : RecyclerView.Adapter<RvTagsAdapter.VH>() {

    inner class VH(val v: View) : RecyclerView.ViewHolder(v) {
        fun bind(pos: Int) {
            v.apply {
                tvTagName.text = tags[pos].name
                v.ivCheck.visibility = if (tags[pos].isChecked) View.VISIBLE else View.INVISIBLE

                setOnClickListener {
                    tags[pos].isChecked = !tags[pos].isChecked
                    v.ivCheck.visibility = if (tags[pos].isChecked) View.VISIBLE else View.INVISIBLE
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false)
        return VH(v)
    }

    override fun getItemCount() = tags.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }
}