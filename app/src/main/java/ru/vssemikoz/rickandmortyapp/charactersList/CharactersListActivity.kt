package ru.vssemikoz.rickandmortyapp.charactersList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.rickandmortyapp.R
import ru.vssemikoz.rickandmortyapp.utils.ActivityUtils

class CharactersListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.characters_list_act)
        var newsFeedFragment: CharactersListFragment? =
            supportFragmentManager.findFragmentById(R.id.characters_list_content_frame) as CharactersListFragment?
        if (newsFeedFragment == null) {
            newsFeedFragment = CharactersListFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager, newsFeedFragment, R.id.characters_list_content_frame
            )
        }
    }
}
