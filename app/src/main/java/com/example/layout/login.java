package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbAutoLogin;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        cbAutoLogin = findViewById(R.id.cb_auto_login);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "用户名或密码不为空", Toast.LENGTH_LONG).show();
        }
        if ("android".equals((username)) && "123".equals(password)) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            Toast.makeText(this, "账号或密码错误", Toast.LENGTH_LONG).show();
        }
    }
}