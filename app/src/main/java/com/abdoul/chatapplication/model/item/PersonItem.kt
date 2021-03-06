package com.abdoul.chatapplication.model.item

import android.content.Context
import com.abdoul.chatapplication.R
import com.abdoul.chatapplication.glide.GlideApp
import com.abdoul.chatapplication.model.User
import com.abdoul.chatapplication.util.StorageUtil
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.person_entry.*

class PersonItem(val person: User, val userId: String, private val context: Context) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.txtUserName.text = person.name
        viewHolder.txtBio.text = person.bio
        if (person.profilePicture != null) {
            GlideApp.with(context)
                .load(StorageUtil.pathToReference(person.profilePicture))
                .placeholder(R.drawable.ic_account)
                .into(viewHolder.imgPersonProfilePict)
        }
    }

    override fun getLayout() = R.layout.person_entry
}