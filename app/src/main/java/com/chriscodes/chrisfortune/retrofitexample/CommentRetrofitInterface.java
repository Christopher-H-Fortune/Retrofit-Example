package com.chriscodes.chrisfortune.retrofitexample;

import com.chriscodes.chrisfortune.retrofitexample.DataModel.Comment;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CommentRetrofitInterface {

    @GET("/comments")
    Call<List<Comment>> getAllComments();

}
