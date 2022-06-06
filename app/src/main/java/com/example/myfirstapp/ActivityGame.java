package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityGame extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        iniciarGame();
    }



    private void iniciarGame() {
        game = new Game();

        ((TextView) findViewById(R.id.vez)).setText("A vez atual é: " + game.getVez());
        ((Button) findViewById(R.id.buttonGame1)).setText("");
        ((Button) findViewById(R.id.buttonGame2)).setText("");
        ((Button) findViewById(R.id.buttonGame3)).setText("");
        ((Button) findViewById(R.id.buttonGame4)).setText("");
        ((Button) findViewById(R.id.buttonGame5)).setText("");
        ((Button) findViewById(R.id.buttonGame6)).setText("");
        ((Button) findViewById(R.id.buttonGame7)).setText("");
        ((Button) findViewById(R.id.buttonGame8)).setText("");
        ((Button) findViewById(R.id.buttonGame9)).setText("");
    }

    public void onClickButton(View view) {
        iniciarGame();
    }
    public void onClickButtonGame(View view){
        Button button = (Button) view;
        Integer pos = 0;
        switch (button.getId()){
            case R.id.buttonGame1:
                pos=1;
                break;
            case R.id.buttonGame2:
                pos=2;
                break;
            case R.id.buttonGame3:
                pos=3;
                break;
            case R.id.buttonGame4:
                pos=4;
                break;
            case R.id.buttonGame5:
                pos=5;
                break;
            case R.id.buttonGame6:
                pos=6;
                break;
            case R.id.buttonGame7:
                pos=7;
                break;
            case R.id.buttonGame8:
                pos=8;
                break;
            case R.id.buttonGame9:
                pos=9;
                break;
        }
        if(pos!=0){
            button.setText(verificarMarcacao(button.getText().toString(), pos));
        }
    }

    private String verificarMarcacao(String texto, Integer pos){
        try {
            if (game.getJogoAndamento()){
                if (texto.isEmpty()){
                    String vez = game.setPos(pos);
                    Boolean vitoria = game.verificarVitoria(vez);
                    Boolean empate = game.verificarEmpate();

                    TextView textViewVez = findViewById(R.id.vez);
                    if(vitoria){
                        textViewVez.setText("VITORIA DO " + vez + "!");
                    }else if(empate){
                        textViewVez.setText("EMPATE !");
                    }else{
                        textViewVez.setText("Vez do " + game.getVez()+": ");
                    }
                    return vez;

                }else{
                    Toast.makeText(this, "Escolha outra posição", Toast.LENGTH_SHORT).show();
                    return texto;
                }
            }else{
                Toast.makeText(this, "Fim de jogo", Toast.LENGTH_LONG).show();
                return texto;
            }

        } catch (Exception e){
            return "";
        }
    }
}