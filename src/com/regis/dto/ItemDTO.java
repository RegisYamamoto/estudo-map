package com.regis.dto;

public class ItemDTO {

	private String cupom;
	private String item;

	public String getCupom() {
		return cupom;
	}

	public void setCupom(String cupom) {
		this.cupom = cupom;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ItemDTO [cupom=" + cupom + ", item=" + item + "]";
	}

}
