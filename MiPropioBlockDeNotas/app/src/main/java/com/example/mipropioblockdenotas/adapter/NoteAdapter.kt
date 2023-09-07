package com.example.mipropioblockdenotas.adapter

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mipropioblockdenotas.OnClickListener
import com.example.mipropioblockdenotas.R
import com.example.mipropioblockdenotas.databinding.ActivityNotaViewBinding
import com.example.mipropioblockdenotas.models.Nota

data class NoteAdapter(
    private val listener: OnClickListener,
    val notas: MutableList<Nota> = mutableListOf()
):
    ListAdapter<Nota, RecyclerView.ViewHolder>(NoteDiffCallback())
{

    inner class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ActivityNotaViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_nota_view, //Le paso el layout de la vista de la nota!!!
                parent,
                false //Para no encajarlo a la vista principal???
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentNote = getItem(position) // Así sabemos la nota con la que estamos trabajando!!!

        with(holder as NoteViewHolder){
            //binding.noteContent.text.insert(0, currentNote.titulo), si lo pongo de esta manera, de alguna manera, el texto antes de haberse borrado, se guarda y vuelve a aparecer
            binding.noteContent.setText(currentNote.titulo)
            binding.checkBox.isChecked = currentNote.isChecked
            toggleStrikeThrough(binding.noteContent, currentNote.isChecked)
            binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(binding.noteContent, isChecked)
                currentNote.isChecked = isChecked // Actualizamos el estado isChecked
            }
        }
    }

    //Estoy bastante seguro de que esta funcion es la que tacha el texto cuando marco el checkbox
    private fun toggleStrikeThrough(noteContent: TextView, isCheckBox: Boolean){
        if(isCheckBox){
            noteContent.paintFlags = noteContent.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            noteContent.paintFlags = noteContent.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    class NoteDiffCallback: DiffUtil.ItemCallback<Nota>(){
        override fun areItemsTheSame(oldItem: Nota, newItem: Nota): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Nota, newItem: Nota): Boolean = oldItem == newItem
    }
}