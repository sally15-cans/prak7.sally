package com.sally.prak7sally;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("en/books")
    Call<List<Book>> getBooks(); // Java method syntax
}
