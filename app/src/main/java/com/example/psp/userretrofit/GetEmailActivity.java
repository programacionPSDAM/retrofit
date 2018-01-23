package com.example.psp.userretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.psp.userretrofit.data.model.User;
import com.example.psp.userretrofit.data.remote.APIService;
import com.example.psp.userretrofit.data.remote.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetEmailActivity extends AppCompatActivity {
    private TextView mResponseTv;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_email);
        final EditText editTextEmail     = findViewById(R.id.editexEmailGet);
        Button submitBtn                 = (Button) findViewById(R.id.btnBuscarUsuario);
        mResponseTv                      = (TextView) findViewById(R.id.tv_response_get);
        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                sendEmail(email);
            }
        });
    }

    private void sendEmail(String email) {
        mAPIService.listUsers(email).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    if (response.body().size() == 0)
                        Toast.makeText(getApplicationContext(),
                                "NO EXISTE EL USUARIO", Toast.LENGTH_SHORT).show();
                    else
                        showResponse(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("UI senPost" , "error en el servicio");
                Toast.makeText(getApplicationContext(),
                        "ERROR EN EL SERVICIO", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void showResponse(User user) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(user.toString());
    }
}
