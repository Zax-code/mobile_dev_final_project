package com.esilv.finalprojectzakariaabouliatim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterDataAdapter(private val characters: List<CharacterInfos>) :RecyclerView.Adapter<CharacterDataAdapter.CharacterViewHolder>(){
    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageViewCharacters: List<ImageView> = listOf(itemView.findViewById(R.id.imageViewCharacter1), itemView.findViewById(R.id.imageViewCharacter2))
        val textViewCharacterNames: List<TextView> = listOf(itemView.findViewById(R.id.textViewCharacterName1), itemView.findViewById(R.id.textViewCharacterName2))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_card_layout, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characters = listOf<CharacterInfos>(characters[2*position], characters[2*position+1])
        for (i in 0..1) {
            val character = characters[i]
            Glide.with(holder.itemView)
                .load(character.imageUrl)
                .into(holder.imageViewCharacters[i])
            holder.textViewCharacterNames[i].text = character.name
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }
}