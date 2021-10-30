package com.example.kazim.mohaqeqkabuli;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<String> titleList;
    private CustomItemClickListener clickListener;

    public TitleAdapter(Context context,ArrayList<String> titleList,CustomItemClickListener clickListener){
        this.context=context;
        this.titleList=titleList;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.title_layout,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v,viewHolder.getPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        switch (titleList.get(position)){
            case Constants.PREFACE:
                holder.titleText.setText(R.string.preface);
                break;
                case Constants.BORN:
                holder.titleText.setText(R.string.borns);
                    break;
            case Constants.PRIMARY_EDUCATION:
                holder.titleText.setText(R.string.primary_education);
                break;
            case Constants.TRAVELLING_TO_NAJAF:
                holder.titleText.setText(R.string.travelling_najaf);
                break;
            case Constants.HIGHER_EDUCATION:
                holder.titleText.setText(R.string.higher_education);
                    break;
                case Constants.TEACHING_IN_NAJAF_AND_EJTEHAD:
                holder.titleText.setText(R.string.teaching_in_najaf_and_ejtehad);
                    break;
                case Constants.RETURNING_TO_THE_COUNDTRY:
                holder.titleText.setText(R.string.returning_to_the_country);
                    break;
                case Constants.STAYING_IN_KABUL:
                holder.titleText.setText(R.string.staying_in_kabul);
                    break;
                case Constants.TRAVELLING_AND_HOLYWAR:
                holder.titleText.setText(R.string.travelling_and_holywar);
                    break;
                case Constants.RETURNING_TO_KABUL:
                holder.titleText.setText(R.string.returning_to_kabul);
                    break;
                case Constants.AGAIN_TRAVELLING_TO_IRAN:
                holder.titleText.setText(R.string.again_travelling_to_iran);
                    break;
                case Constants.MARJAEIAT:
                holder.titleText.setText(R.string.marjaeiat);
                holder.linebelowTextView.setVisibility(View.INVISIBLE);
                    break;


        }

    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        TextView linebelowTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText=(TextView)itemView.findViewById(R.id.title_text);
            linebelowTextView=(TextView)itemView.findViewById(R.id.line_below_textview);
        }
    }
}
