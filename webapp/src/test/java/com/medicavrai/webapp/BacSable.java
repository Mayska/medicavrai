package com.medicavrai.webapp;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class BacSable {

	public static void main(String[] args) {
		try {
			float sampleRate = (float) 40000;
			extracted(sampleRate);
			for (int i = 0; i < 50; i++) {
				System.out.println("i=" + i);
				i++;
				extracted(sampleRate);
				sampleRate = sampleRate + 2050;
				String valueOf = String.valueOf(sampleRate);
				System.out.println("i=" + i + " et sampleRate=" + valueOf);
			}
		} catch (

		LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	private static void extracted(float sampleRate) throws LineUnavailableException {
		byte[] buf = new byte[1];

		AudioFormat af = new AudioFormat(sampleRate, 8, 1, true, false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		sdl.open();
		sdl.start();
		for (int i = 0; i < 1000 * (float) 44100 / 1000; i++) {
			double angle = i / ((float) 44100 / 440) * 2.0 * Math.PI;
			buf[0] = (byte) (Math.sin(angle) * 100);
			sdl.write(buf, 0, 1);
		}
		sdl.drain();
		sdl.stop();
	}

}
