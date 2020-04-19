package com.regis.model;

public class Item {

	private long cupom;
	private long item;

	public long getCupom() {
		return cupom;
	}

	public void setCupom(long cupom) {
		this.cupom = cupom;
	}

	public long getItem() {
		return item;
	}

	public void setItem(long item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Item [cupom=" + cupom + ", item=" + item + "]";
	}

}
