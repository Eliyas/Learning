package Behavioural;

import java.util.*;

public class Client {
	
	public static void main(String args[]) {
		Subject subject = new WheatherStation();
		
		Observer obs1 = new MobileDisplay();
		Observer obs2 = new TabletDisplay();
		
		subject.registerObserver(obs1);
		subject.registerObserver(obs2);
		
		subject.setWheatherData(25.5f, 1013.1f, 65.0f);
		subject.setWheatherData(27.3f, 1012.5f, 70.0f);
	}
}


interface Observer {
	void update(float temprature, float pressure, float humidity);
}

interface Subject {
	void registerObserver(Observer obs);
	void removeObserver(Observer obs);
	void notifyObservers();
	void setWheatherData(float temprature, float pressure, float humidity);
}


class WheatherStation implements Subject {
	
	private List<Observer> observers;
	private float temprature;
	private float pressure;
	private float humidity;
	
	public WheatherStation() {
		this.observers = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer obs) {
		this.observers.add(obs);		
	}
	
	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);		
	}
	
	@Override
	public void setWheatherData(float temprature, float pressure, float humidity) {
		this.temprature = temprature;
		this.pressure = pressure;
		this.humidity = humidity;
		
		this.notifyObservers();
	}
	
	@Override
	public void notifyObservers() {
		for(Observer obs : observers) {
			obs.update(this.temprature, this.pressure, this.humidity);	
		}	
	}

}

class MobileDisplay implements Observer {
	private float temprature;
	private float pressure;
	private float humidity;
	
	@Override
	public void update(float temprature, float pressure, float humidity) {
		this.temprature = temprature;
		this.pressure = pressure;
		this.humidity = humidity;
		this.showWheatherData();
	}
	
	public void showWheatherData() {
		System.out.println("Mobile Display: Temp: "+ this.temprature +"; Pressure: "+ this.pressure +"; Humidity: "+ this.humidity);
	}
	
}

class TabletDisplay implements Observer {
	private float temprature;
	private float pressure;
	private float humidity;
	
	@Override
	public void update(float temprature, float pressure, float humidity) {
		this.temprature = temprature;
		this.pressure = pressure;
		this.humidity = humidity;
		this.showWheatherData();
	}
	
	public void showWheatherData() {
		System.out.println("Tablet Display : Temp: "+ this.temprature +"; Pressure: "+ this.pressure +"; Humidity: "+ this.humidity);
	}
	
}