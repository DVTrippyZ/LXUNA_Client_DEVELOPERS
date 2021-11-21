package net.minecraft.network;

public class TimerD {

	public long time;

	public TimerD() {
		this.time = (System.nanoTime() / 1000000l);
	}

	public boolean hasTimeElapsed(long time, boolean reset) {
		if (getTime() >= time) {
			if (reset) {
				reset();
			}
			return true;
		}
		return false;
	}

	public long getTime() {
		return System.nanoTime() / 1000000l - this.time;
	}

	public void reset() {
		this.time = (System.nanoTime() / 1000000l);
	}
}
