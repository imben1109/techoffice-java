package com.ittechoffice.example.sse;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SseEmitterManager {
	private List<SseEmitter> sseEmitters;
	
	public SseEmitterManager(){
		sseEmitters = new ArrayList<SseEmitter>();
	}
	
	public SseEmitter createEmitter(){
		SseEmitter sseEmitter = new SseEmitter();
		SseEmitterPurgeJob job = new SseEmitterPurgeJob(sseEmitter);
		sseEmitter.onCompletion(job);
		sseEmitter.onTimeout(job);
		sseEmitters.add(sseEmitter);
		System.out.println(String.format("Now, there are %d emitters", sseEmitters.size()));
		return sseEmitter;
	}
	
	public void send(String message) throws IOException{
		for (SseEmitter sseEmitter: sseEmitters){
			sseEmitter.send(message);
		}
	}
	
	private class SseEmitterPurgeJob implements Runnable {
		private SseEmitter sseEmitter;
		public SseEmitterPurgeJob(SseEmitter sseEmitter){
			this.sseEmitter = sseEmitter;
		}
		@Override
		public void run(){
			System.out.println("SSE Emitter Timeout / Completed");
			sseEmitters.remove(sseEmitter);
		}
	}
}
