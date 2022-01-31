package dev.matyaqubov.recyclerviewbestpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.matyaqubov.recyclerviewbestpractice.R
import dev.matyaqubov.recyclerviewbestpractice.model.Contact

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private val dif = AsyncListDiffer(this, ITEM_DIFF)

    companion object{
        //obnavit qilish uchun
        private val ITEM_DIFF=object : DiffUtil.ItemCallback<Contact>(){
            override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem.name == newItem.name && oldItem.phone==newItem.phone
            }

            override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
                return oldItem.name == newItem.name && oldItem.phone==newItem.phone
            }

        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name=view.findViewById<TextView>(R.id.tv_name)
        var number=view.findViewById<TextView>(R.id.tv_phone)
        fun bind() {
            val contact=dif.currentList[adapterPosition]
            name.text=contact.name
            number.text=contact.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_custom,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()

    override fun getItemCount(): Int {
    return dif.currentList.size
    }

    public fun submitList(list:ArrayList<Contact>){
        dif.submitList(list)
    }

}