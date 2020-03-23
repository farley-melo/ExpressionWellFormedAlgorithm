package com.farleydeftones;

import org.junit.Assert;
import org.junit.Test;
/*
* return true se a string é bem formada ou nao exemplo
* ([])[]({}) retorna true
* ([)] ou ((() retorna false
* */
public class ExpressionWellFormedTest {
   public void caseEBemFormada(){
       Assert.assertTrue(this.eBemForamada("([])[]({})"));
   }
   @Test
   public void caseNaoEbemFormada(){
       Assert.assertFalse(this.eBemForamada("([)]"));

   }

   @Test
   public void  caseNaoEbemFormada2(){
       Assert.assertFalse(this.eBemForamada("((()"));
   }

   
   public boolean eBemForamada(String expressao){

   }

}
