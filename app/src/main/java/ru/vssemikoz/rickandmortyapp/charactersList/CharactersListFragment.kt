package ru.vssemikoz.rickandmortyapp.charactersList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.characters_list_frag.view.*
import ru.vssemikoz.rickandmortyapp.MainApplication
import ru.vssemikoz.rickandmortyapp.R
import ru.vssemikoz.rickandmortyapp.adapters.BaseAdapter
import ru.vssemikoz.rickandmortyapp.model.CharacterItem
import ru.vssemikoz.rickandmortyapp.utils.navigator.Navigator
import javax.inject.Inject

class CharactersListFragment @Inject constructor() : Fragment(), CharactersListContract.View {

    @Inject
    lateinit var mPresenter: CharactersListContract.Presenter

    @Inject
    lateinit var adapter: BaseAdapter<CharacterItem>

    @Inject
    lateinit var navigator: Navigator

    private lateinit var recyclerView: RecyclerView
    private lateinit var noContentET: View

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
        recyclerView = root.rv_characters_list
        noContentET = root.et_no_content
        initRecyclerView()
        mPresenter.getCharacters()
    }

    override fun showEmptyView() {
        recyclerView.visibility = View.GONE
        noContentET.visibility = View.VISIBLE
    }

    override fun showList(items: MutableList<CharacterItem>) {
        adapter.items = items
        adapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        adapter.listener = object : BaseAdapter.OnRecyclerItemClickListener {
            override fun onRecyclerItemClick(position: Int, imageView: ImageView) {
                val character = adapter.items?.get(position)
                if (character != null) navigator.openCharacterDetailsWithTransaction(
                    character,
                    imageView,
                    activity!!
                )
            }
        }

    }
}
