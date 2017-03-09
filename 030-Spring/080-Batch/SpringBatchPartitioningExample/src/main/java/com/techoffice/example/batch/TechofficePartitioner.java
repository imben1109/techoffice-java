package com.techoffice.example.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class TechofficePartitioner implements Partitioner {

	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();
		for (int i = 1; i <= gridSize; i++) {
			ExecutionContext value = new ExecutionContext();
			value.putString("param1", Integer.toString(i));
			value.putString("param2", Integer.toString(i));
			result.put("partition" + i, value);
		}
		return result;
	}

}
