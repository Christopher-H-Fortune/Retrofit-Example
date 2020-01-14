package com.chriscodes.chrisfortune.retrofitexample.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.chriscodes.chrisfortune.retrofitexample.CommentRetrofitInterface;
import com.chriscodes.chrisfortune.retrofitexample.CustomAdapter.CommentAdapter;
import com.chriscodes.chrisfortune.retrofitexample.DataModel.Comment;
import com.chriscodes.chrisfortune.retrofitexample.R;
import com.chriscodes.chrisfortune.retrofitexample.RetrofitClient.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.show();

        CommentRetrofitInterface commentRetrofitInterface = RetrofitClient.getRetrofit().create(CommentRetrofitInterface.class);

        Call<List<Comment>> commentCall = commentRetrofitInterface.getAllComments();

        commentCall.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                progressDialog.dismiss();
                displayComments(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Error...Please Try Again.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void displayComments(List<Comment> commentList){

        RecyclerView recyclerView = findViewById(R.id.comment_recycler_vw);

        CommentAdapter commentAdapter = new CommentAdapter(commentList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(commentAdapter);
    }
}
