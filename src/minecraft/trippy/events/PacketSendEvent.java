package trippy.events;

import net.minecraft.network.Packet;

public class PacketSendEvent extends Event{

	
	    public Packet packet;
	    
	    
	    public PacketSendEvent(Packet packet)
	    {
		
		this.packet = packet;
	    }
	
}

