package com.infinitskills.mvc.data.entities;

public class HitCounter {

	private int hits;

	public HitCounter(){
		System.out.println("Counter Hit :"+hits); 
	}
	
	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
	
	
}
