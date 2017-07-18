package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings("serial")
public class WriteToDisk extends RecursiveAction {

	private final int threshold = 16;
	private int workload;

	public WriteToDisk(int wl) {
		workload = wl;
	}

	@Override
	protected void compute() {
		// based on threadhold you can subdivide the task into smaller chunks
		if (workload > threshold) {
			// create subtasks.
			List<WriteToDisk> subtasks = new ArrayList<WriteToDisk>();
			subtasks.addAll(createSubtasks());
			
			subtasks.forEach(t -> t.fork());
		} else {
			// do the actual work
			System.out.println("running the tasks.");
		}
	}

	private List<WriteToDisk> createSubtasks() {
		List<WriteToDisk> subtasks = new ArrayList<WriteToDisk>();

		// reduce the workload by some factor since we created subtasks.
		// double factor = .5;
		// workload *= factor;
		WriteToDisk subtask1 = new WriteToDisk(this.workload / 2);
		WriteToDisk subtask2 = new WriteToDisk(this.workload / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}
}