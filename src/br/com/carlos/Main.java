package br.com.carlos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	static List<Pessoa> listaCompleta = new ArrayList();
	static List<Pessoa> m = new ArrayList();
	static List<Pessoa> f = new ArrayList();
	
	static Scanner l = new Scanner (System.in);
	
	public static void main (String [] args) {
		opcao();
	}
	
	public static void opcao() {
	    System.out.println("\n1- Consultar listas\n2- Adicionar alguém à lista\n");
	    byte choice = l.nextByte();

	    switch (choice) {
	        case 1:
	            consultarListas();
	            main(null);
	            break;
	        case 2:
	        	String[] ns = nomeESexo();
	            adicionar(ns[0], ns[1]);
	            main(null);
	            break;
	        default:
	            System.out.println("Número Inválido");
	            opcao();
	            break;
	    }
	}

	private static void consultarListas() {
	    System.out.println("Qual lista quer consultar?\n"
	            + "1- Todos os nomes\n"
	            + "2- Somente Homens\n"
	            + "3- Somente Mulheres\n");
	    byte sublistChoice = l.nextByte();

	    switch (sublistChoice) {
	        case 1:
	        	for(int i = 0; i < listaCompleta.size(); i++) {
	            	System.out.println(listaCompleta.get(i).toString());
	    		}
	            break;
	        case 2:
	        	for(int i = 0; i < m.size(); i++) {
	            	System.out.println(m.get(i).toString());
	    		}
	            break;
	        case 3:
	        	for(int i = 0; i < f.size(); i++) {
	            	System.out.println(f.get(i).toString());
	    		}
	            break;
	        default:
	            System.out.println("Número Inválido");
	            consultarListas();
	            break;
	    }
	}
	
	public static void adicionar(String a, String b) {
		
		if(b.equalsIgnoreCase("M")) {
			m.add(new Pessoa(a, b.charAt(0)));
			listaCompleta.add(m.get(m.size()-1));
			Collections.sort(m, new Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
	                return pessoa1.getNome().compareTo(pessoa2.getNome());
	            }
	        });
			
		}else if(b.equalsIgnoreCase("F")) {
			f.add(new Pessoa(a, b.charAt(0)));
			listaCompleta.add(f.get(f.size()-1));
			Collections.sort(f, new Comparator<Pessoa>() {
	            @Override
	            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
	                return pessoa1.getNome().compareTo(pessoa2.getNome());
	            }
	        });
		}
		
		Collections.sort(listaCompleta, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
                return pessoa1.getNome().compareTo(pessoa2.getNome());
            }
        });
	}
	
	public static String[] nomeESexo() {
        System.out.println("Digite seu nome e depois o sexo usando apenas letra como M/F separando por uma ','\nexemplo: Seu Nome,M/F");
        String nomeSexo = l.next();
        String[] separado = nomeSexo.split(",");
        String sexo = separado[1].trim();

        if (sexo.isEmpty()) {
            System.out.println("Sexo não selecionado");
            return nomeESexo();
        }
        
        if (separado.length == 2 && (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("F"))) {
            separado[1] = sexo;
        } else {
            System.out.println("Entrada inválida");
            return nomeESexo();
        }
        
        return separado;
    }
	
}
