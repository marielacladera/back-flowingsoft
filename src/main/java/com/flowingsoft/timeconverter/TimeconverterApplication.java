package com.flowingsoft.timeconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class TimeconverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeconverterApplication.class, args);
		//restar(5, 12);
		//sumar(22, 15);
	}

	/*public static void restar (int hora, int horaLocal){
		int cantHora =  horaLocal%24;

		while(cantHora>0){
			if(hora > 0 ){
				hora = hora -1;
			}
			if(hora == 0){
				hora = 23;
			}
			cantHora = cantHora-1;
		}
		System.out.println(hora);
	}

	public static void sumar (int hora, int horaLocal){
		int cantHora =  horaLocal%24;

		while(cantHora>0){
			if(hora < 24 ){
				hora = hora +1;
			}
			if(hora == 24){
				hora = 0;
			}
			cantHora = cantHora-1;
		}
		System.out.println(hora);
	}*/
}
