/*
 *
 *  Created by Sergey Stepchenkov on 16.10.20 13:54
 *  Copyright (c) 2020. All rights reserved.
 *  More info on www.bootcode.ru
 *  Last modified 14.10.20 16:06
 *
 */

package ru.bootcode.crdiet.database.noteweek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.bootcode.crdiet.R;

public class NoteWeekAdapter extends RecyclerView.Adapter<NoteWeekAdapter.ViewHolder>{

    // Стандартный адаптер, все особенности откоментрованы в коде функций

    private List<NoteWeek> notesLists;
    public NoteWeekAdapter(List<NoteWeek> myDataLists) {
        this.notesLists = myDataLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.week_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //---------------------------------------------------
        // Вся магия отображения кодиться здесь!
        // получаем текущий элеент (NoteWeek) и обрабатываем его по кусочкам
        //---------------------------------------------------

        NoteWeek md=notesLists.get(i);

        viewHolder.tvNote.setText(md.getComment());
        //viewHolder.itemView.setBackgroundColor(md.getColor());
/*
        if (md.isCrypto()) {
            viewHolder.vwPic.setImageResource(R.drawable.ic_act_lock);
        } else {
            switch (md.getType_id()) {
                case 1: {
                    viewHolder.vwPic.setImageResource(R.drawable.ic_act_calendar);
                    break;
                }
                case 2: {
                    viewHolder.vwPic.setImageResource(R.drawable.ic_act_lock);
                    break;
                }
                default:{
                    viewHolder.vwPic.setImageResource(R.color.colorTransparent);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 48);
                    viewHolder.vwPic.setLayoutParams(layoutParams);
                }
            }
        }
        */

    }

    @Override
    public int getItemCount() {
        // возвращает размер нашего списка NoteWeek
        return notesLists.size();
    }

    public NoteWeek getItemNote(int i) {
        // Вспомогательный геттер который может нам вернуть класс NoteWeek по позиции
        return notesLists.get(i);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNote;
        private ImageView vwPic;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNote=(TextView)itemView.findViewById(R.id.tvNote);
            vwPic = (ImageView) itemView.findViewById(R.id.vwPic);
        }
    }
}
