package com.chriscodes.chrisfortune.retrofitexample.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chriscodes.chrisfortune.retrofitexample.DataModel.Comment;
import com.chriscodes.chrisfortune.retrofitexample.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private List<Comment> commentList;
    private Context context;

    public CommentAdapter(List<Comment> commentList, Context context){

        this.commentList = commentList;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public final View rowView;

        TextView commentNumTxtVw;
        TextView commentTxtVw;
        TextView nameTxtVw;
        TextView emailTxtVw;

        ViewHolder(View viewItem){

            super(viewItem);

            rowView = viewItem;
            commentNumTxtVw = rowView.findViewById(R.id.post_number_txt_vw);
            commentTxtVw = rowView.findViewById(R.id.comment_txt_vw);
           // nameTxtVw = rowView.findViewById(R.id.name_txt_vw);
           // emailTxtVw = rowView.findViewById(R.id.email_txt_vw);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.recycler_custom_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String commentNum = Integer.toString(commentList.get(position).getId());
        holder.commentNumTxtVw.setText(commentNum);
        holder.commentTxtVw.setText(commentList.get(position).getBody());
        //holder.emailTxtVw.setText(commentList.get(position).getEmail());
        //holder.nameTxtVw.setText(commentList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
