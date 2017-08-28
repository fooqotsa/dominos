package stuffs.dashbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.squareup.okhttp.OkHttpClient;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

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
                hitApi();
            }
        });
    }

    private void hitApi() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://localhost3000").setClient(new OkClient(
                new OkHttpClient())).setLogLevel(RestAdapter.LogLevel.FULL).build();

        ApiCalls apiCalls =  adapter.create(ApiCalls.class);

        apiCalls.test(new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                Toast.makeText(DashActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(DashActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
