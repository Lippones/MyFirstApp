package com.example.myfirstapp;


public class Login {
    private String usuario;

    private String senha;

    public void Login() {
        usuario= "";
        senha = "";
    }

    public boolean validacaoLogin(){
        return (usuario.equals("Filipe") && senha.equals("Lipas"));
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
