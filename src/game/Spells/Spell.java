package game.Spells;

import java.util.ArrayList;
import java.util.List;

public abstract class Spell {

    protected int manaCost;

    public String name = "                   ";

    public List<String> nameList = new ArrayList<>();

    protected SpellType type;
}
