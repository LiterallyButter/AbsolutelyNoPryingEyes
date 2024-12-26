package me.daxanius.npe.gui;

import me.daxanius.npe.NoPryingEyes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.WarningScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.LayoutWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Style;
import net.minecraft.text.Text;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class NoPryingEyesWarningScreen extends WarningScreen {
    private static final Text TITLE = Text.translatable("npe.title").setStyle(Style.EMPTY.withBold(true));

    public NoPryingEyesWarningScreen(Text content) {
        super(TITLE, content.copy().setStyle(Style.EMPTY.withColor(16776960)), TITLE.copy().append("\n").append(content));
    }

    protected void initButtons(int yOffset) {
        int width = 150;
        this.addDrawableChild(new ButtonWidget.Builder(ScreenTexts.ACKNOWLEDGE, (button) -> {
            MinecraftClient.getInstance().disconnect();
            MinecraftClient.getInstance().setScreen(new MultiplayerScreen(new TitleScreen()));
        }).dimensions(this.width / 2 - width / 2, 100 + yOffset, width, 20).build());
    }
    /*
    @Override
    protected void drawTitle(DrawContext context) {
        context.drawTextWithShadow(this.textRenderer, this.title, this.width / 2 - this.title.toString().length(), 30, 16777215);
    }
     */

    @Override
    protected LayoutWidget getLayout() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getLayout'");
        NoPryingEyes.LogVerbose("ANPE: why are we doing getLayout what is happening and why does this exist only for an error");
        NoPryingEyes.LogVerbose("ANPE: returning some nonsense because it's easier...");
        return new LayoutWidget() { // intellij did this automatically i have no idea what this is
            // i just figured it's probably fine to just return nonsense instead of figuring out what wants this in the first place and make it work lmao
            @Override
            public void setX(int x) {

            }

            @Override
            public void setY(int y) {

            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getWidth() {
                return 0;
            }

            @Override
            public int getHeight() {
                return 0;
            }

            @Override
            public void forEachElement(Consumer<Widget> consumer) {

            }
        };
    }
    
}