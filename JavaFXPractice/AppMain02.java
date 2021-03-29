package com.fx;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain02 extends Application {
	
	// 2. 기본 생성자 호출
	public AppMain02() {
		System.out.println(Thread.currentThread().getName() + " : AppMain02() 호출");
	}
	
	/*
	 * 3. init()메소드 호출 init은 ui설계를 하면 안됩니다. javafx-launcher이기 때문에
	 */
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : init() 호출");
	}
	
	// start 호출
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + " : start() 호출");
		primaryStage.show();
	}
	// stop 호출
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : stop() 호출");
	}
	
	// 1.
	public static void main(String[] args) {
		launch(args);
	}

}
