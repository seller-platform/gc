package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author choic
 * @since 2021/12/08
 */
@Controller
public class HelloController {
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < 999999999; i++) {
			int[] a = new int[10000000];

			/**
			 * gc ---> 사용되지않는 것들 clean.
			 * 사용중인 것 : from -> to  (minor)
			 */
			list.add(new int[1000000]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return "hello";
	}
}


/*
 program .... bootapp -> log? ->  gc?
 */