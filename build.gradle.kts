plugins {
    id("com.github.minigdx.jvm") version "1.0.0"
    id("com.github.minigdx.js") version "1.0.0"
    id("com.github.minigdx.common") version "1.0.0"
}

minigdx {
    jvm.mainClass.set("your.game.Main")
}
