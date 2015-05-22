package cube.pets.utils;

import org.bukkit.util.ChatPaginator;

/**
 * Created by mike1665 on 5/21/2015.
 * Check out my Twitter for recent updates.
 *
 * @DevvMike
 */
public class CenterText {

    public static String centerText(String s) {
        String FINAL = "";
        int lineWidth = ChatPaginator.AVERAGE_CHAT_PAGE_WIDTH;
        int stringWidth = s.length();
        int spacesToSide = lineWidth - stringWidth;
        int divided = spacesToSide / 2;

        for (int i = 0; i < divided; i++) {
            FINAL = FINAL + " ";
        }

        FINAL = FINAL + s;

        for (int i = 0; i < divided; i++) {
            FINAL = FINAL + " ";
        }

        return FINAL;
    }
}
