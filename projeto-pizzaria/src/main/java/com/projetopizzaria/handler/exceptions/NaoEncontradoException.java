package com.projetopizzaria.handler.exceptions;

public class NaoEncontradoException extends RuntimeException{
    public NaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
