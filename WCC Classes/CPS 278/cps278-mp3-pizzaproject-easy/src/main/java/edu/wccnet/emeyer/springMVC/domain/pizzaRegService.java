package edu.wccnet.emeyer.springMVC.domain;

import java.util.LinkedHashMap;


import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class pizzaRegService {
	
	public Map<String, String>populateState(){
		Map<String,String> stateList = new LinkedHashMap<String,String>();
		
		stateList.put("mi", "Michigan");
		stateList.put("oh", "Ohio");
		stateList.put("pa", "Pennsylvania");
		stateList.put("id", "Idaho");
		stateList.put("il", "Illinois");
		return stateList;
	}
	
	public Map<String, String>populateSize(){
		Map<String,String> sizeList = new LinkedHashMap<String,String>();
		sizeList.put("S", "Small");
		sizeList.put("M", "Medium");
		sizeList.put("L", "Large");
		return sizeList;
	}

	public Map<String, String>populateTopping(){
		Map<String,String> toppingList = new LinkedHashMap<String,String>();
		toppingList.put("Mushroom", "Mushroom");
		toppingList.put("Pepperoni", "Pepperoni");
		toppingList.put("Pineapple", "Pineapple");
		toppingList.put("Black Olives", "Black Olives");
		toppingList.put("Bacon", "Bacon");
		return toppingList;
	}
}
