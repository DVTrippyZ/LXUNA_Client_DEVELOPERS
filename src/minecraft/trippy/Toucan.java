package trippy;

public class Toucan {

	public static int version = 5;
	public static int prVersion = 20;
	public static int getToucanVersion(boolean VersionIsPublic) {
		
		if(VersionIsPublic) {
		return version; 
		} else {
			return prVersion;
		}
		
	}
}
