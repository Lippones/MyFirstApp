package com.example.myfirstapp;

public class Game {
    private String[] pos = new String[10];
    private String vez;
    private Boolean jogoAndamento;
    private Integer qtJogadas;

    Game(){
      jogoAndamento = true;
      qtJogadas = 0;
      vez = "X";
      for(int i = 0; i < pos.length; i++){
            pos[i]= "";
      }
    }

    public String setPos(Integer pos){
        qtJogadas++;
        String resultado = "";
        resultado = vez;
        this.pos[pos] = vez;

        if(vez.equals("X")){
            vez = "O";
        }else if(vez.equals("O")){
            vez="X";
        }
        return resultado;
    }

    public Boolean verificarEmpate(){
        if(qtJogadas == 9){
            jogoAndamento = false;
            return true;
        }else{
            return false;
        }
    }

    public Boolean verificarVitoria(String tipo){
        //Horizontal
        if(verificarPos(1,2,3,tipo)){
            return true;
        }
        if(verificarPos(3,5,6,tipo)){
            return true;
        }
        if(verificarPos(7,8,9,tipo)){
            return true;
        }
        //Vertical
        if(verificarPos(1,4,7,tipo)){
            return true;
        }
        if(verificarPos(2,5,8,tipo)){
            return true;
        }
        if(verificarPos(3,6,9,tipo)){
            return true;
        }
        //Diagonal
        if(verificarPos(1,5,9,tipo)){
            return true;
        }
        if(verificarPos(3,5,7,tipo)){
            return true;
        }
        return false;
    }

    public Boolean verificarPos(Integer pos1,Integer pos2,Integer pos3, String tipo){
        return pos[pos1].equals(tipo) && pos[pos2].equals(tipo) && pos[pos3].equals(tipo);
    }

    public String getVez() {
        return vez;
    }
    public Boolean getJogoAndamento() {
        return jogoAndamento;
    }

}
