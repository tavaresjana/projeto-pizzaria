package com.projetopizzaria.handler.exceptions;

public class CampoVazioException extends RuntimeException {
    public CampoVazioException(){
        super("Há campos não preenchidos.");
    }

    public CampoVazioException(String mensagem){
        super(mensagem);
    }

}
