package stuffs.dashbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;

public class DashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);

        final Button dashButton = (Button)findViewById(R.id.buy_pizza);

        dashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("AMG I've Been Hit");

            }
        });
    }

    private void hitApi() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("localhost").setClient(new OkClient(
                new OkHttpClient())).setLogLevel(RestAdapter.LogLevel.FULL).build();

        ApiCalls apiCalls =  adapter.create(ApiCalls.class);
        
    }

}
