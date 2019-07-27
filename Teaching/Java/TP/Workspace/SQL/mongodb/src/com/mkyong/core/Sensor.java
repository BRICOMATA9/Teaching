package com.mkyong.core;

import java.util.Comparator;

public class Sensor {
    public String id;
    public String name;
    public String interval;
    public String votes;

    public Sensor(){}

    public Sensor(String id, String name, String interval) {
        this.id = id;
        this.name = name;
        this.interval = interval;
    }

	public String toString(){
		return id+" "+name+" "+interval;
	}
}
