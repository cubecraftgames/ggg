/*
 * Decompiled with CFR 0.150.
 */
package clientname.mods;

import clientname.FileManager;
import clientname.gui.hud.IRenderer;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.Mod;
import java.io.File;

public abstract class ModDraggable
extends Mod
implements IRenderer {
    protected ScreenPosition pos = this.loadPositionFromFile();

    @Override
    public ScreenPosition load() {
        return this.pos;
    }

    @Override
    public void save(ScreenPosition pos) {
        this.pos = pos;
        this.savePositionToFile();
    }

    private File getFolder() {
        File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
        if (!folder.exists()) {
            folder.mkdirs();
        }
        return folder;
    }

    private void savePositionToFile() {
        FileManager.writeJsonToFile(new File(this.getFolder(), "pos.json"), this.pos);
    }

    private ScreenPosition loadPositionFromFile() {
        ScreenPosition loaded = FileManager.readFromJson(new File(this.getFolder(), "pos.json"), ScreenPosition.class);
        if (loaded == null) {
            this.pos = loaded = ScreenPosition.fromRelativePosition(0.5, 0.5);
            this.savePositionToFile();
        }
        return loaded;
    }

    public final int getLineOffset(ScreenPosition pos, int lineNum) {
        return pos.getAbsoluteY() + this.getLineOffset(lineNum);
    }

    private int getLineOffset(int lineNum) {
        return (ModDraggable.font.FONT_HEIGHT + 3) * lineNum;
    }
}

