package com.concurrent;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * BlockingDequeDemo
 * 
 * BlockingDeque is an interface. It's implementations are -
 * 		LinkedBlockingDeque
 */
public class BlockingDequeDemo {
	private BlockingDeque<Integer> queue = new LinkedBlockingDeque<Integer>();
}
