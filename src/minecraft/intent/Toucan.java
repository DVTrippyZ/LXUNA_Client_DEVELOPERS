package intent;

public class Toucan {

	public static int version = 1;
	public static int prVersion = 11;
	public static int toucanVersion(boolean VersionIsPublic) {
		
		if(VersionIsPublic) {
		return version; 
		} else {
			return prVersion;
		}
		
	}
}
