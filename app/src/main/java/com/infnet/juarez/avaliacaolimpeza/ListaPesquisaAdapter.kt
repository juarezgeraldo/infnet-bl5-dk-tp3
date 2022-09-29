package com.infnet.juarez.avaliacaolimpeza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.infnet.juarez.avaliacaolimpeza.modelo.Pesquisa

class ListaPesquisaAdapter(private val listaPesquisas: ArrayList<Pesquisa>) :
    RecyclerView.Adapter<ListaPesquisaAdapter.ViewHolder>() {

    //    var listaPesquisas = ArrayList<Pesquisa>()
//    set(value){
//        field = value
//        this.notifyDataSetChanged()
//    }
    lateinit var itemListner: RecyclerViewItemListner

    fun setRecyclerViewItemListner(listner: RecyclerViewItemListner) {
        itemListner = listner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.lista_pesquisas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listaPesquisas[position], itemListner, position)
    }

    override fun getItemCount(): Int {
        return listaPesquisas.size
    }

    //Classe interna = relação Tdo - Parte
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(pesquisa: Pesquisa, itemListner: RecyclerViewItemListner, position: Int) {
            val txtListaIdPesquisa = itemView.findViewById<TextView>(R.id.txtIdPesquisa)
            txtListaIdPesquisa.setText(pesquisa.id)
            val txtListaNomePesquisa = itemView.findViewById<TextView>(R.id.txtNomePesquisa)
            txtListaNomePesquisa.setText(pesquisa.nomePesquisa)
            val txtIdEstabelecimento = itemView.findViewById<TextView>(R.id.txtIdEstabelecimento)
            txtIdEstabelecimento.setText(pesquisa.estabelecimento?.id ?: null)
            val btnExcluirPesquisa = itemView.findViewById<ImageButton>(R.id.btnExcluirPesquisa)
            val btnAlterarPesquisa = itemView.findViewById<ImageButton>(R.id.btnAlterarPesquisa)
            val btnEditaPesquisa = itemView.findViewById<ImageButton>(R.id.btnEditaPesquisa)

            btnExcluirPesquisa.setOnClickListener() {
                itemListner.recyclerViewBotaoExcluirClicked(it, txtListaIdPesquisa.text.toString())
            }
            btnAlterarPesquisa.setOnClickListener() {
                itemListner.recyclerViewBotaoAlterarClicked(it, txtListaIdPesquisa.text.toString())
            }
            btnEditaPesquisa.setOnClickListener() {
                itemListner.recyclerViewBotaoEditaClicked(it, txtListaIdPesquisa.text.toString(), txtIdEstabelecimento.text.toString())
            }
        }
    }
}
