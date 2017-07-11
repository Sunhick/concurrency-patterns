package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MathCompute extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private final int threshold = 16;
	private int workload;

	public MathCompute(int wl) {
		workload = wl;
	}

	@Override
	protected Long compute() {
		// based on threadhold you can subdivide the task into smaller chunks
		if (workload > threshold) {
			// create subtasks.
			List<MathCompute> subtasks = new ArrayList<MathCompute>();
			subtasks.addAll(createSubtasks());

			subtasks.forEach(t -> t.fork());
			
			// merge the sub-tasks results to create a result for whole task.
			Long result = new Long(0);
			for(MathCompute subtask : subtasks) {
                result += subtask.join();
            }
			return result;
		} else {
			// do the actual work
			System.out.println("running the tasks.");
			return 5L;
		}
	}

	private List<MathCompute> createSubtasks() {
		List<MathCompute> subtasks = new ArrayList<MathCompute>();

		// reduce the workload by some factor since we created subtasks.
		// double factor = .5;
		// workload *= factor;
		MathCompute subtask1 = new MathCompute(this.workload / 2);
		MathCompute subtask2 = new MathCompute(this.workload / 2);

		subtasks.add(subtask1);
		subtasks.add(subtask2);

		return subtasks;
	}
}