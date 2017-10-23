
package pti.edu;

/**
 * Creates an EtuneSoundTrack object using parent class SoundTrack,
 * and interface Etune
 * @author Dylan Connor
 */
public class EtuneSoundTrack extends SoundTrack implements Etune
{
    protected int encryption;
    
    /**
     * Constructs an EtuneSoundTrack object using given parameters:
     * @param title
     * @param artist
     * @param language
     * @param encryption 
     */
    public EtuneSoundTrack(String title,
                           String artist,
                           String language,
                           int encryption)
    {
        super(title,
              artist,
              language);
        this.encryption = encryption;
    }
    
    /**
     * Retrieves value of title+
     * @return 
     */
    public String getTitle(){return title;}
    
    /**
     * Retrieves value of artist
     * @return 
     */
    public String getArtist(){return artist;}
    
    /**
     * Retrieves value of language
     * @return 
     */
    public String getLanguage(){return language;}
    
    /**
     * Retrieves value of encryption
     * @return 
     */
    public int getEncryption(){return encryption;}
}
