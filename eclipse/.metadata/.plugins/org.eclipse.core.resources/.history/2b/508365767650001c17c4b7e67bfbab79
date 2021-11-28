package intent.modules.movement;

import java.lang.reflect.InvocationTargetException;

public abstract class ThisEvent {

	private boolean cancelled;

	public enum State {
		PRE("PRE", 0), POST("POST", 1);
		private State(String string, int number) {
		}
	}

	

	public boolean isCancelled() {
		return this.cancelled;
	}

	public void setCancelled(boolean cancelled) {

		this.cancelled = cancelled;
	}

	
}
