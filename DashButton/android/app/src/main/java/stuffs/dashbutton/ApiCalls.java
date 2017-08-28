package stuffs.dashbutton;

import retrofit.Callback;
import retrofit.http.GET;

public interface ApiCalls {

    @GET("/test")
    void test(Callback<String> callback);

}
