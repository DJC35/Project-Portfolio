
package pti.edu;

/**
 * Creates a DVDSoundTrack object using parent class SoundTrack,
 * and interface DVD
 * @author Dylan Connor
 */
public class DVDSoundTrack extends SoundTrack implements DVD
{
    protected String format;
    
    /**
     * Constructs a DVDSoundTrack object with given parameters:
     * @param title
     * @param artist
     * @param language
     * @param format 
     */
    public DVDSoundTrack(String title,
                         String artist,
                         String language,
                         String format)
    {
        super(title,
              artist,
              language);
        this.format = format;
    }
    
    /**
     * Retrieves value of title
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
     * Retrieves value of format
     * @return 
     */
    public String getFormat(){return format;}
}
