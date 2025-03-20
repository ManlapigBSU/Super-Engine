plugins {
    id("java")
}

val lwjglVersion = "3.2.3"
val lwjglNatives = "natives-windows"
val jomlVersion = "1.10.0"
val jomlPrimVersion = "1.10.0"

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))

    implementation("org.joml:joml:$jomlVersion")
    implementation("org.joml:joml-primitives:$jomlPrimVersion")

    val lwjglModules = listOf(
        "lwjgl", "lwjgl-assimp", "lwjgl-bgfx", "lwjgl-cuda", "lwjgl-egl",
        "lwjgl-glfw", "lwjgl-jawt", "lwjgl-jemalloc", "lwjgl-libdivide", "lwjgl-llvm",
        "lwjgl-lmdb", "lwjgl-lz4", "lwjgl-meow", "lwjgl-nanovg", "lwjgl-nfd",
        "lwjgl-nuklear", "lwjgl-odbc", "lwjgl-openal", "lwjgl-opencl", "lwjgl-opengl",
        "lwjgl-opengles", "lwjgl-openvr", "lwjgl-opus", "lwjgl-ovr", "lwjgl-par",
        "lwjgl-remotery", "lwjgl-rpmalloc", "lwjgl-shaderc", "lwjgl-sse",
        "lwjgl-stb", "lwjgl-tinyexr", "lwjgl-tinyfd", "lwjgl-tootle", "lwjgl-vma",
        "lwjgl-vulkan", "lwjgl-xxhash", "lwjgl-yoga", "lwjgl-zstd"
    )

    lwjglModules.forEach { module ->
        implementation("org.lwjgl:$module")
        runtimeOnly("org.lwjgl:$module::$lwjglNatives")
    }
}

tasks.test {
    useJUnitPlatform()
}
