package com.letsbegin.core.game;

import com.letsbegin.core.engine.EngineManager;
import com.letsbegin.core.engine.WindowManager;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;

public class Main {

    private static WindowManager window;


    public static void main(String[] args) {
        String version = GLFW.glfwGetVersionString();
        System.out.println("GLFW Version" + version);
        System.out.println(Version.getVersion());
        window = new WindowManager("test", 0, 0, false);
        EngineManager engine = new EngineManager();
        try {
            engine.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}