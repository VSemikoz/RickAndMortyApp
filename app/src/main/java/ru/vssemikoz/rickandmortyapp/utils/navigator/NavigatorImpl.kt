package ru.vssemikoz.rickandmortyapp.utils.navigator

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import ru.vssemikoz.rickandmortyapp.R
import ru.vssemikoz.rickandmortyapp.characterDetails.CharacterDetailsActivity
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import javax.inject.Inject


class NavigatorImpl @Inject constructor(val context: Context) : Navigator {
    override fun openCharacterDetailsWithTransaction(
        characterItem: CharacterItem,
        imageView: ImageView,
        fromActivity: Activity
    ) {
        Intent(context, CharacterDetailsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val bundle = Bundle()
            bundle.putSerializable("characterItem", characterItem)
            putExtras(bundle)

            val transitionName: String = context.getString(R.string.character_image)
            val transitionActivityOptions =
                ActivityOptions.makeSceneTransitionAnimation(fromActivity, imageView, transitionName)
            fromActivity.startActivity(this, transitionActivityOptions.toBundle())
        }
    }
}
