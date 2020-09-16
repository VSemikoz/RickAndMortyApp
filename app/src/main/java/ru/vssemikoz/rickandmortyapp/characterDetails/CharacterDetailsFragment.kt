package ru.vssemikoz.rickandmortyapp.characterDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.character_details_frag.view.*
import ru.vssemikoz.rickandmortyapp.MainApplication
import ru.vssemikoz.rickandmortyapp.R
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import ru.vssemikoz.rickandmortyapp.utils.imageUtlis.ImageUtils
import ru.vssemikoz.rickandmortyapp.utils.mappers.CharacterMapper
import javax.inject.Inject

class CharacterDetailsFragment @Inject constructor() : Fragment(), CharacterDetailsContract.View {
    @Inject
    lateinit var mPresenter: CharacterDetailsContract.Presenter

    @Inject
    lateinit var mapper: CharacterMapper
    lateinit var characterToShow: CharacterItem

    lateinit var nameTV: TextView
    lateinit var imageIV: ImageView
    lateinit var statusTV: TextView
    lateinit var typeTV: TextView
    lateinit var genderTV: TextView
    lateinit var speciesTV: TextView
    lateinit var dateTV: TextView
    lateinit var episodeTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.getApplicationComponent().fragmentComponent().inject(this)
        mPresenter.setView(this)
        activity?.intent?.extras.let {
            if (it != null) {
                characterToShow = it.getSerializable("characterItem") as CharacterItem
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.character_details_frag, container, false)
        initViews(root)
        displayCharacter()
        return root
    }

    private fun displayCharacter() {
        val displayCharacter = mapper.map(characterToShow)
        with(displayCharacter) {
            nameTV.text = name
            ImageUtils.setImageByUrl(imageUrl, imageIV)
            statusTV.text = status
            typeTV.text = type
            genderTV.text = gender
            speciesTV.text = species
            dateTV.text = created
            episodeTV.text = episode
        }
    }

    private fun initViews(root: View) {
        with(root) {
            nameTV = tv_details_name
            imageIV = iv_details_image
            statusTV = tv_details_status
            typeTV = tv_details_type
            genderTV = tv_details_gender
            speciesTV = tv_details_species
            dateTV = tv_details_date
            episodeTV = tv_details_episode
        }
    }
}
