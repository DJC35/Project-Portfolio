
package pti.edu;

/**
 * Abstract class that creates a SoundTrack object for music
 * @author Dylan Connor
 */
public abstract class SoundTrack 
{
    protected String title;
    protected String artist;
    protected String language;
    
    /**
     * Constructs a SoundTrack object using these parameters:
     * @param title
     * @param artist
     * @param language 
     */
    public SoundTrack(String title,
                      String artist,
                      String language)
    {
        this.title = title;
        this.artist = artist;
        this.language = language;
    }
    
    /**
     * Abstract method to retrieve value of title
     * @return 
     */
    public abstract String getTitle();
    
    /**
     * Abstract method to retrieve value of artist
     * @return 
     */
    public abstract String getArtist();
    
    /**
     * Abstract method to retrieve value of language
     * @return 
     */
    public abstract String getLanguage();
}
