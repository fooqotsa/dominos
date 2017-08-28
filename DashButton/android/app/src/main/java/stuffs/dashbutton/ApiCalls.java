package stuffs.dashbutton;

import retrofit.http.GET;

public interface ApiCalls {

    @GET("/test")
    void test();

}
