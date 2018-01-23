package com.example.psp.userretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.psp.userretrofit.data.model.User;
import com.example.psp.userretrofit.data.remote.APIService;
import com.example.psp.userretrofit.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private TextView mResponseTv;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final EditText editTextID        = findViewById(R.id.editexID);
        final EditText editTextFirstName = findViewById(R.id.editexFirstName);
        final EditText editTextLastName  = findViewById(R.id.editexLastName);
        final EditText editTextEmail     = findViewById(R.id.editexEmail);
        Button submitBtn                 = (Button) findViewById(R.id.btnCrearUsuario);
        mResponseTv                      = (TextView) findViewById(R.id.tv_response);

        mAPIService = ApiUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id;
                if (editTextID.getText().toString().trim().equals(""))
                    id = 0;
                else
                    id           =  Integer.parseInt(editTextID.getText().toString().trim());
                String firstName = editTextFirstName.getText().toString().trim();
                String lastName  = editTextLastName.getText().toString().trim();
                String email     = editTextEmail.getText().toString().trim();
                if(!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)
                        && !TextUtils.isEmpty(email)) {
                    User user = new User (id, firstName, lastName, email);
                    Log.i("UI onClick", "user: " + user);
                    sendUser(user);
                }

            }
        });
    }

    private void sendUser(final User user) {
        mAPIService.savePost(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    Log.i("UI sendUser", "post submitted to API." + response.body().toString());
                    showResponse(user);
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
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
