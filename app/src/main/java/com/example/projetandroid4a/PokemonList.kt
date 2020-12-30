package com.example.projetandroid4a

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.GridLayoutAnimationController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetandroid4a.presentation.Adapter.PokemonListAdapter
import com.example.projetandroid4a.presentation.common.Common
import com.example.projetandroid4a.presentation.common.ItemOffsetDecoration
import com.example.projetandroid4a.presentation.retrofit.IPokemonList
import com.example.projetandroid4a.presentation.retrofit.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_pokemon_list.*


class PokemonList : Fragment() {

    internal var compositeDisposable=CompositeDisposable()
    internal var iPokemonList:IPokemonList
    internal lateinit var recycler_view: RecyclerView

    init {
        val retrofit=RetrofitClient.instance
        iPokemonList = retrofit.create(IPokemonList::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        recycler_view = itemView.findViewById(R.id.pokemon_recyclerview) as RecyclerView
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager=GridLayoutManager(activity,2)
        val itemDecoration = ItemOffsetDecoration(activity!!,R.dimen.spacing)
        recycler_view.addItemDecoration(itemDecoration)

        fetchData()

        return itemView
    }

    private fun fetchData() {
        compositeDisposable.add(iPokemonList.listPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{ pokemonDex ->
                Common.pokemonList=pokemonDex.pokemon!!
                val adapter = PokemonListAdapter(activity!!,Common.pokemonList)

                recycler_view.adapter = adapter
            }
        );
    }

}
