package ru.vssemikoz.rickandmortyapp.characterDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.rickandmortyapp.R
import ru.vssemikoz.rickandmortyapp.utils.ActivityUtils

class CharacterDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_detail_act)
        var newsFeedFragment: CharacterDetailsFragment? =
            supportFragmentManager.findFragmentById(R.id.characters_details_content_frame) as CharacterDetailsFragment?
        if (newsFeedFragment == null) {
            newsFeedFragment = CharacterDetailsFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager, newsFeedFragment, R.id.characters_details_content_frame
            )
        }
    }
}
