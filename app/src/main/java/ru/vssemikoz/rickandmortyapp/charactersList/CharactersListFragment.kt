package ru.vssemikoz.rickandmortyapp.charactersList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.characters_list_frag.view.*
import ru.vssemikoz.rickandmortyapp.MainApplication
import ru.vssemikoz.rickandmortyapp.R
import javax.inject.Inject

class CharactersListFragment @Inject constructor() : Fragment(), CharactersListContract.View {

    @Inject
    lateinit var mPresenter: CharactersListContract.Presenter
    private lateinit var recyclerView: RecyclerView

//    @Inject
//    lateinit var adapter: TouchHelperAdapter<Product>
//    @Inject
//    lateinit var navigator: Navigator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainApplication.getApplicationComponent().fragmentComponent().inject(this)
        mPresenter.setView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.characters_list_frag, container, false)
        initViews(root)
        return root
    }

    private fun initViews(root: View) {
        recyclerView = root.rv_news_feed

    }
}
