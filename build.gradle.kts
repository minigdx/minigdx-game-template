plugins {
    id("com.github.minigdx.jvm") version "LATEST-SNAPSHOT"
    id("com.github.minigdx.js") version "LATEST-SNAPSHOT"
    id("com.github.minigdx.common") version "LATEST-SNAPSHOT"
}

minigdx {
    jvm.mainClass.set("your.game.Main")
}
