package intent;

public class Toucan {

	public static int version = 1;
	public static int prVersion = 12;
	public static int toucanVersion(boolean VersionIsPublic) {
		
		if(VersionIsPublic) {
		return version; 
		} else {
			return prVersion;
		}
		
	}
}
