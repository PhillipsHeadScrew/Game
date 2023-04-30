package game.Spells;

import java.util.ArrayList;
import java.util.List;

public abstract class Spell {

    public int manaCost;

    public String name = "                   ";

    public List<String> nameList = new ArrayList<>();

    public List<String> descriptionList = new ArrayList<>();

    public SpellType type;
}
