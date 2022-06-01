package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogin extends AppCompatActivity {
    EditText editTextLoginUsuario;
    EditText editTextLoginPassword;
    Button buttonLogin;

    private void getComponents(){
        editTextLoginUsuario = findViewById(R.id.editTextUsuario);
        editTextLoginPassword = findViewById(R.id.editTextSenha);

        buttonLogin = findViewById(R.id.buttonLogin);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getComponents();
        getSupportActionBar().hide();
    }

    @Override
    protected void onStart(){
        super.onStart();
        editTextLoginUsuario.setText("");
        editTextLoginPassword.setText("");
        editTextLoginUsuario.requestFocus();
    }

    public void onClickButtonLogin(View view) {
        String usuario = editTextLoginUsuario.getText().toString();
        String senha = editTextLoginPassword.getText().toString();

        if (usuario.isEmpty()) {
            Toast.makeText(this, "Campo usuario obrigatorio", Toast.LENGTH_SHORT).show();
            editTextLoginUsuario.requestFocus();
            return;
        }
        if (senha.isEmpty()) {
            Toast.makeText(this, "Campo senha obrigatorio", Toast.LENGTH_SHORT).show();
            editTextLoginPassword.requestFocus();
            return;
        }
        Login login = new Login();
        login.setUsuario(usuario);
        login.setSenha(senha);
        if (login.validacaoLogin()) {
            Toast.makeText(this, "Usuario e senha validos", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Toast.makeText(this, "Usuario ou senha invalidos", Toast.LENGTH_SHORT).show();
            editTextLoginUsuario.setText("");
            editTextLoginPassword.setText("");
            editTextLoginUsuario.requestFocus();
        }
    }
}
