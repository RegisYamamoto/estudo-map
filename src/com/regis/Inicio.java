package com.regis;

import com.regis.service.ItemService;

public class Inicio {

	public static void main(String[] args) {
		
		ItemService itemService = new ItemService();
		itemService.montarLinhaComItens();

	}

}