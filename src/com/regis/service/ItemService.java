package com.regis.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.regis.dto.ItemDTO;
import com.regis.model.Item;

public class ItemService {
	
	public void montarLinhaComItens() {
		List<Item> itens = montarListaItens();
		Map<String, List<String>> itensFiltrados = new HashMap<>();
		
		for (Item item : itens) {
			ItemDTO itemDto = new ItemDTO();
			itemDto.setCupom(String.valueOf(item.getCupom()));
			itemDto.setItem(String.valueOf(item.getItem()));
			List<String> vSemRepeticao = new ArrayList<>();
			
			itensFiltrados.computeIfPresent(itemDto.getCupom(), (String k, List<String> v) -> {
				v.add(itemDto.getItem());
				
				for (String vu : v) {
					if (!vSemRepeticao.contains(vu)) {
						vSemRepeticao.add(vu);
					}
				}

				return vSemRepeticao;
			});
			itensFiltrados.putIfAbsent(itemDto.getCupom(), new ArrayList<>(Arrays.asList(itemDto.getItem())));
		}
		
		List<String> listaFinalCsv = new ArrayList<>();
		
		itensFiltrados.forEach((k, vSemRepeticao) -> {
			List<String> csv = new ArrayList<>();
			csv.add(k);
			
			vSemRepeticao.forEach(csv::add);

			listaFinalCsv.add(String.join(";", csv));
			System.out.println("\n# csv: " + csv); // Teste
			System.out.println("# listaFinalCsv: " + listaFinalCsv); // Teste
		});
	}

	public List<Item> montarListaItens() {
		
		Item item1 = new Item();
		item1.setCupom(1);
		item1.setItem(1010);
		
		Item item2 = new Item();
		item2.setCupom(1);
		item2.setItem(2020);
		
		Item item3 = new Item();
		item3.setCupom(1);
		item3.setItem(3030);
		
		Item item4 = new Item();
		item4.setCupom(2);
		item4.setItem(1010);
		
		List<Item> itens = new ArrayList<>();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);
		itens.add(item4);

		return itens;
	}
	
}
