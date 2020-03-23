package com.farleydeftones;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 * return true se a string é bem formada ou nao exemplo
 * ([])[]({}) retorna true
 * ([)] ou ((() retorna false
 * */
public class ExpressionWellFormedTest {
    boolean result=false;
    @Test
    public void caseEBemFormada() {
        Assert.assertEquals(true,this.eBemForamada("([{}])"));
    }

    @Test
    public void caseNaoEbemFormada() {
        Assert.assertEquals(false,this.eBemForamada("[[["));

    }

    @Test
    public void caseNaoEbemFormada2() {
        Assert.assertEquals(false,this.eBemForamada("()}}()"));
    }


    public boolean eBemForamada(String expressao) {

        AtomicBoolean result = new AtomicBoolean(true);
        Map<String,String >mapa=new HashMap<>();
        //criei um mapa com as chaves e seus respectivos valores
        mapa.put("(",")");
        mapa.put("[","]");
        mapa.put("{","}");
        //dividi a expressao e adicionei em uma lista
        List<String>lista=Arrays.asList(expressao.split(""));
        //se a lista começar com um elemento de fechamento ja retorna falso
        List<String>tagAbertura=new ArrayList<>();
        if(lista.get(0).equals(mapa.get("("))||
                lista.get(0).equals(mapa.get("["))||
                        lista.get(0).equals(mapa.get("{"))){
            return false;
        }
        //pra cada elemento da lista verifico se é um elemento de abertura
        //se sim adiciono em uma lista de objetos de abertura
        //[]]
        lista.forEach(e->{
            if(mapa.containsKey(e)){
                tagAbertura.add(e);
            }else{
                //se nao for um objeto de abertura verifico entao
                //se é o par perfeito do ultimo objeto de abertura
                if(tagAbertura.size()>0){
                    String ultimoTagAbertura=tagAbertura.get(tagAbertura.size()-1);
                    String parPerfeito=mapa.get(ultimoTagAbertura);
                    if(e.equals(parPerfeito)){
                        //se o proximo elemento formar um para perfeito
                        //com ultimo elemento de abertura removo o ultimo elemento
                        //da tag de abertura
                        //e continuo verificando
                        tagAbertura.remove(ultimoTagAbertura);


                    }else{
                        //se nao formar um par perfeito ja encerro e retorno falso
                        result.set(false);
                    }
                }else{
                    result.set(false);
                }


            }
        });
        //se no final a lista de elemento de abertura ficar sem par e porque
        //esta mal formada
        if(tagAbertura.size()>0){
            return false;
        }
        //se nao cair em nenhum if retorna true
        return result.get();
    }


}
