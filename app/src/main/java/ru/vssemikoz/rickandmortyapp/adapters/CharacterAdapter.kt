package ru.vssemikoz.rickandmortyapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.character_item.view.*
import ru.vssemikoz.rickandmortyapp.R
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import ru.vssemikoz.rickandmortyapp.utils.imageUtlis.ImageUtils
import javax.inject.Inject

class CharacterAdapter @Inject constructor(context: Context) : BaseAdapter<CharacterItem>(context) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CharacterItem> {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view, listener)
    }

    inner class CharacterViewHolder(view: View, listener: OnRecyclerItemClickListener?) :
        BaseViewHolder<CharacterItem>(view) {
        private val cardView: CardView = view.cv_character_item
        private val characterName: TextView = view.tv_character_name
        private val characterImage: ImageView = view.iv_character_image

        init {
            cardView.setOnClickListener {
                listener?.onRecyclerItemClick(adapterPosition, characterImage)
            }
        }

        override fun onBind(item: CharacterItem, listener: OnRecyclerItemClickListener?) {
            characterName.text = item.name
            ImageUtils.setImageByUrl(item.imageUrl, characterImage)
        }

    }
}


