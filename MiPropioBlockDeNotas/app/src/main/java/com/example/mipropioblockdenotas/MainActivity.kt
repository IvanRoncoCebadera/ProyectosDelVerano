package com.example.mipropioblockdenotas

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mipropioblockdenotas.adapter.NoteAdapter
import com.example.mipropioblockdenotas.databinding.ActivityMainBinding
import com.example.mipropioblockdenotas.models.Nota

@RequiresApi(Build.VERSION_CODES.N)
class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var noteAdapter: NoteAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        noteAdapter = NoteAdapter(this)

        noteAdapter.submitList(noteAdapter.notas)

        binding.listaNotas.apply {
            setHasFixedSize(true)
            adapter = noteAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.botonAAdir.setOnClickListener{

            val nota = Nota(Nota.giveNextId(), binding.tituloParaAAdir.text.toString())
            onClickAdd(nota)
        }

        binding.deleteButton.setOnClickListener {
            onClickDelete()
        }
    }

    override fun onClickAdd(nota: Nota){
        //Esta lista me sirvio para depurar, la dejo porque si
        //var lista = noteAdapter.currentList

        noteAdapter.notas.add(nota)

        noteAdapter.notifyItemInserted(noteAdapter.notas.size-1)

        //lista = noteAdapter.currentList

        //Este logger trate de usarlo para depurar, pero la verdad es que no me sirvio
        // Log.d(MainActivity::class::simpleName.toString(), noteAdapter.currentList.joinToString())

        binding.tituloParaAAdir.text.clear()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onClickDelete(){
        noteAdapter.notas.removeAll { nota -> nota.isChecked }

        //Esta lista me sirvio para depurar, la dejo porque si
        //var lista = noteAdapter.currentList

        //Soy consciente de que este no es el método más eficiente, pero tras mucha quemadura de cabeza, funciona y PUNTO!!! >:C
        noteAdapter.notifyDataSetChanged()

        //lista = noteAdapter.currentList
    }
}