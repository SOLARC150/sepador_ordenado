package br.com.carlos;

public class Pessoa {

	String nome;
	Character sexo;
	
	public Pessoa(String nome, Character letra) 
	{
		this.nome = nome;
		this.sexo = letra;
	}
	
	@Override
	public String toString() 
	{
		return "Nome: "+this.nome+" - Sexo: " + Character.toUpperCase(sexo) + "";
	}
	
}
