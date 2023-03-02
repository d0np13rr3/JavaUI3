package Game.StoryCollection;
import java.util.ArrayList;
public class StorySnippets {

    public static String[] storySnippets() {
        String[] storiesArray;
        ArrayList<String> storySnippets = new ArrayList<String>();
        storySnippets.add("---STORY----\n\n" + "Here you are, entering a strange portal. They say curiousity killed the dog. You had nothing to lose, so you went for it. Dog or no dog.\n"
                          +"\n\n---ACTIONS---\n\n" + "Make one character. He will be in charge of everything, from housing over distribution of wares to head of the groups you will oversee."
        );
        storySnippets.add("---STORY----\n\n" + "Now that you are really here you notice other strange individuals. They all share the feeling of discomfort and unease. You are not alone.\n"
                          +"\n\n---ACTIONS---\n\n" + "Make two more characters."
        );
        storySnippets.add("---STORY----\n\n" + "There is a team now, the fact you found each other made everyone feel real. 'Je pense donc je suis.' There is a need for housing, make money buy fighting and buy your first accommodation.\n"
                          +"\n\n---ACTIONS---\n\n" + "Battle. Make money. Buy a house."
        );
        storiesArray = storySnippets.toArray(new String[0]);
        return storiesArray;
    }


}
