package com.example.welder.model;

import java.util.ArrayList;

/**
 * Created by welder on 17/07/16.
 */
public class Pessoas {

    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

    public void adicionar(Pessoa p){
        pessoas.add(p);
    }

    public Pessoa obter(int i){
        return pessoas.get(i);
    }

    public int tamanho(){
        return this.pessoas.size();
    }
}
